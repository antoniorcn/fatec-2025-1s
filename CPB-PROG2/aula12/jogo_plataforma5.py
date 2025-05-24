import pygame
from pygame.rect import Rect
from heroi import Heroi

pygame.init()

BLACK = (0, 0, 0)

SCREEN_SIZE = (800, 600)
WIDTH = SCREEN_SIZE[0]
HEIGHT = SCREEN_SIZE[1]

def main():

    screen = pygame.display.set_mode( SCREEN_SIZE, 0, 32)

    img_spritesheet = pygame.image.load("./EpicArmor.png")

    largura_imagem = 64
    altura_imagem = 64
    quantidade_imagens_linha = 9
    spritesheet = []
    for i in range(36):
        coluna = i % quantidade_imagens_linha
        linha = i // quantidade_imagens_linha
        x = coluna * largura_imagem
        y = linha * altura_imagem
        img = img_spritesheet.subsurface(x, y, largura_imagem, altura_imagem)
        spritesheet.append( img )

    heroi1 = Heroi(spritesheet, pos=(100, 100), size=(128, 128))

    while True:

        # Calcular Regras
        heroi1.update()

        # Desenhar na tela
        screen.fill(BLACK)
        heroi1.draw(screen)

        pygame.display.update()

        # Capturar eventos
        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                exit(0)
            heroi1.evento( e )

        pygame.time.delay(100)

if __name__ == "__main__":
    main()