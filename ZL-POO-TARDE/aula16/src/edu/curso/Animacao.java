package edu.curso;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Animacao extends Application {
    private double centroX = 400.0;
    private double centroY = 300.0;
    private Planeta sol = new Planeta(centroX, centroY,
    100, 0, 0, Color.ORANGE);
    private Planeta terra = new Planeta(centroX, centroY,
    50, 200, 0, Color.BLUE);
    private Planeta marte = new Planeta(centroX, centroY,
    40, 300, 0, Color.RED);
    private Planeta lua = new Planeta(terra.getX(), terra.getY(),
    10, 60, 0, Color.WHITE);


    public Image carregarImagem( String path ) {
        InputStream is = getClass().getResourceAsStream(path);
        if (is != null) {
            return new Image(is);
        } 
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Pane pane = new Pane();
        Scene scn = new Scene(pane, 800, 600);

        Canvas canvas = new Canvas(scn.getWidth(), scn.getHeight());
        canvas.widthProperty().bind(scn.widthProperty());
        canvas.heightProperty().bind(scn.heightProperty());

        pane.getChildren().add( canvas );

        sol.setImage( carregarImagem( "./images/sol.png") );
        terra.setImage( carregarImagem( "./images/terra.png") );
        lua.setImage( carregarImagem( "./images/lua.png") );
        marte.setImage( carregarImagem( "./images/marte.png") );

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        // ctx.setFill(Color.ORANGE);
        // double hw = 100 / 2;
        // double hh = 100 / 2;
        // ctx.fillOval(400 - hw, 300 - hh, 100, 100);      
    
        pane.requestFocus();
        pane.setOnKeyPressed( e -> {
            System.out.println("KeyPressed: " + e.getCode());
            if (e.getCode() == KeyCode.A) { 
                terra.setDistancia(terra.getDistancia() - 10.0);
            } else if (e.getCode() == KeyCode.D) { 
                terra.setDistancia(terra.getDistancia() + 10.0);
            }
        });

        terra.setVelocidadeAngular( 2.0 );
        marte.setVelocidadeAngular( 3.0 );
        lua.setVelocidadeAngular( 5.0 );
        sol.setVelocidadeAngular(0);

        AnimationTimer animation = new AnimationTimer() { 
            public void handle( long milisecs ) { 
                ctx.setFill(Color.BLACK);
                ctx.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                terra.update();
                marte.update();
                lua.setCentroOrbitaX( terra.getX() );
                lua.setCentroOrbitaY( terra.getY() );
                lua.update();
                sol.update();

                sol.desenhar(ctx);
                terra.desenhar(ctx);
                marte.desenhar(ctx);
                lua.desenhar(ctx);
            }
        };

        animation.start();


        stage.setScene(scn);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Animacao.class, args);
    }
    
}
