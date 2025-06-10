import pickle
import numpy as np
import tensorflow as tf
import string
from fastapi import FastAPI
from pydantic import BaseModel
from unidecode import unidecode

from tensorflow.keras.utils import pad_sequences

maximo_palavras_perguntas = 23

contraction_dict = {
    "aren't": "are not", "can't": "can not", "could've": "could have",
    "couldn't": "could not", "daren't": "dare not", "didn't": "did not",
    "doesn't": "does not", "don't": "do not", "hadn't": "had not",
    "hasn't": "has not", "haven't": "have not", "he's": "he is",
    "how'd": "how had", "how're": "how are", "how's": "how is",
    "how've": "how have", "i'd": "i had", "i'm": "i am",
    "i've": "i have", "isn't": "is+ not", "it's": "it is",
    "might've": "might have", "mightn't": "might not", "must've": "must have",
    "mustn't": "must not", "needn't": "need not", "oughtn't": "ought not",
    "shan't": "shall not", "she'd": "she had", "she's": "she is",
    "should've": "should have", "shouldn't": "should not", "that'd": "that had",
    "that's": "that is", "there'd": "there had", "there's": "there is",
    "they'd": "they had", "they're": "you are", "they've": "they have",
    "wasn't": "was+ not", "we'd": "we had", "we're": "we are",
    "we've": "we have", "weren't": "were not", "what'd": "what had",
    "what're": "what are", "what's": "what is", "what've": "what have",
    "when'd": "when had", "when're": "when are", "when's": "when is",
    "when've": "when have", "where'd": "where had", "where're": "where are",
    "where's": "where is", "where've": "where have", "who'd": "who had",
    "who're": "who are", "who's": "who is", "who've": "who have",
    "why'd": "why had", "why're": "why are", "why's": "why is",
    "why've": "why have", "would've": "would have", "wouldn't": "would not",
    "you're": "you are", "you've": "you have", "'cause": "because",
    "ain't": "is not", "how'll": "how will",
    "i'll": "i will", "it'll": "it will",
    "she'll": "she will", "that'll": "that will",
    "there'll": "there will", "they'll": "they will",
    "we'll": "we will", "what'll": "what will",
    "when'll": "when will", "where'll": "where will", "who'll": "who will",
    "yo're": "you are", "you'll": "you will"
}

pontuacoes_remover = string.punctuation
pontuacoes_remover = pontuacoes_remover.replace("?", "")

app = FastAPI()

class MessageInput(BaseModel):
    mensagem : str

class MessageOutput(BaseModel):
    resposta : str

with open("./tokenizer.pkl", "rb") as arquivo_tokenizer:
    tokenizer = pickle.load(arquivo_tokenizer)

model = tf.keras.models.load_model("modelo_geral.keras")
encoder_model = tf.keras.models.load_model("modelo_encoder.keras")
decoder_model = tf.keras.models.load_model("modelo_decoder.keras")

def limpar_trocar_contracoes( texto ):
    novas_palavras = []
    mascara = str.maketrans("\n\r\t", "   ", pontuacoes_remover)
    texto_minusculo = texto.lower()
    lista_palavras = texto_minusculo.split(" ")
    for palavra in lista_palavras:
        if palavra in contraction_dict:
            palavra = contraction_dict[palavra]
        novas_palavras.append(palavra)
    novo_texto =  " ".join(novas_palavras) 
    texto_limpo = novo_texto.translate(mascara)
    texto_limpo = unidecode(texto_limpo)
    return texto_limpo


def gerar_frase( frase_entrada ):
    frase_limpa = limpar_trocar_contracoes(frase_entrada)
    sequence = tokenizer.texts_to_sequences([frase_limpa])
    padded_sequence = pad_sequences(sequence, maxlen=maximo_palavras_perguntas, padding='post')
    state_values = encoder_model.predict(padded_sequence)
    palavra_start = tokenizer.word_index["<start>"]
    indice_palavra = palavra_start
    frase_saida = ""
    while True:
        target_sequence = np.zeros((1, 1))
        target_sequence[0, 0] = indice_palavra
        dec_output, saida_state_h, saida_state_c = decoder_model.predict([target_sequence] + state_values)
        state_values = [saida_state_h, saida_state_c]
        indice_palavra = np.argmax(dec_output[0, -1, :])
        if indice_palavra == 4:
            break
        palavra_saida = tokenizer.sequences_to_texts([[indice_palavra]])[0]
        frase_saida = frase_saida + " " + palavra_saida
    return frase_saida



@app.post("/chat")
def chat( entrada : MessageInput ) -> MessageOutput:
    frase = gerar_frase( entrada.mensagem )
    return {"resposta": frase}
    
