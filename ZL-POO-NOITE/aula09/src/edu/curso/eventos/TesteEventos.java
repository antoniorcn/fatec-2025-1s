package edu.curso.eventos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


class AssinanteEvento implements EventHandler<Event> { 
    public void handle(Event e) { 
        System.out.println("Tipo: " + e.getEventType().getName());
        System.out.println("Source: " + e.getSource().getClass().getCanonicalName());
        System.out.println("Target: " + e.getTarget().getClass().getCanonicalName());
        e.consume();
    }
}

class AssinanteMouse implements EventHandler<MouseEvent> { 
    public void handle(MouseEvent e) { 
        System.out.println("Tipo: " + e.getEventType().getName());
        System.out.println("Source: " + e.getSource().getClass().getCanonicalName());
        System.out.println("Target: " + e.getTarget().getClass().getCanonicalName());
        System.out.printf("Posicao(%5.2f, %5.2f) - Botoes %s%n", e.getX(), e.getY(), e.getButton().name() );
    }
}

class AssinanteAction implements EventHandler<ActionEvent> { 
    public void handle(ActionEvent e) { 
        System.out.println("Botão Presionado");
    }
}

public class TesteEventos extends Application {

    @Override
    public void start(Stage stage) { 
        
        AssinanteEvento ae = new AssinanteEvento();
        AssinanteMouse am = new AssinanteMouse();
        AssinanteAction aa = new AssinanteAction();

        BorderPane bp = new BorderPane();

        Scene scn = new Scene( bp, 600, 400);

        scn.addEventFilter(Event.ANY, ae);
        // scn.addEventFilter(MouseEvent.ANY, ae);

        Label lblTitulo = new Label("Teste de Eventos");
        Label lblMensagem = new Label("sem mensagens no momento ...");
        Button btnOk = new Button("Aperte-me");

        // lblTitulo.addEventFilter(MouseEvent.ANY, am);

        btnOk.addEventFilter(ActionEvent.ANY, aa);
        // btnOk.addEventFilter(ActionEvent.ANY, ae);

        bp.setTop(lblTitulo);
        bp.setCenter(lblMensagem);
        bp.setBottom(btnOk);

        stage.setScene(scn);
        stage.setTitle("Teste de Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteEventos.class, args);
    }
    
}
