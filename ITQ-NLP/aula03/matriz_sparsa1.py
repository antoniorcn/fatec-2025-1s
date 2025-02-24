from scipy.sparse import coo_matrix

matriz1 = [
    [0, 0, 0, 0, 10],
    [0, 0, 20, 11, 0],
    [0, 60, 0, 1, 0],
    [4, 0, 2, 0, 10],
    [0, 5, 0, 8, 0],
]

matriz1_sparsa_coo = coo_matrix( matriz1 )

print( "Matriz1 Original: ", matriz1)
print( "Matriz1 Sparsa (formato COO): ", matriz1_sparsa_coo )
