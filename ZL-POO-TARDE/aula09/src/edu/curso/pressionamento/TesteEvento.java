package edu.curso.pressionamento;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class ManipuladorEventos implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent e) { 
        MouseButton botoes = e.getButton();
        System.out.println("Type: " + e.getEventType().getName());
        System.out.println("Source: " + e.getSource().getClass().getCanonicalName());
        System.out.println("Target: " + e.getTarget().getClass().getCanonicalName());
        System.out.printf("Pos (X, Y): (%5.2f, %5.2f)%n", e.getX(), e.getY());
        System.out.printf("Buttons: (%s,)%n", botoes.name());
    }

}

public class TesteEvento extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Scene scn = new Scene(pane, 600, 400);

        ManipuladorEventos man = new ManipuladorEventos();

        Label lblTitulo = new Label("Teste de Eventos");
        Label lblMensagem = new Label("Sem mensagens no momento...");
        Button btnAperteAqui = new Button("Aperte Aqui");

        btnAperteAqui.addEventFilter(MouseEvent.ANY, man);

        pane.setTop( lblTitulo );
        pane.setCenter( lblMensagem );
        pane.setBottom( btnAperteAqui );

        stage.setScene( scn );
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteEvento.class, args);
    }
    
}
