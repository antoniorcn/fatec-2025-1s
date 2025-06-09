from fastapi import FastAPI, Request
import tensorflow as tf
import pickle
import numpy as np
from pydantic import BaseModel
from tensorflow.keras.utils import pad_sequences


contraction_dict = {
    "aren't": "are not",		"can't": "can not",		"could've": "could have",
    "couldn't": "could not",	"daren't": "dare not",	"didn't": "did not",
    "doesn't": "does not",		"don't": "do not",		"hadn't": "had not",
    "hasn't": "has not",		"haven't": "have not",	"he's": "he is",
    "how'd": "how had",			"how're": "how are",	"how's": "how is",
    "how've": "how have",		"i'd": "i had",			"i'm": "i am",
    "i've": "i have",			"isn't": "is+ not",		"it's": "it is",
    "might've": "might have",	"mightn't": "might not",	"must've": "must have",
    "mustn't": "must not",		"needn't": "need not",	"oughtn't": "ought not",
    "shan't": "shall not",		"she'd": "she had",		"she's": "she is",
    "should've": "should have",	"shouldn't": "should not",	"that'd": "that had",
    "that's": "that is",		"there'd": "there had",	"there's": "there is",
    "they'd": "they had",		"they're": "you are",	"they've": "they have",
    "wasn't": "was+ not",		"we'd": "we had",		"we're": "we are",
    "we've": "we have",			"weren't": "were not",	"what'd": "what had",
    "what're": "what are",		"what's": "what is",	"what've": "what have",
    "when'd": "when had",		"when're": "when are",	"when's": "when is",
    "when've": "when have",		"where'd": "where had",	"where're": "where are",
    "where's": "where is",		"where've": "where have",	"who'd": "who had",
    "who're": "who are",		"who's": "who is",		"who've": "who have",
    "why'd": "why had",			"why're": "why are",	"why's": "why is",
    "why've": "why have",		"would've": "would have",	"wouldn't": "would not",
    "you're": "you are",		"you've": "you have",	"'cause": "because", 
    "ain't": "is not", 			"aren't": "are not",	"can't": "cannot", 
    "could've": "could have",	"he's": "he is",		"how'll": "how will",
    "i'll": "i will",			"it'll": "it will",		"it's": "it is", 
    "she'll": "she will",		"she's": "she is",		"that'll": "that will",
    "there'll": "there will",	"they'll": "they will",	"they're": "they are",
    "we'll": "we will",			"we're": "we are",		"what'll": "what will",
    "when'll": "when will",		"where'll": "where will",	"who'll": "who will",
    "yo're": "you are",			"you'll": "you will"
}
PADDING_POSITION = "pre"
maximo_palavras = 22
app = FastAPI()


with open("tokenizer.pkl", "rb") as arquivo_tokenizer:
    tokenizer = pickle.load( arquivo_tokenizer )

modelo = tf.keras.models.load_model("chat_bot_modelo.keras")
modelo_encoder = tf.keras.models.load_model("chat_bot_modelo_encoder.keras")
modelo_decoder = tf.keras.models.load_model("chat_bot_modelo_decoder.keras")

class ChatInput(BaseModel):
    mensagem : str

class ChatOutput(BaseModel):
    resposta : str

def pre_processa_texto( texto ):
    global contraction_dict
    tokens = texto.lower().split(" ")
    novos_tokens = []
    for token in tokens:
        if token in contraction_dict:
            token = contraction_dict[token]
        novos_tokens.append(token)
    return " ".join(novos_tokens)

def chat_bot( texto, max_words = 10  ):
    texto_processado = pre_processa_texto( texto )
    persona_a_sequencia = tokenizer.texts_to_sequences( [texto_processado.lower()] )
    persona_a_padded = pad_sequences( persona_a_sequencia, maxlen=maximo_palavras, padding=PADDING_POSITION)

    state_value = modelo_encoder.predict( persona_a_padded )

    target_text = "<BOS>"
    target_sequence = np.array(tokenizer.texts_to_sequences([target_text]))
    print("target_sequence: ", target_sequence)
    final_sentenca = False
    sentenca = ""
    counter = 0
    while not final_sentenca and counter < max_words:    # texto for diferente de <EOS>
        # target_padded = pad_sequences( target_sequence, maxlen=saida_maximo_palavras, padding="pre")
        # print("Decode: ", [target_sequence] + state_value)
        tokens_ouput, decoder_state_h2, decoder_state_c2 = modelo_decoder.predict([target_sequence] + state_value)
        state_value = [decoder_state_h2, decoder_state_c2]
        token_provavel = np.argmax(tokens_ouput[0, -1, :])
        texto_provavel = tokenizer.sequences_to_texts( [[token_provavel]] )
        # print("Token Provavel: ", token_provavel, "Texto Provavel: ", texto_provavel)
        # print("Target Sequence: ", target_sequence)
        # print("Sentenca: ", sentenca)
        if texto_provavel[0] == "<eos>": 
            final_sentenca = True
        else: 
            if texto_provavel[0] != "<oov>":
                sentenca += (texto_provavel[0] + " ")
            target_text = target_text + " " + texto_provavel[0]
            target_sequence = np.array(tokenizer.texts_to_sequences([target_text]))
            counter += 1
    return sentenca

print("Servidor Backend com Chat ativo")

@app.post("/chat", response_model=ChatOutput)
async def chat(input_data : ChatInput):
    resposta = chat_bot(input_data.mensagem)
    return {"resposta": resposta}
