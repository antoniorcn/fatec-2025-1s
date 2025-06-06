package edu.curso;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class SistemaSolar extends Application {
    public void start(Stage stage) { 
        Pane pane = new Pane();
        Scene scn = new Scene(pane, 800, 600);

        Canvas canvas = new Canvas(800, 600);
        pane.getChildren().add(canvas);

        GraphicsContext ctx = canvas.getGraphicsContext2D();
       

        AnimationTimer animacao = new AnimationTimer() {
            private double terraAngulo = 0.0;

            public void handle( long milisec ) { 
                // Recalcular regras
                double nx = 400 - (100/2);
                double ny = 300 - (100/2);
                double terraAnguloRad = terraAngulo * Math.PI / 180;
                double terraDistancia = 200.0;
                double terraX = (400 + (Math.cos( terraAnguloRad ) * terraDistancia)) - 20;
                double terraY = (300 + (Math.sin( terraAnguloRad ) * terraDistancia)) - 20;

                // Desenhar a tela
                ctx.setFill( Color.BLACK );
                ctx.fillRect(0, 0, 800, 600);

                ctx.setFill( Color.ORANGE );
                ctx.fillOval(nx, ny, 100, 100);

                ctx.setFill(Color.BLUE);
                ctx.fillOval(terraX, terraY, 40, 40);

                terraAngulo += 0.1;
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
