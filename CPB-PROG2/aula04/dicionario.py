mario = {
    "vida": 5,
    "moedas": 0,
    "moedas_yoshi": 0,
    "altura": "pequeno",
    "forca": "fraco",
    "altura_pulo": "pequeno"
} 

print( "O mario tem: ", mario["moedas"], " moedas")


print("Mario acho uma moeda")
mario["moedas"] = mario["moedas"] + 1
print( "O mario tem: ", mario["moedas"], " moedas")

print("Mario foi acertado pela tartaruga")
mario["vida"] = mario["vida"] - 1
print( "O mario tem agora: ", mario["vida"], " vidas")

mario["vida"] = 10

print( "Chaves do Mario: ", mario.keys() )
print( "Valores do Mario: ", mario.values() )
print( "Items do Mario: ", mario.items() )
