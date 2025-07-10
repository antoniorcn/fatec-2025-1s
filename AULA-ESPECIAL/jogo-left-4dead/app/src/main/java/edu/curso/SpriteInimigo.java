package edu.curso;

import javafx.scene.image.Image;

public class SpriteInimigo extends Sprite {
    private Sprite heroi;
    private double velocidade = 0.5;

    public SpriteInimigo(Sprite heroi, Image imagem, double x, double y, double w, double h) {
        super(imagem,  x,  y,  w, h);
        this.heroi = heroi;
    }

    public void setHeroi( Sprite heroi ) {
        this.heroi = heroi;
    }
    
    public void update() {
        double distanciaX = (this.heroi.getX() - this.getX());
        double distanciaY = (this.heroi.getY() - this.getY());
        double movimentoX = 0;
        double movimentoY = 0;
        if (distanciaX != 0 ) {
            movimentoX = (distanciaX / Math.abs(distanciaX)) * velocidade;
        }
        if (distanciaY != 0 ) {
            movimentoY = (distanciaY / Math.abs(distanciaY)) * velocidade;
        }
        this.setX(this.getX() + movimentoX);
        this.setY(this.getY() + movimentoY);
    }
}
