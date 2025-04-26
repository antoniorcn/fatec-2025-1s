import pygame
import sys

WIDTH = 800
HEIGHT = 600
BLACK = (0, 0, 0)
YELLOW = (255, 255, 0)

screen = pygame.display.set_mode((WIDTH, HEIGHT), 0, 32)


class Bola (pygame.sprite.Sprite):
    def __init__(self, pos=(50, 50), size=None, *groups):
        super().__init__(*groups)
        imagem_original = pygame.image.load("bola.png")
        self.pos_inicial = pos
        self.size = size
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
        self.rect.x = self.rect.x - 10

    def mover_direita(self):
        self.rect.x = self.rect.x + 10

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

bola1 = Bola(pos=(400, 300), size=(50, 50))
bola2 = Bola(pos=(100, 300), size=(50, 50))
bolas = pygame.sprite.Group( bola1, bola2 )

while True:
    # Calcular as regras
    # bola1.rect.x = bola1.rect.x+1
    bola1.update()
    bola2.update()

    resultado = pygame.sprite.groupcollide(bolas, meninos, dokilla=False, dokillb=True)
    if resultado is not None and len(resultado.keys()) > 0:
        for bola in resultado.keys():
            bola.pontuar()
            bola.reset()
        print(f"Pontos Bola 1: {bola1.pontos}" )
        print(f"Pontos Bola 2: {bola2.pontos}" )

    # menino_queimado = pygame.sprite.spritecollideany(bola1, meninos)
    # if menino_queimado is not None:
    #     menino_queimado.kill()
    #     bola1.reset()

    # menino_queimado = pygame.sprite.spritecollideany(bola2, meninos)
    # if menino_queimado is not None:
    #     menino_queimado.kill()
    #     bola2.reset()

    # Atualizar a tela
    screen.fill(BLACK)
    # menino1.draw( screen )
    # menino2.draw( screen )
    # menino3.draw( screen )
    # menino4.draw( screen )
    meninos.draw(screen)
    bola1.draw(screen)
    bola2.draw(screen)
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
            elif e.key == pygame.K_a:
                bola2.mover_esquerda()
            elif e.key == pygame.K_d:
                bola2.mover_direita()
            elif e.key == pygame.K_f:
                bola2.disparar()
