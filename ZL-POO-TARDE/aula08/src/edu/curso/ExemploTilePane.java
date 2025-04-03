package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ExemploTilePane extends Application { 
    @Override
    public void start(Stage stage) { 
        TilePane painel = new TilePane();
        Scene scn = new Scene(painel, 800, 600);
        painel.setPrefRows(2);
        painel.setHgap(10);
        painel.setVgap(20);

        Label texto = new Label(" Ola Mundo Java FX ");
        painel.getChildren().add( texto );

        Button btnClick = new Button("Clique-me");
        painel.getChildren().add(btnClick);

        TextField txtNome = new TextField();
        painel.getChildren().add(txtNome);

        stage.setScene(scn);
        stage.setTitle("Meu primeiro programa JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ExemploGridPane.class, args);
    }
}