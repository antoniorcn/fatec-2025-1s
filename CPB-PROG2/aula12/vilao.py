import pygame
from typing import List, Tuple
from pygame.sprite import Sprite
from pygame.surface import Surface
from pygame.rect import Rect
from pygame.transform import scale
from pygame.event import Event

class Vilao( Sprite ):

    def __init__(self, spritesheet : List[Surface],
                 pos : Tuple[int, int] = (50, 50),
                 size : Tuple[int, int] = (64, 64)):
        Sprite.__init__(self)
        self.spritesheet = spritesheet

        self.andar_esquerda = [i for i in range(33, 39)]
        self.andar_direita = [i for i in range(11, 17)]
        self.andar_cima = [i for i in range(22, 28)]
        self.andar_baixo = [i for i in range(0, 6)]
        self.parar_esquerda = [39]
        self.parar_direita = [17]
        self.parar_cima = [28]
        self.parar_baixo = [6]
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
        pass
