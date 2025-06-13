package edu.curso;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application implements Executor {

    private ContatoBoundary telaContato;
    private ConsultaBoundary telaConsulta;
    private BorderPane panePrincipal = new BorderPane();

    public PrincipalBoundary() { 
        telaContato = new ContatoBoundary();
        telaContato.setExecutor( this );

        telaConsulta = new ConsultaBoundary();
        telaConsulta.setExecutor( this );
    }

    public void executar(String cmd, String ... parametros) { 
        System.out.println( "Executando comando: " + cmd);
        if ("SAIR".equals(cmd)) { 
            Platform.exit();
            System.exit(0);
        } else if ("ABRIR_CONTATO".equals(cmd)) { 
            panePrincipal.setCenter( telaContato.render() );
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        MenuBar menuBar = new MenuBar();
        panePrincipal.setTop( menuBar );

        Menu mnuArquivo = new Menu("Arquivo");
        Menu mnuCadastro = new Menu("Cadastro");
        Menu mnuAjuda = new Menu("Ajuda");
        menuBar.getMenus().addAll( mnuArquivo, mnuCadastro, mnuAjuda );

        MenuItem itemContato = new MenuItem("Contato");
        MenuItem itemConsulta = new MenuItem("Consulta");
        mnuCadastro.getItems().addAll(itemContato, itemConsulta);

        itemConsulta.setOnAction( 
            e -> panePrincipal.setCenter( telaConsulta.render() ) );
        itemContato.setOnAction( 
                e -> panePrincipal.setCenter( telaContato.render() ) );
        Scene scn = new Scene(panePrincipal, 800, 600);

        // panePrincipal.setCenter( telaConsulta.render() );

        stage.setScene(scn);
        stage.setTitle("Sistema de consultas medicas");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PrincipalBoundary.class, args);
    }
    
}
