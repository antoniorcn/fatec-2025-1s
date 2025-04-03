package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TesteApp extends Application { 
	@Override
	public void start(Stage stage) {
		Pane painel = new Pane();
		Scene scn = new Scene( painel, 600, 400 );
		Label texto = new Label("Ola mundo JavaFX");
		Button btn = new Button("Clique aqui");
		TextField txtNome = new TextField();

		texto.relocate(300, 50);
		txtNome.relocate(300, 150);
		btn.relocate(300, 250);

		// painel.getChildren().add( texto );
		// painel.getChildren().add( btn );
		painel.getChildren().addAll( texto, btn, txtNome );
		stage.setScene( scn );
		stage.setTitle("Ola Mundo Java FX");
		stage.show();
	}
	public static void main(String[] args) { 
		Application.launch(TesteApp.class, args);
	}
}
