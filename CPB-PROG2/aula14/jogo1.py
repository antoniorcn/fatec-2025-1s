from typing import List
import pygame
import json

pygame.init()

SCREEN_SIZE = (1280, 800)

screen = pygame.display.set_mode(SCREEN_SIZE, 0, 32)

# Carregando o arquivo de Tiles

class TileSet:
    def __init__(self, nome_tileset_json : str):
        arquivo = open(nome_tileset_json, "r", encoding="utf-8")
        self.tile_set = json.load( arquivo )
        self.img_tile = pygame.image.load(self.tile_set["image"])

    def get_tile_width(self):
        return self.tile_set["tilewidth"]
    
    def get_tile_height(self):
        return self.tile_set["tileheight"]

    def get_columns(self):
        return self.tile_set["imagewidth"] // self.get_tile_width()
    
    def get_lines(self):
        return self.tile_set["imageheight"] // self.get_tile_height()

    def first_gid(self):
        return 0
    
    def last_gid(self):
        return (self.get_columns() * self.get_lines()) - 1 + self.first_gid()

    def get_column(self, gid : int ):
        return gid % self.get_columns()
    
    def get_line(self, gid : int ):
        return gid // self.get_columns()
    
    def gid_pos(self, gid):
        return (
            self.get_column(gid) * self.get_tile_width(),
            self.get_line(gid) * self.get_tile_height()
        )
    
    def get_image_gid(self, gid):
        return self.img_tile.subsurface(
            (   self.gid_pos(gid),
                (self.get_tile_width(), self.get_tile_height())
            )
        )
    

class Layer:
    def __init__(self, nome_mapa_json, layer=0):
        arquivo = open(nome_mapa_json, "r", encoding="utf-8")
        self.mapa = json.load( arquivo )

        # extrair a Layer do mapa
        self.layer = self.mapa["layers"][layer]

    def get_columns(self):
        return self.layer["width"]
    
    def get_lines(self):
        return self.layer["height"]
    
    def get_name(self):
        return self.layer["name"]
    
    def is_visible(self):
        return self.layer["visible"]
    
    def get_opacity(self):
        return self.layer["opacity"]
    
    def data(self):
        data_matrix : List[List[int]] = []
        for lin_indice in range(self.get_lines()):
            linha : List[ int ] = []
            for col_indice in range(self.get_columns()):
                linha.append(self.layer["data"][(lin_indice * self.get_columns()) + col_indice])
            data_matrix.append( linha )
        return data_matrix
    

tile_set = TileSet("grass-tiles.json")

layer = Layer("mapa1.json")
matriz = layer.data()
print(matriz)
print("First gId: ", tile_set.first_gid())
print("Last gId: ", tile_set.last_gid())

while True:

    # screen.blit(tile_set.get_image_gid(2), (0, 0))

    for lin, linha in enumerate(matriz):
        for col, gid in enumerate(linha):
            screen.blit(tile_set.get_image_gid(gid - 1), 
                        (col * tile_set.get_tile_width(), lin * tile_set.get_tile_height()))

    pygame.display.update()



    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()