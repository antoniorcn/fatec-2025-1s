"""Modulo de operadores """ 

valor = 125 ** (1/3)
print( f"Valor: {valor}" )



# (dividendo) 20   |__3___    (divisor)
#    (resto)  2     6        (quociente)

resultado = 20 / 3
print( f"Resultado da divisão comum: {resultado}" )


resultado = 20 // 3
print( f"Resultado da divisão inteira: {resultado}" )


resultado = 20 % 3
print( f"Resultado da divisão (resto): {resultado}" )


class Aluno:
    ra : str
    nome : str

    def __init__(self, ra, nome):
        self.ra = ra
        self.nome = nome

    def __add__(self, outro):
        novo_ra = self.ra + " - " + outro.ra
        novo_nome = self.nome + " - " + outro.nome
        return Aluno(novo_ra, novo_nome)
    
j = Aluno("1111", "João Silva")
m = Aluno("2222", "Maria Silva")

o = j + m
print( f"RA: {o.ra} - Nome: {o.nome}" )



numero = 10

faixa_inicio = 20
faixa_fim = 100

if numero > faixa_inicio and numero < faixa_fim:
    print(f"O numero {numero} esta dentro da faixa")
else:
    print(f"O numero {numero} esta fora da faixa")



numero = 10
numero = numero + 1    # numero += 1
numero = numero / 5   # numero /= 5


numero = 5
lista = [0, 5, 10, 15, 20, 25, 30, 35]

if numero in lista:
    print(f"O numero {numero} esta na lista")
else:
    print(f"O numero {numero} não esta na lista")


lista = [10, 20, 30]
a = lista
b = lista.copy()


print(f"Lista: ({lista})")
print(f"a: ({a})")
print(f"b: ({b})")

if a is lista:
    print("a é o mesmo objeto da lista")
else:
    print("a não é o mesmo objeto da lista")

if b is lista:
    print("b é o mesmo objeto da lista")
else:
    print("b não é o mesmo objeto da lista")
