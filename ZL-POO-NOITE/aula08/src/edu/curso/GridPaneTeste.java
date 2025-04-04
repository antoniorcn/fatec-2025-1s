package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
public class GridPaneTeste extends Application { 
	@Override
	public void start(Stage stage) {
		GridPane painel = new GridPane();
		Scene scn = new Scene( painel, 600, 400 );
		Label texto = new Label("Ola mundo JavaFX");
		Button btn = new Button("Clique aqui");
		TextField txtNome = new TextField();

		painel.setHgap(20);
		painel.setVgap(50);

		painel.add( texto, 0, 0, 2, 1 );
		painel.add( btn, 0, 1 );
		painel.add(txtNome, 1, 1, 3, 1);
		
		stage.setScene( scn );
		stage.setTitle("Ola Mundo Java FX");
		stage.show();
	}
	public static void main(String[] args) { 
		Application.launch(GridPaneTeste.class, args);
	}
}
