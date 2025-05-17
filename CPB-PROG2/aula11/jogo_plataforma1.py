import pygame

pygame.init()

def main(): 
    WIDTH = 800
    HEIGHT = 600
    screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

    img_spritesheet = pygame.image.load("./EpicArmor.png")


    while (True):

        # Calcular regras

        # Desenha Tela
        screen.blit( img_spritesheet, (50, 50))
        pygame.display.update()


        # Capturar eventos
        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                exit()