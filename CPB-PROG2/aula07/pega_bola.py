import pygame
from pygame.locals import QUIT, KEYDOWN, K_RIGHT,\
    K_LEFT, K_UP, K_DOWN, KEYUP
pygame.init()
screen = pygame.display.set_mode((800, 600), 0, 32)
pygame.display.set_caption("Pegar a bola")

img_menino = pygame.image.load("menino.png")
img_bola = pygame.image.load("bola.png")
img_menino_menor = pygame.transform.scale(img_menino, (205, 301))
img_bola_menor = pygame.transform.scale(img_bola, (88, 81))

pos_x = 50
pos_y = 50
vel_x = 0
vel_y = 0
pos_x_bola = 600
pos_y_bola = 0
vel_bola_x = 1
vel_bola_y = 1
velocidade_maxima_menino = 0.5
velocidade_maxima_bola = 3
while True:
    # Calcular as regras
    pos_x = pos_x + vel_x
    pos_y = pos_y + vel_y
    if pos_x < 0:
        pos_x = 0
    if pos_x + img_menino_menor.get_width() > 800:
        pos_x = 800 - img_menino_menor.get_width()
    if pos_y < 0:
        pos_y = 0
    if pos_y + img_menino_menor.get_height() > 600:
        pos_y = 600 - img_menino_menor.get_height()

    pos_x_bola = pos_x_bola + vel_bola_x
    pos_y_bola = pos_y_bola + vel_bola_y
    if pos_x_bola + img_bola_menor.get_width() > 800:
        vel_bola_x = -velocidade_maxima_bola
    if pos_x_bola < 0:
        vel_bola_x = velocidade_maxima_bola

    if pos_y_bola + img_bola_menor.get_height() > 600:
        vel_bola_y = -velocidade_maxima_bola

    if pos_y_bola < 0:
        vel_bola_y = velocidade_maxima_bola

    # Desenhar a tela
    screen.fill( (0, 0, 0) )
    screen.blit( img_menino_menor, (pos_x, pos_y))
    screen.blit( img_bola_menor, (pos_x_bola, pos_y_bola))
    pygame.display.update()

    # print(pygame.key.get_pressed()[pygame.K_a])

    # Capturar os eventos do usuário
    for event in pygame.event.get():
        # print(event)
        if event.type == QUIT:
            exit()
        elif event.type == KEYDOWN:
            if event.key == K_RIGHT:
                vel_x = velocidade_maxima_menino
            elif event.key == K_LEFT:
                vel_x = -velocidade_maxima_menino
            elif event.key == K_UP:
                vel_y = -velocidade_maxima_menino
            elif event.key == K_DOWN:
                vel_y = velocidade_maxima_menino
        elif event.type == KEYUP:
            if event.key in [K_LEFT, K_RIGHT]:
                vel_x = 0
            elif event.key in [K_UP, K_DOWN]:
                vel_y = 0


