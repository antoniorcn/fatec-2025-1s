import pygame
import sys

WIDTH = 1280
HEIGHT = 600
BLACK = (0, 0, 0)
YELLOW = (255, 255, 0)

pygame.init()

screen = pygame.display.set_mode((WIDTH, HEIGHT), 0, 32)

def esquerda( obj ):
    obj.rect.x = obj.rect.x - 10

def direita( obj ):
    obj.rect.x = obj.rect.x + 10

class Bola (pygame.sprite.Sprite):
    def __init__(self, pos=(50, 50), size=None,
                 acao=None, move_esquerda=None,
                 move_direita=None, *groups):
        super().__init__(*groups)
        imagem_original = pygame.image.load("bola.png")
        self.pos_inicial = pos
        self.size = size
        self.acao = acao
        self.direita = move_direita if move_direita is not None else direita
        self.esquerda = move_esquerda if move_esquerda is not None else esquerda
        self.velocidade = 0
        if size is None:
            self.size = (imagem_original.get_width(), imagem_original.get_height())
        self.image = pygame.transform.scale(imagem_original, self.size)
        self.rect = pygame.rect.Rect(pos, self.size)
        self.pontos = 0
        self.vidas = 3

    def draw(self, tela):
        tela.blit(self.image, self.rect)

    def mover_esquerda(self):
        self.esquerda(self)

    def mover_direita(self):
        self.direita(self)

    def update(self, *args, **kwargs):
        super().update(*args, **kwargs)
        self.rect.y = self.rect.y - self.velocidade

    def disparar(self):
        self.velocidade = 1

    def reset(self):
        self.rect.topleft = self.pos_inicial
        self.velocidade = 0

    def pontuar(self):
        self.pontos = self.pontos + 1

    def acao_especial(self):
        if self.acao is not None:
            self.acao( self )



class Menino (pygame.sprite.Sprite):
    def __init__(self, pos=(50, 50), size=None, *groups):
        super().__init__(*groups)
        imagem_original = pygame.image.load("menino.png")
        self.size = size
        if size is None:
            self.size = (imagem_original.get_width(), imagem_original.get_height())
        self.image = pygame.transform.scale(imagem_original, self.size)
        self.rect = pygame.rect.Rect(pos, self.size)

    def draw(self, tela):
        tela.blit(self.image, self.rect)


menino1 = Menino(pos=(50, 100), size=(75, 100))
menino2 = Menino(pos=(150, 100), size=(75, 100))
menino3 = Menino(pos=(250, 100), size=(75, 100))
menino4 = Menino(pos=(350, 100), size=(75, 100))
menino5 = Menino(pos=(450, 100), size=(75, 100))
menino6 = Menino(pos=(550, 100), size=(75, 100))
meninos = pygame.sprite.Group( menino1, menino2, menino3, menino4, menino5, menino6 )

# def mostrar_posicao():
#     print("Posicao: ")

# def mov_esquerda( obj_bola ):
#     obj_bola.rect.x -= 50

bola1 = Bola(pos=(100, 300), size=(50, 50),
             acao=lambda obj : print("Posicao como lambda ", obj.rect),
             move_esquerda=lambda o: o.rect.move_ip(-50, 0),
             move_direita=lambda o: o.rect.move_ip(50, 0))

bola2 = Bola(pos=(400, 300), size=(50, 50))
bolas = pygame.sprite.Group( bola1, bola2 )

pontos_jogador_1 = 0
pontos_jogador_2 = 0
vidas_jogador_1 = 3
vidas_jogador_2 = 3

font_tt_media = pygame.font.Font("SketchRockwell-Bold.ttf", 32)
img_game_over = font_tt_media.render("G A M E - O V E R", True, YELLOW)
while True:
    # Calcular as regras
    # bola1.rect.x = bola1.rect.x+1
    bola1.update()
    bola2.update()

    resultado = pygame.sprite.groupcollide(bolas, meninos, dokilla=False, dokillb=True)
    if resultado is not None and len(resultado.keys()) > 0:
        for bola in resultado.keys():
            if bola is bola1:
                pontos_jogador_1 += 1
            if bola is bola2:
                pontos_jogador_2 += 1
            bola.reset()
        # print(f"Pontos Jogador 1: {pontos_jogador_1}" )
        # print(f"Pontos Jogador 2: {pontos_jogador_2}" )
    if bola1.rect.y < 0:
        vidas_jogador_1 -= 1
        bola1.reset()

    if bola2.rect.y < 0:
        vidas_jogador_2 -= 1
        bola2.reset()

    if vidas_jogador_1 <= 0:
        if bola1 in bolas:
            bolas.remove(bola1)

    if bola2 in bolas and vidas_jogador_2 <= 0:
        bolas.remove(bola2)

    # Atualizar a tela

    img_jogador_1 = \
    font_tt_media.render(f"Jogador 1: ({vidas_jogador_1}) vidas - ({pontos_jogador_1}) pontos",
                         True, YELLOW)

    img_jogador_2 = \
    font_tt_media.render(f"Jogador 2: ({vidas_jogador_2}) vidas - ({pontos_jogador_2}) pontos",
                         True, YELLOW)

    screen.fill(BLACK)
    meninos.draw(screen)
    bolas.draw(screen)
    screen.blit(img_jogador_1, (50, 50))
    screen.blit(img_jogador_2, (WIDTH - img_jogador_2.get_width() - 50, 50))

    if vidas_jogador_1 <= 0:
        screen.blit(img_game_over, (100, 300))
    if vidas_jogador_2 <= 0:
        screen.blit(img_game_over, (400, 300))
    pygame.display.update()

    # Computar os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            sys.exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_SPACE:
                bola1.disparar()
            elif e.key == pygame.K_LEFT:
                bola1.mover_esquerda()
            elif e.key == pygame.K_RIGHT:
                bola1.mover_direita()
            elif e.key == pygame.K_RETURN:
                bola1.acao_especial()
            elif e.key == pygame.K_a:
                bola2.mover_esquerda()
            elif e.key == pygame.K_d:
                bola2.mover_direita()
            elif e.key == pygame.K_f:
                bola2.disparar()
