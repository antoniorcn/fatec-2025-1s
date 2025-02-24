import spacy

nlp = spacy.load("pt_core_news_sm")

texto = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

print("Texto: ", texto)

doc = nlp(texto)
texto__lemmatizado = []
for token in doc:
    lemma = token.lemma_.lower()
    texto__lemmatizado.append(lemma)

print("Texto lemmatizado: ", " ".join(texto__lemmatizado))
