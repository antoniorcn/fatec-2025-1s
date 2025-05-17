import pygame

pygame.init()

BLACK = (0, 0, 0)

def main(): 
    WIDTH = 800
    HEIGHT = 600
    screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

    img_spritesheet = pygame.image.load("./EpicArmor.png")

    largura_imagem = 64
    imagens = []
    for i in range(9):
        x = i * largura_imagem
        img = img_spritesheet.subsurface(x, 0, largura_imagem, 64)
        imagens.append( img )

    indice_imagem = 1
    while (True):

        # Calcular regras
        
        # Desenha Tela
        screen.fill( BLACK )
        imagem_grande = pygame.transform.scale(imagens[ indice_imagem ], (256, 256))
        screen.blit( imagem_grande, (50, 50))
        pygame.display.update()

        indice_imagem = indice_imagem + 1
        # indice_imagem = indice_imagem % 9
        if indice_imagem > 8:
            indice_imagem = 1

        pygame.time.delay(100)



        # Capturar eventos
        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                exit()


if __name__ == "__main__":
    main()