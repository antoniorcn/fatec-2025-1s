import pygame
from pygame.rect import Rect

pygame.init()

BLACK = (0, 0, 0)

def main():
    WIDTH = 800
    HEIGHT = 600
    screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

    img_spritesheet = pygame.image.load("./EpicArmor.png")

    largura_imagem = 64
    altura_imagem = 64
    quantidade_imagens_linha = 9
    imagens = []
    for i in range(36):
        coluna = i % quantidade_imagens_linha
        linha = i // quantidade_imagens_linha
        x = coluna * largura_imagem
        y = linha * altura_imagem
        img = img_spritesheet.subsurface(x, y, largura_imagem, altura_imagem)
        imagens.append( img )
    # indice_animacao 0   1   2   3   4   5   6   7   8   9   10  11  12  13
    andar_esquerda = [10, 11, 12, 13, 14, 15, 16, 17]
    # andar_direita = [28, 29, 30, 31, 32, 33, 34, 35]
    andar_direita = [i for i in range(28, 36)]
    andar_cima = [i for i in range(1, 9)]
    andar_baixo = [i for i in range(19, 27)]
    parar_esquerda = [9]
    parar_direita = [27]
    parar_cima = [0]
    parar_baixo = [18]
    # indice_imagem = 10  # gId
    indice_animacao = 0
    animacao = parar_esquerda
    gId = animacao[ 0 ]
    p_rect = Rect((50, 50), (largura_imagem, altura_imagem))
    p_velocidade_x = 0
    p_velocidade_y = 0
    p_velocidade = 10
    while (True):
        # Calcular regras
        p_rect.move_ip( p_velocidade_x, p_velocidade_y )
        # Desenha Tela
        screen.fill( BLACK )
        imagem_grande = pygame.transform.scale(imagens[ gId ], (256, 256))
        screen.blit( imagem_grande, p_rect.topleft)
        pygame.display.update()

        indice_animacao = indice_animacao + 1
        # indice_imagem = indice_imagem % 9
        if indice_animacao >= len(animacao):
            indice_animacao = 0
        gId = animacao[ indice_animacao ]

        pygame.time.delay(100)



        # Capturar eventos
        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                exit()
            elif e.type == pygame.KEYDOWN:
                if e.key == pygame.K_LEFT:
                    animacao = andar_esquerda
                    p_velocidade_x = -p_velocidade
                elif e.key == pygame.K_RIGHT:
                    animacao = andar_direita
                    p_velocidade_x = p_velocidade
                elif e.key == pygame.K_UP:
                    animacao = andar_cima
                    p_velocidade_y = -p_velocidade
                elif e.key == pygame.K_DOWN:
                    animacao = andar_baixo
                    p_velocidade_y = p_velocidade
            elif e.type == pygame.KEYUP:
                if e.key == pygame.K_LEFT:
                    animacao = parar_esquerda
                    p_velocidade_x = 0
                elif e.key == pygame.K_RIGHT:
                    animacao = parar_direita
                    p_velocidade_x = 0
                elif e.key == pygame.K_UP:
                    animacao = parar_cima
                    p_velocidade_y = 0
                elif e.key == pygame.K_DOWN:
                    animacao = parar_baixo
                    p_velocidade_y = 0


if __name__ == "__main__":
    main()


