from sklearn.feature_extraction.text import CountVectorizer
texto = """rato roeu a roupa do rei de Roma,
O rato roeu a roupa do rei da Rússia,
O rato roeu a roupa do RodovaIho...
O rato a roer roía
E a rosa Rita Ramalho do rato a roer se ria.
O rato roeu a roupa do rei de roma
a rainha com raiva roeu o resto."""

outro_texto = """O rato roeu a roupa do rei de Roma"""

vetorizador = CountVectorizer()
bag_of_words_binario = vetorizador.fit_transform([texto, outro_texto])
vocabulario = vetorizador.get_feature_names_out()
print("Vocabulario: ", vocabulario)
print("Bag Of Words Binario: ", bag_of_words_binario.toarray())

