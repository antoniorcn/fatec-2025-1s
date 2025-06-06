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
public class SistemaSolar extends Application {

    private Planeta sol = new Planeta(0, 100, 
    400, 300, 0, Color.ORANGE);

    private Planeta terra = new Planeta(200, 50, 
    400, 300, 1, Color.BLUE);

    private Planeta marte = new Planeta(300, 40, 
    400, 300, 1.5, Color.RED);    

    private Planeta lua = new Planeta(80, 5, 
    terra.getX(), terra.getY(), 2, Color.WHITE);

    public Image carregarImagem( String path ) { 
        InputStream is = getClass().getResourceAsStream(path);
        if (is != null) {
            return new Image( is );
        }
        return null;
    }

    public void start(Stage stage) { 
        Pane pane = new Pane();
        Scene scn = new Scene(pane, 800, 600);

        Canvas canvas = new Canvas(800, 600);
        pane.getChildren().add(canvas);

        GraphicsContext ctx = canvas.getGraphicsContext2D();

        sol.setImagem( carregarImagem("images/sol.png") );
        terra.setImagem( carregarImagem("images/terra.png") );
        marte.setImagem( carregarImagem("images/marte.png") );
        lua.setImagem( carregarImagem("images/lua.png") );

        canvas.requestFocus();

        canvas.setOnKeyPressed(e -> { 
            if (e.getCode() == KeyCode.Q) { 
                terra.setDistancia( terra.getDistancia() + 10);
            } else if (e.getCode() == KeyCode.A) { 
                terra.setDistancia( terra.getDistancia() - 10);
            } else if (e.getCode() == KeyCode.W) { 
                marte.setDistancia( marte.getDistancia() + 10);
            } else if (e.getCode() == KeyCode.S) { 
                marte.setDistancia( marte.getDistancia() - 10);
            } else if (e.getCode() == KeyCode.E) { 
                lua.setDistancia( lua.getDistancia() + 10);
            } else if (e.getCode() == KeyCode.D) { 
                lua.setDistancia( lua.getDistancia() - 10);
            }
        });
       

        AnimationTimer animacao = new AnimationTimer() {
            public void handle( long milisec ) { 
                // Recalcular regras
                sol.update();
                terra.update();
                marte.update();
                lua.setCentroOrbitaX( terra.getX() + terra.getRaio() );
                lua.setCentroOrbitaY( terra.getY() + terra.getRaio() );
                lua.update();

                // Desenhar a tela
                ctx.setFill( Color.BLACK );
                ctx.fillRect(0, 0, 800, 600);

                sol.draw(ctx);
                terra.draw(ctx);
                marte.draw(ctx);
                lua.draw(ctx);
            }
            
        };

        animacao.start();

        stage.setScene(scn);
        stage.setTitle("Sistema Solar");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(SistemaSolar.class, args);
    }
    
}
