package edu.curso;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Planeta { 
    private double centroOrbitaX = 0.0;
    private double centroOrbitaY = 0.0;
    private double distancia = 0.0;
    private double raio = 0.0;
    private Color cor = Color.BLACK;
    private Image image;
    private double x = 0.0;
    private double y = 0.0;
    private double angulo = 0.0;
    private double anguloRad = 0.0;
    private double velocidadeAngular = 0.0;

    public Planeta(double centroOrbitaX, double centroOrbitaY, 
                    double raio, double distancia, double angulo, 
                    Color cor) { 
        this.centroOrbitaX = centroOrbitaX;
        this.centroOrbitaY = centroOrbitaY;
        this.distancia = distancia;
        this.angulo = angulo;
        this.raio = raio;
        this.cor = cor;
    }

    public void desenhar(GraphicsContext g) { 
        double largura = 2.0 * this.raio;
        double altura = 2.0 * this.raio;
        double nx = this.x - this.raio;
        double ny = this.y - this.raio;
        if (image != null) { 
            g.drawImage(image, nx, ny, largura, altura);
        } else { 
            g.setFill( this.cor );
            g.fillOval(nx, ny, largura, altura);
        }
    }

    public void update() { 
        this.anguloRad = angulo * Math.PI / 180.0;
        x = centroOrbitaX + (Math.cos(anguloRad) * distancia);
        y = centroOrbitaY + (Math.sin(anguloRad) * distancia);
        angulo += getVelocidadeAngular();                         
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

    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distanciaSol) {
        this.distancia = distanciaSol;
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

    public double getAngulo() {
        return angulo;
    }
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    
    public double getAnguloRad() {
        return anguloRad;
    }
    public void setAnguloRad(double anguloRad) {
        this.anguloRad = anguloRad;
    }

    
    public double getVelocidadeAngular() {
        return velocidadeAngular;
    }
    public void setVelocidadeAngular(double velocidadeAngular) {
        this.velocidadeAngular = velocidadeAngular;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}