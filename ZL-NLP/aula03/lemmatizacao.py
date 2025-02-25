import spacy
nlp = spacy.load('pt_core_news_sm')

texto = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

lematizado = []
doc = nlp(texto)
for token in doc:
    print(token.text, token.lemma_, token.pos_)
    lematizado.append(token.lemma_)

print("Texto Original: ", texto)
print("Texto Lemmatizado: ",  " ".join(lematizado))
