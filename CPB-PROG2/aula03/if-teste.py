print("Informe um numero: ")
numero1 = int( input() )
print("Informe outro numero: ")
numero2 = int( input() )

print("Voce digitou no 1o numero o valor: ", numero1)
print("Voce digitou no 2o numero o valor: ", numero2)

soma = numero1 + numero2
print("A soma dos numeros é: ", soma)

print("Codigo antes da bifurcação")
if numero1 > numero2:
    print("O numero: ", numero1, " é o maior numero digitado")
else:
    print("O numero: ", numero2, " é o maior numero digitado")
print("Codigo depois da bifurcação")

# if numero2 > numero1:
#     print("O numero: ", numero2, " é o maior numero digitado")

