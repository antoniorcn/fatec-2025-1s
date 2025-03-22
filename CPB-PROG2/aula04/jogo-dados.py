from random import randint

numero = int(input("Digite um numero entre 1 e 6: "))  # texto (string)
sorteado = randint( 1, 6 )  # numero  (int)

print( "O numero sorteado foi: ", sorteado )

if numero == sorteado:
    print("Parabens, você acertou!")
else:
    print("Que pena, você errou!")

