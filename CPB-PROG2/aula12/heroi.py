import pygame
from typing import List, Tuple
from pygame.sprite import Sprite
from pygame.surface import Surface
from pygame.rect import Rect
from pygame.transform import scale
from pygame.event import Event

class Heroi( Sprite ):

    def __init__(self, spritesheet : List[Surface],
                 pos : Tuple[int, int] = (50, 50),
                 size : Tuple[int, int] = (64, 64)):
        Sprite.__init__(self)
        self.spritesheet = spritesheet

        self.andar_esquerda = [10, 11, 12, 13, 14, 15, 16, 17]
        self.andar_direita = [i for i in range(28, 36)]
        self.andar_cima = [i for i in range(1, 9)]
        self.andar_baixo = [i for i in range(19, 27)]
        self.parar_esquerda = [9]
        self.parar_direita = [27]
        self.parar_cima = [0]
        self.parar_baixo = [18]
        self.indice_animacao = 0
        self.animacao = self.andar_esquerda
        self.gid = self.animacao[ 0 ]
        self.rect = Rect(pos, size)
        self.pos = pos
        self.size = size
        self.image = self.get_image()
        self.velocidade_x = 0
        self.velocidade_y = 0
        self.velocidade = 10
    
    def update(self):
        self.rect.move_ip( self.velocidade_x, self.velocidade_y )

    def draw(self, screen : Surface):
        self.image = self.get_image()
        screen.blit(self.image, self.rect)

    def get_image(self):
        self.indice_animacao = self.indice_animacao + 1
        # indice_imagem = indice_imagem % 9
        if self.indice_animacao >= len(self.animacao):
            self.indice_animacao = 0
        self.gid = self.animacao[ self.indice_animacao ]
        img = self.spritesheet[ self.gid ]
        return scale(img, self.size)
    
    def evento(self, ev : Event):
        if ev.type == pygame.KEYDOWN:
            if ev.key == pygame.K_LEFT:
                self.animacao = self.andar_esquerda
                self.velocidade_x = -self.velocidade
            elif ev.key == pygame.K_RIGHT:
                self.animacao = self.andar_direita
                self.velocidade_x = self.velocidade
            elif ev.key == pygame.K_UP:
                self.animacao = self.andar_cima
                self.velocidade_y = -self.velocidade
            elif ev.key == pygame.K_DOWN:
                self.animacao = self.andar_baixo
                self.velocidade_y = self.velocidade
        elif ev.type == pygame.KEYUP:
            if ev.key == pygame.K_LEFT:
                self.animacao = self.parar_esquerda
                self.velocidade_x = 0
            elif ev.key == pygame.K_RIGHT:
                self.animacao = self.parar_direita
                self.velocidade_x = 0
            elif ev.key == pygame.K_UP:
                self.animacao = self.parar_cima
                self.velocidade_y = 0
            elif ev.key == pygame.K_DOWN:
                self.animacao = self.parar_baixo
                self.velocidade_y = 0
