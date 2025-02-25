import nltk
from nltk.stem import RSLPStemmer
from nltk.tokenize.destructive import NLTKWordTokenizer

texto = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""


tokenizer = NLTKWordTokenizer()
tokens = tokenizer.tokenize(texto)
print(tokens)

stemmer = RSLPStemmer()
stemmed = []
for token in tokens:
    stem_token = stemmer.stem(token)
    print(token, stem_token)
    stemmed.append(stem_token)

print("Texto Original: ", texto)
vocabulario = set(tokens)
vocabulario_size = len(vocabulario)
print("Tamanho do Vocabulario (Texto Original): ", vocabulario_size)

print("Texto Stemmed: ", " ".join(stemmed))
vocabulario_stemmed = set(stemmed)
vocabulario_stemmed_size = len(vocabulario_stemmed)
print("Tamanho do Vocabulario (Texto Stemmed): ", vocabulario_stemmed_size)


