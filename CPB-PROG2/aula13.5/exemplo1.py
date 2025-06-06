import Box2D as b2
import pygame
import math


PPM = 10

BLACK = (0, 0, 0)
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
WIDTH = 800
HEIGHT = 600

gravidade = b2.b2Vec2(0, -0.98)
mundo = b2.b2World( gravidade, True )

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

corpoDef = b2.b2BodyDef()
corpoDef.position = (10, 50)
corpoDef.angle = 0 * math.pi / 180
corpoDef.awake = True
corpoDef.type = b2.b2_dynamicBody

corpoShape = b2.b2CircleShape( radius = 0.5 )

bola = mundo.CreateBody( corpoDef )
    
corpoFixture = b2.b2FixtureDef()
corpoFixture.shape = corpoShape
corpoFixture.density = 3
corpoFixture.friction = 0.2
corpoFixture.restitution = 1

bola.CreateFixture(corpoFixture)


piso_corpo_def = b2.b2BodyDef()
piso_corpo_def.position = (10, 0)
piso_corpo_def.angle = 0 * math.pi / 180
piso_corpo_def.awake = True
piso_corpo_def.type = b2.b2_staticBody

piso = mundo.CreateBody( piso_corpo_def )

piso_corpo_shape = b2.b2CircleShape( radius = 5 )

piso_corpo_fixture = b2.b2FixtureDef()
piso_corpo_fixture.shape = piso_corpo_shape

piso.CreateFixture(piso_corpo_fixture)

while True:

    # Calcular regras
    mundo.Step(1.0/30, 8, 3)

    # Desenhar tela
    screen.fill( BLACK )

    bola_pos = (bola.position[0] * PPM, HEIGHT - (bola.position[1] * PPM))
    bola_size = 0.5 * PPM
    # print("Posição do corpo: ", bola_pos)
    pygame.draw.circle( screen, YELLOW, bola_pos, bola_size )

    piso_pos = (piso.position[0] * PPM, HEIGHT - (piso.position[1] * PPM))
    piso_size = 5 * PPM
    pygame.draw.circle( screen, GREEN, piso_pos, piso_size )

    pygame.display.update()

    # Capturar eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)

