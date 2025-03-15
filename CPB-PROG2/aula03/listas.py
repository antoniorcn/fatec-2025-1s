# a1 = 1.73
# a2 = 1.84
# a3 = 1.62

# print( a1 )
# print( a2 )
# print( a3 )

#           0     1     2
alturas = [1.73, 1.84, 1.62]

print("Antes da ordenação: ", alturas)
print("1o elemento: ", alturas[0])
alturas[2] = 1.68
alturas.sort()
print("Depois da ordenação: ", alturas)
print("1o elemento: ", alturas[0])
