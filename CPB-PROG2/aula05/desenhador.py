import pygame
from pygame.locals import QUIT, MOUSEMOTION, MOUSEBUTTONDOWN, KEYDOWN, K_l, K_b, K_f, KMOD_LCTRL

VERMELHO = (255, 0, 0)
VERDE = (0, 255, 0)
AZUL = (0, 0, 255)
AMARELO = (255, 255, 0)
CIANO = (0, 255, 255)
MAGENTA = (255, 0, 255)
BRANCO = (255, 255, 255)
PRETO = (0, 0, 0)

#          0       1      2         3        4     5      6       7
cores = [PRETO, VERMELHO, MAGENTA, AZUL, CIANO, VERDE, AMARELO, BRANCO]

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)

pos_x = 0
pos_y = 0
botao_esquerdo = 0
raio = 5
limpar_tela = False

indice_cor_foreground = 7
indice_cor_background = 0

# Laco do Jogo
while True:
    # Calcular regras
    cor_background = cores[indice_cor_background]
    cor_foreground = cores[indice_cor_foreground]

    # Desenhar na tela
    if limpar_tela:
        tela.fill( cor_background )
        limpar_tela = False

    pygame.draw.rect( tela, cor_background, ((760, 0), (40, 40)), 0)
    pygame.draw.ellipse(tela, cor_foreground, ( (780, 10), (raio, raio)), 0 )

    if botao_esquerdo == 1:
        pygame.draw.ellipse(tela, cor_foreground, ( (pos_x, pos_y), (raio, raio) ), 0)
    pygame.display.update()
    
    # Capturar eventos
    for evento in pygame.event.get():
        if evento.type == QUIT:
            exit()
        elif evento.type == MOUSEMOTION:
            # pos_x = evento.pos[0]
            # pos_y = evento.pos[1]
            pos_x, pos_y = evento.pos
            botao_esquerdo = evento.buttons[0]
        elif evento.type == MOUSEBUTTONDOWN:
            if evento.button == 4:
                raio = raio - 1
                if raio < 1:
                    raio = 1
            if evento.button == 5:
                raio = raio + 1
                if raio > 20:
                    raio = 20
        elif evento.type == KEYDOWN:
            if evento.key == K_l and evento.mod == KMOD_LCTRL:
                limpar_tela = True
            if evento.key == K_f and evento.mod == KMOD_LCTRL:
                print("Trocar cor de frente")
                # indice_cor_foreground = indice_cor_foreground + 1
                indice_cor_foreground += 1
                indice_cor_foreground %= 8
                
                # if indice_cor_foreground > 7:
                #     indice_cor_foreground = 0
            if evento.key == K_b and evento.mod == KMOD_LCTRL:
                print("Trocar cor de fundo")
                # indice_cor_background = indice_cor_background + 1
                # if indice_cor_background > 7:
                #     indice_cor_background = 0
                indice_cor_background += 1
                indice_cor_background %= 8
            

