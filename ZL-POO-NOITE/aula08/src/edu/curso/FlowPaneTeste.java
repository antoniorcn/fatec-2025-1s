package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class FlowPaneTeste extends Application { 
	@Override
	public void start(Stage stage) {
		FlowPane painel = new FlowPane();
		Scene scn = new Scene( painel, 600, 400 );
		Label texto = new Label("Ola mundo JavaFX");
		Button btn = new Button("Clique aqui");
		TextField txtNome = new TextField();

		painel.setHgap(20);
		painel.setVgap(50);

		painel.getChildren().addAll( texto, btn, txtNome );
		stage.setScene( scn );
		stage.setTitle("Ola Mundo Java FX");
		stage.show();
	}
	public static void main(String[] args) { 
		Application.launch(FlowPaneTeste.class, args);
	}
}
