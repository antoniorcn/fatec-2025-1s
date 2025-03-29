import pygame
from pygame.locals import QUIT
from random import randint

pygame.init()

WIDTH = 600
HEIGHT = 400

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32 )
# for x in range(0, 300):
#     screen.set_at( (x, 200), (255, 255, 255) )

# Loop do Jogo
while True:
    # Calcular novos valores com base nas regras
    x1 = randint(0, WIDTH)
    y1 = randint(0, HEIGHT)
    x2 = randint(0, WIDTH)
    y2 = randint(0, HEIGHT)
    red = randint(0, 255)
    green = randint(0, 255)
    blue = randint(0, 255)
    expessura = randint(0, 10)

    # Mostra a tela
    # pygame.draw.line(screen, (red, green, blue), (x1, y1), (x2, y2), expessura)
    # pygame.draw.rect( screen, (0, 0, 255),  ( (50, 75), (200, 130) ), 0 )
    # pygame.draw.rect( screen, (red, green, blue), ( (x1, y1), (x2/2, y2/2) ), 0 )
    # pygame.draw.ellipse( screen, (0, 0, 255),  ( (50, 75), (200, 130) ), 3 )
    pygame.draw.ellipse( screen, (red, green, blue), ( (x1, y1), (x2/2, y2/2) ), 0 )
    pygame.display.update()


    # Captura o que o usuário deseja (Eventos do usuario)
    for evento in pygame.event.get():
        if evento.type == QUIT:
            print("Terminando o jogo")
            exit()


