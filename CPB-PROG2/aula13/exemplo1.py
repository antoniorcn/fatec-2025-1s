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


def calc_from_center(imagem, pos):
    x = pos[0] - (imagem.get_width() / 2)
    y = pos[1] - (imagem.get_height() / 2)
    return (x, y)


def draw( tela, body ):
    for fixture in body.fixtures:
        shape = fixture.shape
        if body.userData and "color" in body.userData:
            color = body.userData["color"]
            if shape.type == b2.b2Shape.e_circle:
                pos = (body.position[0] * PPM, tela.get_height() - (body.position[1] * PPM))
                rad = shape.radius * PPM
                pygame.draw.circle(tela, color, pos, rad)
            elif shape.type == b2.b2Shape.e_polygon:
                pixel_vertices = []
                for vertice in shape.vertices:
                    v = body.transform * vertice * PPM
                    vert = (v[0], tela.get_height() - v[1])
                    pixel_vertices.append( vert )
                pygame.draw.polygon( tela, color, pixel_vertices )
        if body.userData and "image" in body.userData:
            image_x, image_y = body.position
            imagem = body.userData["image"]
            image_scale = 1
            if shape.type == b2.b2Shape.e_circle:
                image_scale = shape.radius * 2
            imagem_escalada = pygame.transform.scale( imagem,
            (int(image_scale * PPM), int(image_scale * PPM) ) ).copy()
            imagem_escalada = pygame.transform.rotate(imagem_escalada,
                                                      (body.transform.angle * 180 / math.pi)).copy()
            tela.blit( imagem_escalada ,
                      calc_from_center(imagem_escalada,
                                       (image_x * PPM, tela.get_height() - (image_y * PPM))))

screen = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)

img_maca = pygame.image.load("maca.png")

corpoDef = b2.b2BodyDef()
corpoDef.position = (10, 50)
corpoDef.angle = 0 * math.pi / 180
corpoDef.awake = True
corpoDef.type = b2.b2_dynamicBody

corpoShape = b2.b2CircleShape( radius = 3 )

bola = mundo.CreateBody( corpoDef )
    
corpoFixture = b2.b2FixtureDef()
corpoFixture.shape = corpoShape
corpoFixture.density = 3
corpoFixture.friction = 0.2
corpoFixture.restitution = 1

bola.CreateFixture(corpoFixture)
bola.userData = {"image": img_maca}


piso_corpo_def = b2.b2BodyDef()
piso_corpo_def.position = (10, 5)
piso_corpo_def.angle = -3 * math.pi / 180
piso_corpo_def.awake = True
piso_corpo_def.type = b2.b2_staticBody

piso = mundo.CreateBody( piso_corpo_def )

# piso_corpo_shape = b2.b2CircleShape( radius = 5 )
piso_corpo_shape = b2.b2PolygonShape( box=(100, 0.5) )

piso_corpo_fixture = b2.b2FixtureDef()
piso_corpo_fixture.shape = piso_corpo_shape

piso.CreateFixture(piso_corpo_fixture)
piso.userData = {"color": GREEN}

pontos = 0
ciclos = 0
while True:

    # Calcular regras
    mundo.Step(1.0/30, 8, 3)
    ciclos += 1

    for contato in mundo.contacts:
        corpoA = contato.fixtureA.body
        corpoB = contato.fixtureB.body
        if ciclos > 100:
            pontos += 1
            print(pontos)
            ciclos = 0
            break

    # Desenhar tela
    screen.fill( BLACK )

    # bola_pos = (bola.position[0] * PPM, HEIGHT - (bola.position[1] * PPM))
    # bola_size = 0.5 * PPM
    # print("Posição do corpo: ", bola_pos)
    # pygame.draw.circle( screen, YELLOW, bola_pos, bola_size )
    draw(screen, bola)
    # piso_pos = (piso.position[0] * PPM, HEIGHT - (piso.position[1] * PPM))
    # piso_size = 5 * PPM
    # pygame.draw.circle( screen, GREEN, piso_pos, piso_size )
    draw( screen, piso )

    pygame.display.update()

    # Capturar eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)

