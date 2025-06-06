import pygame
import math
import random

pygame.init()
WIDTH, HEIGHT = 1000, 1000
WIN = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Simulador N-Corpos com Colisões Elásticas")

BLACK = (0, 0, 0)
G = 0.1
TIME_STEP = 0.5


class Corpo:
    def __init__(self, x, y, raio, cor, massa):
        self.x = x
        self.y = y
        self.raio = raio
        self.cor = cor
        self.massa = massa

        self.vx = random.uniform(-1, 1)
        self.vy = random.uniform(-1, 1)

    def desenhar(self, tela):
        pygame.draw.circle(tela, self.cor, (int(self.x), int(self.y)), self.raio)

    def atrair(self, outro):
        dx = outro.x - self.x
        dy = outro.y - self.y
        dist = math.hypot(dx, dy)

        if dist == 0 or dist < self.raio + outro.raio:
            return 0, 0

        forca = G * self.massa * outro.massa / dist**2
        theta = math.atan2(dy, dx)
        fx = math.cos(theta) * forca
        fy = math.sin(theta) * forca
        return fx, fy

    def atualizar(self, corpos):
        fx_total, fy_total = 0, 0
        for corpo in corpos:
            if corpo is self:
                continue
            fx, fy = self.atrair(corpo)
            fx_total += fx
            fy_total += fy

        ax = fx_total / self.massa
        ay = fy_total / self.massa

        self.vx += ax * TIME_STEP
        self.vy += ay * TIME_STEP

        self.x += self.vx * TIME_STEP
        self.y += self.vy * TIME_STEP

    def colide_com(self, outro):
        dx = self.x - outro.x
        dy = self.y - outro.y
        dist = math.hypot(dx, dy)
        return dist < self.raio + outro.raio

    def resolver_colisao(self, outro):
        dx = outro.x - self.x
        dy = outro.y - self.y
        dist = math.hypot(dx, dy)

        if dist == 0:
            return

        # Normal unit vector
        nx = dx / dist
        ny = dy / dist

        # Relative velocity
        dvx = self.vx - outro.vx
        dvy = self.vy - outro.vy

        # Velocity along normal
        velocidade_normal = dvx * nx + dvy * ny
        if velocidade_normal > 0:
            return  # Já estão se afastando

        # Impulso escalar
        impulso = (2 * velocidade_normal) / (self.massa + outro.massa)

        self.vx -= impulso * outro.massa * nx
        self.vy -= impulso * outro.massa * ny
        outro.vx += impulso * self.massa * nx
        outro.vy += impulso * self.massa * ny

        # Corrigir sobreposição
        sobreposicao = self.raio + outro.raio - dist
        if sobreposicao > 0:
            correção = sobreposicao / 2
            self.x -= correção * nx
            self.y -= correção * ny
            outro.x += correção * nx
            outro.y += correção * ny


def gerar_corpos(n):
    corpos = []
    for _ in range(n):
        x = random.randint(50, WIDTH - 50)
        y = random.randint(50, HEIGHT - 50)
        raio = random.randint(1, 10)
        massa = raio ** 2
        cor = (random.randint(100, 255), random.randint(100, 255), random.randint(100, 255))
        corpo = Corpo(x, y, raio, cor, massa)
        corpos.append(corpo)
    return corpos


def main():
    clock = pygame.time.Clock()
    corpos = gerar_corpos(100)
    rodando = True

    while rodando:
        clock.tick(60)
        WIN.fill(BLACK)

        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                rodando = False

        for corpo in corpos:
            corpo.atualizar(corpos)

        # Resolver colisões
        for i in range(len(corpos)):
            for j in range(i + 1, len(corpos)):
                if corpos[i].colide_com(corpos[j]):
                    corpos[i].resolver_colisao(corpos[j])

        for corpo in corpos:
            corpo.desenhar(WIN)

        pygame.display.update()

    pygame.quit()


if __name__ == "__main__":
    main()
