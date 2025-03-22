mario = {
    "vida": 5,
    "moedas": 0,
    "moedas_yoshi": 0,
    "altura": "pequeno",
    "forca": "fraco",
    "altura_pulo": "pequeno"
}


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


ganhar_moeda()
ganhar_moeda()
ganhar_moeda_yoshi()
ganhar_moeda_yoshi()
ganhar_moeda_yoshi()
ganhar_moeda_yoshi()
ganhar_moeda_yoshi()
