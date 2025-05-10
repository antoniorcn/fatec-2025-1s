import pygame

pygame.init()

YELLOW = (255, 255, 0)

WIDTH = 800
HEIGHT = 600

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

font_grande = pygame.font.SysFont( "arial", 90, False, False)
img_ola_mundo = font_grande.render("Ola Mundo", False, YELLOW)

font_tt_grande = pygame.font.Font("SketchRockwell-Bold.ttf", 70)
font_tt_media = pygame.font.Font("SketchRockwell-Bold.ttf", 32)
img_ola_mundo2 = font_tt_grande.render("Ola Mundo", False, YELLOW)


img_nome = font_tt_media.render("Antonio Rodrigues Carvalho", False, YELLOW)
img_disciplina = font_tt_media.render("Programacao II", False, YELLOW)
img_curso = font_tt_media.render("Jogos Digitais", False, YELLOW)


while True:

    screen.blit(img_ola_mundo, (100, 100))
    screen.blit(img_ola_mundo2, (100, 300))

    screen.blit(img_nome, (WIDTH - img_nome.get_width(), 400) )
    screen.blit(img_disciplina, (WIDTH - img_disciplina.get_width(), 470) )
    screen.blit(img_curso, (WIDTH - img_curso.get_width(), 540) )
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()