package edu.curso;

import javafx.scene.image.Image;

public class SpriteTiro extends Sprite {
    private final double screenWidth;
    private final double screenHeight;
    private double velocidade = 2.0;
    private boolean finished = true;


    public SpriteTiro(Image imagem, double screenWidth, double screenHeight, double x, double y, double w, double h) {
        super(imagem,  x,  y,  w, h);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void update() {
        if (!finished) {
            this.setX(this.getX() + velocidade);
            // this.setY(this.getY() + velocidade);

            if (this.getX() < 0 || this.getX() > screenWidth) {
                finished = true;
            }
            if (this.getY() < 0 || this.getY() > screenHeight) {
                finished = true;
            }
        }
    }

    public boolean isFinished() {
        return finished;
    }
    public void setFinished(boolean value) {
        this.finished = value;
    }
}
