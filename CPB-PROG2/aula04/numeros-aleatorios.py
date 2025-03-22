from random import random

numero_aleatorio = random()

print("Numero gerado: ", numero_aleatorio)

escala_100 = numero_aleatorio * 100
print("Mesmo numero na escala entre 0 e 100: ", escala_100)

escala_110_310 = (numero_aleatorio * 200) + 110
print("Mesmo numero na escala entre 110 e 310: ", escala_110_310)
