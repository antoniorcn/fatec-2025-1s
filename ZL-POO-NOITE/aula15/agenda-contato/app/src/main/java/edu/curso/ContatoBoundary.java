package edu.curso;

import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ContatoBoundary extends Application {
    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private DatePicker dtaNascimento = new DatePicker();
    private ContatoControl control = new ContatoControl();
    private TableView<Contato> tabela = new TableView<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void bindings() { 
        Bindings.bindBidirectional(txtNome.textProperty(), 
                                        control.nomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), 
                                        control.telefoneProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), 
                                        control.emailProperty());
        Bindings.bindBidirectional(dtaNascimento.valueProperty(), 
                                        control.nascimentoProperty());
        tabela.setItems( control.listaProperty() );
    }

    public void createTable() { 
        TableColumn<Contato, String> col1 = new TableColumn<>("Nome");
        col1.setCellValueFactory(
            cell -> new ReadOnlyStringWrapper( cell.getValue().getNome() )
        );

        TableColumn<Contato, String> col2 = new TableColumn<>("Telefone");
        col2.setCellValueFactory(
            cell -> new ReadOnlyStringWrapper( cell.getValue().getTelefone() )
        );

        TableColumn<Contato, String> col3 = new TableColumn<>("Email");
        col3.setCellValueFactory(
            cell -> new ReadOnlyStringWrapper( cell.getValue().getEmail() )
        );        

        TableColumn<Contato, String> col4 = new TableColumn<>("Nascimento");
        col4.setCellValueFactory(
            cell -> { 
                String strDate = dtf.format( cell.getValue().getNascimento() );
                return new ReadOnlyStringWrapper( strDate );
            }
        );        

        tabela.getSelectionModel().selectedItemProperty().addListener(
            (obs, antigo, novo) -> control.contatoParaTela(novo)
        );

        TableColumn<Contato, Void> col5 = new TableColumn<>("Ações");
        col5.setCellFactory(
            new Callback<TableColumn<Contato,Void>,TableCell<Contato,Void>>(){
                @Override
                public TableCell<Contato, Void> call(TableColumn<Contato, Void> param) {
                    return new TableCell<Contato, Void>() { 
                        private Button btnApagar = new Button("Apagar");
                        @Override
                        public void updateItem(Void item, boolean empty) { 
                            super.updateItem(item, empty);
                            btnApagar.setDisable(true);
                            if (!empty) {
                                btnApagar.setOnAction( 
                                    act ->  {
                                        int linha = getIndex();
                                        Contato c = tabela.getItems().get( linha );
                                        control.apagar( c );
                                    }
                                );
                                setGraphic( btnApagar );
                            } else {
                                setGraphic(null);
                            }
                        }
                    };
                }
            }
        );

        tabela.getColumns().addAll( col1, col2, col3, col4, col5 );
        
    }

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        GridPane paneForm = new GridPane();
        HBox paneBotoes = new HBox();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter( tabela );

        bindings();
        createTable();

        ColumnConstraints coluna1 = new ColumnConstraints();
        coluna1.setPercentWidth(30);

        ColumnConstraints coluna2 = new ColumnConstraints();
        coluna2.setPercentWidth(70);

        paneForm.getColumnConstraints().addAll( coluna1, coluna2 );

        Label lblNome = new Label("Nome:");
        lblNome.setStyle("-fx-font-size: 20px; -fx-background-color: 'yellow'; -fx-rotate: -45; -fx-text-fill: 'red'; -fx-font-weigth: 'bold';");
        paneForm.add( lblNome, 0, 0);
        paneForm.add( txtNome, 1, 0);
        paneForm.add( new Label("Telefone: "), 0, 1);
        paneForm.add( txtTelefone, 1, 1);
        paneForm.add( new Label("Email: "), 0, 2);
        paneForm.add( txtEmail, 1, 2);
        paneForm.add( new Label("Nascimento: "), 0, 3);
        paneForm.add( dtaNascimento, 1, 3);

        paneForm.add( paneBotoes, 0, 4, 2, 1);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.setOnAction( evento -> {
            control.adicionar();
            new Alert( AlertType.INFORMATION, 
                "Contato salvo com sucesso", ButtonType.OK).show();
        } );

        btnPesquisar.setOnAction( evento -> {
            control.pesquisarPorNome();
         });

        paneBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        Scene scn = new Scene( panePrincipal, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
       Application.launch(ContatoBoundary.class, args);
    }
}
