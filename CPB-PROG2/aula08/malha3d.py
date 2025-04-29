import pygame
import sys
import math

# Inicializa o Pygame
pygame.init()
screen = pygame.display.set_mode((800, 600))
pygame.display.set_caption("Malha 3D com Rotação via Mouse")
clock = pygame.time.Clock()

# Função para projetar ponto 3D em 2D
def project(x, y, z, d=5):
    factor = d / (z + d)
    x_proj = x * factor * 100 + 400  # Centraliza na tela
    y_proj = y * factor * 100 + 300
    return int(x_proj), int(y_proj)

# Rotação em torno do eixo X
def rotate_x(point, angle):
    x, y, z = point
    cos_theta = math.cos(angle)
    sin_theta = math.sin(angle)
    y_new = y * cos_theta - z * sin_theta
    z_new = y * sin_theta + z * cos_theta
    return x, y_new, z_new

# Rotação em torno do eixo Y
def rotate_y(point, angle):
    x, y, z = point
    cos_theta = math.cos(angle)
    sin_theta = math.sin(angle)
    x_new = x * cos_theta + z * sin_theta
    z_new = -x * sin_theta + z * cos_theta
    return x_new, y, z_new

# Gera uma malha 3D de pontos
grid_size = 10
points = []
for x in range(-grid_size, grid_size):
    for y in range(-grid_size, grid_size):
        z = math.sin(x * 0.5) + math.cos(y * 0.5)  # Altura ondulada
        points.append((x, y, z))

# Conecta os pontos vizinhos
def connect_points(points, grid_size):
    lines = []
    for i in range(len(points)):
        if (i + 1) % (grid_size * 2) != 0:
            lines.append((i, i + 1))
        if i + (grid_size * 2) < len(points):
            lines.append((i, i + (grid_size * 2)))
    return lines

lines = connect_points(points, grid_size)

# Variáveis para rotação controlada pelo mouse
rotation_x = 0
rotation_y = 0
dragging = False
last_mouse_pos = (0, 0)

# Loop principal
while True:
    screen.fill((10, 10, 30))  # Fundo escuro bonito

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        # Detecta início do arrasto
        if event.type == pygame.MOUSEBUTTONDOWN:
            if event.button == 1:  # Botão esquerdo
                dragging = True
                last_mouse_pos = pygame.mouse.get_pos()

        # Detecta fim do arrasto
        if event.type == pygame.MOUSEBUTTONUP:
            if event.button == 1:
                dragging = False

        # Detecta movimento do mouse
        if event.type == pygame.MOUSEMOTION:
            if dragging:
                mouse_x, mouse_y = pygame.mouse.get_pos()
                dx = mouse_x - last_mouse_pos[0]
                dy = mouse_y - last_mouse_pos[1]
                rotation_y += dx * 0.01  # Ajuste de velocidade de rotação
                rotation_x += dy * 0.01
                last_mouse_pos = (mouse_x, mouse_y)

    # Aplica rotação e projeta
    rotated_points = []
    for point in points:
        rotated = rotate_x(point, rotation_x)
        rotated = rotate_y(rotated, rotation_y)
        rotated_points.append(rotated)

    # Desenha linhas
    for idx1, idx2 in lines:
        x1, y1 = project(*rotated_points[idx1])
        x2, y2 = project(*rotated_points[idx2])
        pygame.draw.line(screen, (255, 255, 255), (x1, y1), (x2, y2), 1)

    pygame.display.flip()
    clock.tick(60)
