mario = {
    "linha": 0,
    "coluna": 0,
    "vida": 5,
    "moedas": 0,
    "moedas_yoshi": 0,
    "altura": "pequeno",
    "forca": "fraco",
    "altura_pulo": "pequeno"
}

mapa = [
    [' ', ' ', 'f', ' ', 't', ' ', 'm', 'm'],
    [' ', 'f', 'f', 'f', ' ', ' ', 'm', 'm'],
    ['f', 'f', 'f', 'f', 'f', 't', ' ', ' '],
    [' ', 'f', 'f', 'f', ' ', ' ', 't', ' '],
    [' ', ' ', 'f', ' ', ' ', ' ', ' ', ' '],
    [' ', 't', 'm', 'm', 'm', 't', ' ', ' '],
    ['t', 'm', 'm', 'm', 'p', 'm', ' ', 't'],
    ['m', 'm', 'm', 'm', 'm', 'm', 'm', ' ']
]


def ganhar_vida():
    """Função que incrementa a vida do Mario em 1"""
    print("Mario ganhou uma vida")
    mario["vida"] = mario["vida"] + 1


def perder_vida():
    """Função que decrementa a vida do Mario em 1"""
    print("Mario perdeu uma vida")
    mario["vida"] = mario["vida"] - 1

def ganhar_moeda():
    """Função que incrementa a quantidade de moedas do Mario em 1"""
    print("Mario encontrou uma moeda")
    mario["moedas"] = mario["moedas"] + 1

def ganhar_moeda_yoshi():
    """Função que incrementa a quantidade de moedas do tipo Yoshi do Mario em 1"""
    print("Mario encontrou uma moeda do tipo Yoshi")
    mario["moedas_yoshi"] = mario["moedas_yoshi"] + 1
    print("Agora ele tem", mario["moedas_yoshi"], "moedas do tipo Yoshi")
    if mario["moedas_yoshi"] >= 5:
        ganhar_vida()
        mario["moedas_yoshi"] -= 5


while True:

    lin = mario["linha"]
    col = mario["coluna"]

    if mapa[lin][col] == " ":
        print("Mario está na planicie")
    elif mapa[lin][col] == "f":
        print("O Mario está na floresta")
        ganhar_moeda_yoshi()
    elif mapa[lin][col] == "t":
        print("Mario encontrou uma tartaruga")
        perder_vida()
        if mario["vida"] <= 0:
            print("Mario morreu")
            break
    elif mapa[lin][col] == "m":
        print("Mario encontrou uma moeda")
        ganhar_moeda()
    elif mapa[lin][col] == "p":
        print("Mario encontrou a princesa")
        print("Mario venceu o jogo")
        break

    print("Para onde você deseja ir ? (O)este, (L)este, (N)orte ou (S)ul: ")
    direcao = input()[0].upper()
    if direcao == "O":
        if mario["coluna"] > 0:
            mario["coluna"] -= 1
    elif direcao == "L":
        if mario["coluna"] < 7:
            mario["coluna"] += 1
    elif direcao == "N":
        if mario["linha"] > 0:
            mario["linha"] -= 1
    elif direcao == "S":
        if mario["linha"] < 7:
            mario["linha"] += 1