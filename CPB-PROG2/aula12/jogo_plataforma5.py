from typing import List, Tuple
import pygame
from pygame.rect import Rect
from pygame.surface import Surface
from heroi import Heroi
from vilao import Vilao

pygame.init()

BLACK = (0, 0, 0)

SCREEN_SIZE = (800, 600)
WIDTH = SCREEN_SIZE[0]
HEIGHT = SCREEN_SIZE[1]

def carregar_sprite_sheet(arquivo_imagem : str,
                          tamanho : Tuple[int, int],
                          qtd_imagens : int,
                          qtd_imagens_linha : int) -> List[ Surface ]:
    largura_imagem = tamanho[0]
    altura_imagem = tamanho[1]
    spritesheet = []
    for i in range(qtd_imagens):
        coluna = i % qtd_imagens_linha
        linha = i // qtd_imagens_linha
        x = coluna * largura_imagem
        y = linha * altura_imagem
        img = arquivo_imagem.subsurface(x, y, largura_imagem, altura_imagem)
        spritesheet.append( img )
    return spritesheet

def main():

    vidas = 3

    screen = pygame.display.set_mode( SCREEN_SIZE, 0, 32)

    img_heart = pygame.transform.scale(pygame.image.load("heart.png"), (32, 32))

    img_heroi_spritesheet = carregar_sprite_sheet(pygame.image.load("./EpicArmor.png"), (64, 64), 36, 9)
    img_vilao_spritesheet = carregar_sprite_sheet(pygame.image.load("./vilao.png"), (64, 64), 49, 11)

    heroi1 = Heroi(img_heroi_spritesheet, pos=(100, 100), size=(128, 128))
    vilao1 = Vilao(img_vilao_spritesheet, pos=(600, 100), size=(196, 196))

    while True:

        # Calcular Regras
        heroi1.update()
        vilao1.update()

        colisao = pygame.sprite.collide_rect( heroi1, vilao1 )
        if colisao:
            heroi1.rect.move_ip(-200, 0)
            vidas -= 1

        # Desenhar na tela
        screen.fill(BLACK)
        heroi1.draw(screen)
        vilao1.draw(screen)

        for life in range(vidas):
            start_life_pos = [20 + (img_heart.get_width() + 10) * life, 20]
            screen.blit(img_heart, start_life_pos)

        pygame.display.update()

        # Capturar eventos
        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                exit(0)
            heroi1.evento( e )
            vilao1.evento( e )

        pygame.time.delay(100)

if __name__ == "__main__":
    main()