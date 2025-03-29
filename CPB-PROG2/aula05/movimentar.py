import pygame
from pygame.locals import QUIT, KEYDOWN, KEYUP, K_LEFT, K_RIGHT, K_UP, K_DOWN

pygame.init()

tela = pygame.display.set_mode( (800, 600), 0, 32 )

# Laco do Jogo
x = 20
y = 20
velocidade_x = 0
velocidade_y = 0
while True:
    # Calcular regras
    x = x + velocidade_x
    y = y + velocidade_y
    # if x > 800:
    #     velocidade_x *= -1

    # if x < 0:
    #     velocidade_x *= -1

    if x < 0 or x > 800:
        velocidade_x *= -1

    if y < 0 or y > 600:
        velocidade_y *= -1

    # Desenhar na tela
    tela.fill( (0, 0, 0) )
    pygame.draw.circle(tela, (255, 255, 0), (x, y), 10, 0)
    pygame.display.update()

    # Capturar eventos
    for evento in pygame.event.get():
        if evento.type == QUIT:
            exit()
        elif evento.type == KEYDOWN:
            if evento.key == K_LEFT:
                velocidade_x = -0.5
            elif evento.key == K_RIGHT:
                velocidade_x = 0.5
            elif evento.key == K_UP:
                velocidade_y = -0.5
            elif evento.key == K_DOWN:
                velocidade_y = 0.5
        elif evento.type == KEYUP:
            if evento.key == K_LEFT or evento.key == K_RIGHT:
                velocidade_x = 0
            elif evento.key == K_UP or evento.key == K_DOWN:
                velocidade_y = 0