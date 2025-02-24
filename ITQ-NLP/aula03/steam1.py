import re
from sklearn.feature_extraction.text import CountVectorizer
import nltk
from nltk.stem import RSLPStemmer

nltk.download('rslp')

texto = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

def stem_regex( textos ):
    padrao = r'(?:lhos|lhas|lho|lha|de|os|as|o|a|eu|s|ar|er|ir|or|ur|ia)\b'
    palavras = textos.lower().split()
    nova_lista = []
    for palavra in palavras:
        resultado = re.sub(padrao, '', palavra)
        nova_lista.append(resultado)
    return " ".join(nova_lista)


def stem_rslp( textos ):
    palavras = textos.lower().split()
    stemmer = RSLPStemmer()
    nova_lista = []
    for palavra in palavras:
        resultado = stemmer.stem(palavra)
        nova_lista.append(resultado)
    return " ".join(nova_lista)


texto_stem = stem_rslp(texto)

vectorizer = CountVectorizer()
transf1 = vectorizer.fit_transform([texto])
vocab1 = vectorizer.get_feature_names_out()

transf2 = vectorizer.fit_transform([texto_stem])
vocab2 = vectorizer.get_feature_names_out()

print("**********Texto original:*********")
print(f"Vocabulario ({len(vocab1)}): {vocab1}")
print(texto)
print("**********Texto com stem:*********")
print(f"Vocabulario ({len(vocab2)}): {vocab2}")
print(texto_stem)
