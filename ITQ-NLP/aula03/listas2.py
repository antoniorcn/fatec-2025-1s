# indice 0  1  2  3  4   5   6   7   8   9   10 
lista = [1, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30]

print( lista[0:7:2] )

print( "Ultimo: ", lista[-1])
print( "Penultimo: ", lista[-2])
print( "Antipenultimo: ", lista[-3])

print("Lista invertida")
print(lista[::-1])

# lista2 = lista    # Mesma area de memoria
lista2 = lista.copy() # Cria uma copia da lista
lista[ 3 ] = 500


print("Lista 1", lista)
print("Lista 2", lista2)