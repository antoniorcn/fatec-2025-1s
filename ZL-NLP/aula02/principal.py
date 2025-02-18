from biblioteca import somar

textao = """ Meu primeiro texto 
com várias linhas
outra linha "aqui tem aspas duplas" 
"""

soma = 10 + 20 + 30 + 40 + 50 + 60 + 70 + 80 + 90 + 100 + 110 + 120 + 130 + 140 + 150 + 160 + 170 + 180 + 190 + 200

print("Codigo principal")
print(somar.__doc__)
resultado = somar(5, 8)

print( f"O resultado é: {resultado * 2}")

for numero in range(1, 10):
    print( "Numero: ")
    print( numero )
    print("--------------")
print(" Isto esta fora do bloco de codigo do for")

a = somar(10, 20)
print( "10 em bytes: ", a.to_bytes(2, 'big'))
