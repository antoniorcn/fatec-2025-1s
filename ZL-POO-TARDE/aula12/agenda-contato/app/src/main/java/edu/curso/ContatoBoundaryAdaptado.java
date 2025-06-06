/*
 * This source file was generated by the Gradle 'init' task
 */
package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContatoBoundaryAdaptado extends Application {

    private ContatoControlAdaptado control = new ContatoControlAdaptado();
    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private DatePicker dtaNascimento = new DatePicker();

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        GridPane paneForm = new GridPane();
        HBox paneBotoes = new HBox();

        ColumnConstraints colLabel = new ColumnConstraints();
        colLabel.setPercentWidth(30);

        ColumnConstraints colTextField = new ColumnConstraints();
        colTextField.setPercentWidth(70);

        RowConstraints linha = new RowConstraints();
        linha.setPrefHeight(50);

        paneForm.getColumnConstraints().addAll(colLabel, colTextField);
        paneForm.getRowConstraints().addAll(linha, linha, linha, linha, linha);

        Scene scn = new Scene(panePrincipal, 800, 600);

        Label lblNome = new Label("Nome");
        lblNome.setStyle("-fx-background-color: 'yellow'; -fx-font-size: 25px; -fx-width: '100%'; -fx-height: '100%'; -fx-rotate: 45");
        paneForm.add( lblNome, 0, 0);
        paneForm.add( txtNome, 1, 0);
        paneForm.add( new Label("Telefone:"), 0, 1);
        paneForm.add( txtTelefone, 1, 1);
        paneForm.add( new Label("Email:"), 0, 2);
        paneForm.add( txtEmail, 1, 2);
        paneForm.add( new Label("Nascimento:"), 0, 3);
        paneForm.add( dtaNascimento, 1, 3);

        Button btnSalvar = new Button("Salvar");

        btnSalvar.setOnAction( evento -> {
            Contato c1 = telaParaContato();
            control.cadastrar( c1 );
            new Alert(AlertType.INFORMATION, 
                "Contato gravado com sucesso", 
                            ButtonType.OK).show();
        });

        Button btnPesquisar = new Button("Pesquisar");

        btnPesquisar.setOnAction( evento -> {
            Contato c = control.pesquisarContato( txtNome.getText() );
            if (c != null) { 
                contatoParaTela( c );
            }
        });

        paneBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        paneForm.add( paneBotoes, 0, 4, 2, 1);

        panePrincipal.setCenter( paneForm );

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato");
        stage.show();
    }

    public Contato telaParaContato() { 
        Contato c = new Contato();
        c.setNome( txtNome.getText() );
        c.setTelefone( txtTelefone.getText() );
        c.setEmail( txtEmail.getText() );
        c.setNascimento( dtaNascimento.getValue() );
        return c;
    }

    public void contatoParaTela( Contato c ) { 
        txtNome.setText( c.getNome() );
        txtTelefone.setText( c.getTelefone() );
        txtEmail.setText( c.getEmail() );
        dtaNascimento.setValue( c.getNascimento() );
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
}
