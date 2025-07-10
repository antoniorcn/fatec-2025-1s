package edu.curso;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Sprite {
    private Image imagem;
    private double x;
    private double y;
    private double w;
    private double h;
    private int pontos = 0;
    private Rectangle rect = null;

    public Sprite( Image imagem, double x, double y, double w, double h) {
        this.imagem = imagem;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);
    }

    public Image getImagem() {
        return imagem;
    }
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
        this.rect.setX( x );
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
        this.rect.setY( y );
    }

    public double getW() {
        return w;
    }
    public void setW(double w) {
        this.w = w;
        this.rect.setWidth( w );
    }

    public double getH() {
        return h;
    }
    public void setH(double h) {
        this.h = h;
        this.rect.setHeight( h );
    }

    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Rectangle getRect() {
        return rect;
    }
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
