package edu.curso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application {

    private Boundary telaFichaMedica = new FichaMedicaBoundary();
    private Boundary telaContato = new ContatoBoundary();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene(panePrincipal, 800, 600);

        MenuBar menuBar = new MenuBar();

        Menu mnuCadastro = new Menu("Cadastro");
        Menu mnuCreditos = new Menu("Créditos");
        menuBar.getMenus().addAll( mnuCadastro, mnuCreditos );

        MenuItem mnuContato = new MenuItem("Contato");
        MenuItem mnuFichaMedica = new MenuItem("Ficha Medica");
        MenuItem mnuSair = new MenuItem("Sair");
        mnuCadastro.getItems().addAll( mnuContato, mnuFichaMedica, mnuSair);

        MenuItem mnuSobre = new MenuItem("Sobre");
        mnuCreditos.getItems().addAll( mnuSobre );

        panePrincipal.setTop(menuBar);

        mnuContato.setOnAction( e -> panePrincipal.setCenter( telaContato.render() ) );
        mnuFichaMedica.setOnAction( e -> panePrincipal.setCenter( telaFichaMedica.render() ) );
        mnuSair.setOnAction( e -> {
            Platform.exit();
            System.exit(0);
        });

        mnuSobre.setOnAction( e-> 
            new Alert(AlertType.INFORMATION, 
                "Feito por Antonio Carvalho", 
                ButtonType.OK).show()
        );

        // FlowPane panBotoes = new FlowPane();
        // panePrincipal.setTop( panBotoes );
        // Button btnContato = new Button("Contato");
        // Button btnFichaMedica = new Button("FichaMedica");
        // panBotoes.getChildren().addAll(btnContato, btnFichaMedica);
        // btnContato.setOnAction( e -> {
        //     panePrincipal.setCenter( telaContato.render() );
        // });
        // btnFichaMedica.setOnAction( e -> {
        //     panePrincipal.setCenter( telaFichaMedica.render() );
        // });

        stage.setScene(scn);
        stage.setTitle("Sistema Medico");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args);
    }
    
}
