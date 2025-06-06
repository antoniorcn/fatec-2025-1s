#-*-coding:latin1-*-
'''
Created on 2013 6 6

@author: Antonio
'''

from pygame.locals import QUIT, KEYDOWN, K_SPACE, K_LEFT, K_RIGHT, MOUSEBUTTONDOWN
import Box2D as b2
import math
import pygame

PPM = 30.0

gravidade = b2.b2Vec2(0, 10)

mundo = b2.b2World( gravidade, True )

pygame.init()
screen = pygame.display.set_mode( (800, 600), 0 , 32)
maca_original = pygame.image.load('maca.png').convert_alpha()
bola1Dicionario = {
                  "name":"Bola1",
                  "position":(5, 1),
                  "angle":-1,
                  "density":1,
                  "friction":0.5,
                  "restitution":0.3,
                  "color":(0, 0, 0),
				  "shape" : b2.b2PolygonShape( box=(0.48, 0.48) ),
                  # "shape": b2.b2CircleShape( radius = 0.48),
                  "type": b2.b2_dynamicBody,    
                  "imagem": maca_original.copy()                
                  }

bola2Dicionario = {
                  "name":"Bola2",
                  "position":(10, 3),
                  "angle":-1,
                  "density":1,
                  "friction":0.5,
                  "restitution":0.3,
                  "color":(0, 100, 0),
#                  "shape": b2.b2CircleShape( radius = 0.48),
                  "shape" : b2.b2PolygonShape( box=(0.48, 0.48) ),
                  "type": b2.b2_dynamicBody
#                  "imagem": maca.copy()       
                  }

pisoDicionario = {
                  "name":"Piso",
                  "position":(14, 18),
                  "angle":1,
                  "density":3,
                  "friction":0.5,
                  "restitution":0.6,
                  "color":(0, 255, 0),
                  "shape": b2.b2PolygonShape( box=(14, 0.5) ),
                  "type": b2.b2_staticBody                            
                  }



def criarCorpoFisico( dicionario ):
    corpoDef = b2.b2BodyDef()
    corpoDef.position = dicionario["position"]
    corpoDef.angle = dicionario["angle"] * math.pi / 180
    corpoDef.awake = True
    corpoDef.type = dicionario["type"]
    corpo = mundo.CreateBody( corpoDef )
    corpo.userData = dicionario
    
    corpoFixture = b2.b2FixtureDef()
    corpoFixture.shape = dicionario["shape"]
    corpoFixture.density = dicionario["density"]
    corpoFixture.friction = dicionario["friction"]
    corpoFixture.restitution = dicionario["restitution"]
    corpo.CreateFixture(corpoFixture)
    return corpo

bola1 = criarCorpoFisico( bola1Dicionario )
bola2 = criarCorpoFisico( bola2Dicionario )
piso = criarCorpoFisico( pisoDicionario )


def calcFromCenter(imagem, pos):
	x = pos[0] - (imagem.get_width() / 2)
	y = pos[1] - (imagem.get_height() / 2)
    #print ("Width : ", imagem.get_width(), "  Height : ", imagem.get_height(), " Pos : ", pos)
	return [x, y]

def draw( body ):
    shape = body.fixtures[0].shape
    image_x = 0
    image_y = 0
    image_scale = 1
    if (shape.type == b2.b2Shape.e_circle):
        pos = body.position
        x = int(pos[0] * PPM)
        y = int(pos[1] * PPM)
        rad = int(shape.radius * PPM)
        pygame.draw.circle(screen, body.userData['color'], (x, y), rad )
        image_x, image_y = body.position
        image_scale = shape.radius
    elif (shape.type == b2.b2Shape.e_polygon):
        pixelVertices = []
        for vertice in shape.vertices:
            v = body.transform * vertice * PPM
            pixelVertices.append( v )
        pygame.draw.polygon( screen, body.userData['color'], pixelVertices )
        image_x, image_y = body.position
    if ("imagem" in body.userData):
        imagem = body.userData["imagem"]
        imagem_escalada = pygame.transform.scale( imagem, 
        (int(image_scale * PPM), int(image_scale * PPM) ) ).copy()
        imagem_escalada = pygame.transform.rotate(imagem_escalada, 180 - (body.transform.angle * 180 / math.pi)).copy()
        screen.blit( imagem_escalada , calcFromCenter(imagem_escalada, [image_x * PPM, image_y * PPM]))

def testa_colisao():
    for contato in mundo.contacts:
        corpoA = contato.fixtureA.body
        corpoB = contato.fixtureB.body
        nomeA = corpoA.userData["name"]
        nomeB = corpoB.userData["name"]
#        r = randint(50, 200)
#        g = randint(50, 200)
#        b = randint(50, 200)
        bola = None
#        if (contato.touching == False):
#            contato.fixtureB.body.userData["color"] = (r, g, b)
        if (nomeA == "Bola1"):
            bola = corpoA           
        if (nomeB == "Bola1"):
            bola = corpoB
            
        #if (bola != None and contato.touching == False):
        #    raio = bola.fixtures[0].shape.radius + 0.05            
        #    bola.DestroyFixture( bola.fixtures[0] )
        #    corpoFixture = b2.b2FixtureDef()
        #    corpoFixture.shape = b2.b2CircleShape( radius = raio)
        #    corpoFixture.density = bola.userData["density"]
        #    corpoFixture.friction = bola.userData["friction"]
        #    corpoFixture.restitution = bola.userData["restitution"]
        #    bola.CreateFixture(corpoFixture)
        
            
#        print ("Corpo : " + nomeA + " entrou em contato com o Corpo : " + nomeB)
    

            
while (True):
    mundo.Step( 1.0/200, 8, 3)      # Iteração no mundo Fisico
    screen.fill( (0,0,0) )          # Limpa a Tela
    draw( bola1 )
    print (" Pos : ", bola1.position)
    draw( bola2 )
    draw( piso )
    pygame.display.update()
    #testa_colisao()
    for e in pygame.event.get():
        if (e.type == QUIT):
            exit()
        elif (e.type == MOUSEBUTTONDOWN):
            if (e.button == 4):
                PPM -= 1
                if (PPM < 10) : PPM = 10
            elif (e.button == 5):
                PPM += 1
                if (PPM > 40) : PPM = 40
            
        elif (e.type == KEYDOWN and e.key == K_SPACE ):
            print ("Apertado espaco")
            bola2.ApplyForce( b2.b2Vec2(0, -1000), bola2.position, True )
        elif (e.type == KEYDOWN and e.key == K_LEFT ):
            print ("Apertado Esquerda")
            bola2.ApplyForce( b2.b2Vec2(-1000, 0), bola2.position, True )            
        elif (e.type == KEYDOWN and e.key == K_RIGHT ):
            print ("Apertado Direitas")
            bola2.ApplyForce( b2.b2Vec2(1000, 0), bola2.position, True )
    



    


