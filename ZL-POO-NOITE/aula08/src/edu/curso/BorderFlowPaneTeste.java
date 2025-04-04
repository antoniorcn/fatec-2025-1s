package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class BorderFlowPaneTeste extends Application { 
	@Override
	public void start(Stage stage) {
		BorderPane painel = new BorderPane();
		Scene scn = new Scene( painel, 600, 400 );
		Label texto = new Label("Ola mundo JavaFX");
		Button gravar = new Button("Gravar");
		Button pesquisar = new Button("Pesquisar");
		FlowPane paneBotoes = new FlowPane();
		paneBotoes.getChildren().addAll(gravar, pesquisar);
		TextField txtNome = new TextField();

		painel.setTop(texto);
		painel.setCenter(txtNome);
		painel.setBottom( paneBotoes );
		stage.setScene( scn );
		stage.setTitle("Ola Mundo Java FX");
		stage.show();
	}
	public static void main(String[] args) { 
		Application.launch(BorderFlowPaneTeste.class, args);
	}
}
