package edu.curso;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
    private ObservableList<Contato> lista = FXCollections.observableArrayList();

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = 
            new SimpleObjectProperty<>(LocalDate.now());

    public void adicionar() {
        Contato c = new Contato();
        c.setNome( nome.get() );
        c.setTelefone( telefone.get());
        c.setEmail(email.get());
        c.setNascimento(nascimento.get());
        lista.add( c );
        nome.set("");
        telefone.set("");
        email.set("");
        nascimento.set(LocalDate.now());
    }
    
    public void pesquisarPorNome(){ 
        for (Contato c : lista) { 
            if (c.getNome().contains( nome.get() )) { 
                nome.set( c.getNome() );
                telefone.set( c.getTelefone() );
                email.set( c.getEmail() );
                nascimento.set( c.getNascimento() );
            }
        }
    }

    public void apagar( Contato c ) { 
        lista.remove( c );
    }

    public void contatoParaTela( Contato c ) { 
        if (c != null) { 
            nome.set( c.getNome() );
            telefone.set( c.getTelefone() );
            email.set( c.getEmail() );
            nascimento.set( c.getNascimento() );
        }
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }
    public StringProperty telefoneProperty() { 
        return this.telefone;
    }
    public StringProperty emailProperty() { 
        return this.email;
    }
    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return this.nascimento;
    }

    public ObservableList<Contato> listaProperty() { 
        return this.lista;
    }
}
