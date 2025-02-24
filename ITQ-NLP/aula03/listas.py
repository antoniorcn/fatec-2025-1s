# lista = []

# for i in range(1001):
#     lista.append(i)

# print(lista)


# lista = [i for i in range(1001)]
# print(lista)

# Criar 3 x 4 usando listas com numeros 1 e 0

matriz = [ 
    [1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 0, 1]
]

# Criar uma matriz de zeros com 10 linhas e 20 colunas
# matriz = []
# for numero_linha in range(10):
#     linha = []
#     for numero_coluna in range(20):
#         linha.append(0)
#     matriz.append(linha)

# matriz = [ [1, 0, 1, 0] for i in range(4) ]
# print(matriz)

# Matriz do tabuleiro de xadrez 8x8

# matriz = [
#     [0, 1, 0, 1 ... ],
#     [1, 0, 1, 0 ...],
#     [0, 1, 0, 1 ... ],
#     [1, 0, 1, 0 ...],
# ...
# ]

# tabuleiro = []
# # casa = 0
# for numero_linha in range(8):
#     linha = []
#     for numero_coluna in range(8):
#         casa = (numero_linha + numero_coluna) % 2
#         linha.append(casa)
#         # if casa == 0:
#         #     casa = 1
#         # else:
#         #     casa = 0
#     tabuleiro.append(linha)
#     # if casa == 0:
#     #     casa = 1
#     # else:
#     #     casa = 0

tabuleiro = [[ (coluna + linha) % 2  for coluna in range(8)] for linha in range(8)]
print(tabuleiro)