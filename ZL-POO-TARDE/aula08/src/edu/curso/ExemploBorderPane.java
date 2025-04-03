package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class ExemploBorderPane extends Application { 
    @Override
    public void start(Stage stage) { 
        BorderPane painel = new BorderPane();
        Scene scn = new Scene(painel, 800, 600);

        Label texto = new Label(" Ola Mundo Java FX ");
        painel.setTop( texto );

        Button btnClick = new Button("Clique-me");
        painel.setBottom(btnClick);

        TextField txtNome = new TextField();
        painel.setCenter(txtNome);

        stage.setScene(scn);
        stage.setTitle("Meu primeiro programa JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ExemploBorderPane.class, args);
    }
}