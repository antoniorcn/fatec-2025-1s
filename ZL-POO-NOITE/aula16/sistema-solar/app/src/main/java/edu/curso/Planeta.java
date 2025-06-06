package edu.curso;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Planeta {

    private double distancia;
    private double raio;
    private double centroOrbitaX;
    private double centroOrbitaY;
    private double angulo;
    private double x;
    private double y;
    private Color cor;
    private double velocidade;
    private Image imagem;

    public Planeta() { 
        
    }

    public Planeta(double distancia, double raio, 
    double centroOrbitaX, double centroOrbitaY, double velocidade, Color cor) {
        this.distancia = distancia;
        this.raio = raio;
        this.centroOrbitaX = centroOrbitaX;
        this.centroOrbitaY = centroOrbitaY;
        this.cor = cor;
        this.velocidade = velocidade;
    }

    public void update() { 
        double anguloRad = angulo * Math.PI / 180;
        x = (centroOrbitaX + (Math.cos( anguloRad ) * distancia)) - raio;
        y = (centroOrbitaY + (Math.sin( anguloRad ) * distancia)) - raio;
        angulo += velocidade;
    }

    public void draw( GraphicsContext g ) { 
        if (imagem != null) { 
            g.drawImage( imagem, x, y, raio * 2, raio * 2);
        } else { 
            g.setFill( cor );
            g.fillOval( x, y, raio * 2, raio * 2);
        }
    }

    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getCentroOrbitaX() {
        return centroOrbitaX;
    }
    public void setCentroOrbitaX(double centroOrbitaX) {
        this.centroOrbitaX = centroOrbitaX;
    }

    public double getCentroOrbitaY() {
        return centroOrbitaY;
    }
    public void setCentroOrbitaY(double centroOrbitaY) {
        this.centroOrbitaY = centroOrbitaY;
    }

    public Color getCor() {
        return cor;
    }
    public void setCor(Color cor) {
        this.cor = cor;
    }

    public double getAngulo() {
        return angulo;
    }
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }   

    public Image getImagem() {
        return imagem;
    }
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }
}
