from random import random, seed, randint

# seed(100)
n1 = random()
# inteiro entre 200 e 500
n1_inteiro = int(n1 * 300) + 200
print(f"Numero aleatorio (1): {n1}")
print(f"Numero aleatorio inteiro (1): {n1_inteiro}")

n2 = random()
print(f"Numero aleatorio (2): {n2}")

n3 = random()
print(f"Numero aleatorio (3): {n3}")


n2_inteiro = randint(100, 150)
print(f"Numero aleatorio inteiro (2): {n2_inteiro}")


