import math


a = [10, 20, 30, 40]
print( a )

def mais_2( x ):
    return x + 2

def quadrado( x ):
    return x ** 2

b = list(map( lambda j: math.sqrt(j), a))
print( b )
c = list(map( lambda x: x ** 2, b))
print( c )

# for number in a:
#     print( number ** 2)