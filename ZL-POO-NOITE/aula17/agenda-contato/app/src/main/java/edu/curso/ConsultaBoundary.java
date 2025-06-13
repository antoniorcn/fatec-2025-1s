package edu.curso;

import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ConsultaBoundary implements Boundary {
    private TextField txtLocal = new TextField();
    private TextField txtEspecialidade = new TextField();
    private DatePicker dtaData = new DatePicker();
    private ComboBox<String> txtHora = new ComboBox<>();
    private TableView<Consulta> tabela = new TableView<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Executor executor;

    public void setExecutor( Executor e ) { 
        this.executor = e;
    }

    public Executor getExecutor() { 
        return this.executor;
    }


    public void createTable() { 
        TableColumn<Consulta, String> col1 = new TableColumn<>("Local");
        col1.setCellValueFactory(
            cell -> new ReadOnlyStringWrapper( cell.getValue().getLocal() )
        );

        TableColumn<Consulta, String> col2 = new TableColumn<>("Data e Hora");
        col2.setCellValueFactory(
            cell -> { 
                String strDate = dtf.format( cell.getValue().getDataHora() );
                return new ReadOnlyStringWrapper( strDate );
            }
        );

        TableColumn<Consulta, String> col3 = new TableColumn<>("Especialista");
        col3.setCellValueFactory(
            cell -> new ReadOnlyStringWrapper( cell.getValue().getEspecialidade() )
        );        

        TableColumn<Consulta, Void> col4 = new TableColumn<>("Ações");
        col4.setCellFactory(
            new Callback<TableColumn<Consulta,Void>,TableCell<Consulta,Void>>(){
                @Override
                public TableCell<Consulta, Void> call(TableColumn<Consulta, Void> param) {
                    return new TableCell<Consulta, Void>() { 
                        private Button btnApagar = new Button("Apagar");
                        @Override
                        public void updateItem(Void item, boolean empty) { 
                            super.updateItem(item, empty);
                            btnApagar.setDisable(true);
                            if (!empty) {
                                setGraphic( btnApagar );
                            } else {
                                setGraphic(null);
                            }
                        }
                    };
                }
            }
        );

        tabela.getColumns().addAll( col1, col2, col3, col4 );
        
    }

    public Pane render() { 
        ObservableList<String> horarios = 
            FXCollections.observableArrayList(
                "08:00", "10:00", "12:00", "14:00", "16:00", "18:00");
        txtHora.setItems(horarios);
        BorderPane panePrincipal = new BorderPane();
        GridPane paneForm = new GridPane();
        HBox paneBotoes = new HBox();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter( tabela );

        createTable();

        ColumnConstraints coluna1 = new ColumnConstraints();
        coluna1.setPercentWidth(30);

        ColumnConstraints coluna2 = new ColumnConstraints();
        coluna2.setPercentWidth(70);

        paneForm.getColumnConstraints().addAll( coluna1, coluna2 );

        paneForm.add( new Label("Local: "), 0, 0);
        paneForm.add( txtLocal, 1, 0);
        paneForm.add( new Label("Data e Hora: "), 0, 1);
        FlowPane horarioPane = new FlowPane();
        horarioPane.getChildren().addAll(dtaData, txtHora);
        paneForm.add( horarioPane, 1, 1);
        paneForm.add( new Label("Especialidade: "), 0, 3);
        paneForm.add( txtEspecialidade, 1, 3);

        paneForm.add( paneBotoes, 0, 4, 3, 1);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        Button btnSair = new Button("Sair");
        btnSair.setOnAction( e-> executor.executar( "SAIR") );
        Button btnVerContato = new Button("Ver Contato");
        btnVerContato.setOnAction( e-> executor.executar( "ABRIR_CONTATO") );

        paneBotoes.getChildren().addAll(btnSalvar, btnPesquisar, btnSair, btnVerContato);

        return panePrincipal;
    }
}
