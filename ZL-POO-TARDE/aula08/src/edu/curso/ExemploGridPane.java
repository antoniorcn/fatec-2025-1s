package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class ExemploGridPane extends Application { 
    @Override
    public void start(Stage stage) { 
        GridPane painel = new GridPane();
        Scene scn = new Scene(painel, 800, 600);
        painel.setHgap(10);
        painel.setVgap(20);

        Label texto = new Label(" Ola Mundo Java FX ");
        painel.add( texto,0,0 );

        Button btnClick = new Button("Clique-me");
        painel.add(btnClick, 0, 1);

        TextField txtNome = new TextField();
        painel.add(txtNome, 1, 1);

        stage.setScene(scn);
        stage.setTitle("Meu primeiro programa JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ExemploGridPane.class, args);
    }
}