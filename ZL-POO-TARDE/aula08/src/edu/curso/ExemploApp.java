package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ExemploApp extends Application { 
    @Override
    public void start(Stage stage) { 
        Pane painel = new Pane();
        Scene scn = new Scene(painel, 800, 600);

        Label texto = new Label(" Ola Mundo Java FX ");
        texto.relocate(400, 50);
        painel.getChildren().add( texto );

        Button btnClick = new Button("Clique-me");
        btnClick.relocate(400, 200);
        painel.getChildren().add(btnClick);

        TextField txtNome = new TextField();
        txtNome.relocate(400, 100);
        painel.getChildren().add(txtNome);

        stage.setScene(scn);
        stage.setTitle("Meu primeiro programa JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}