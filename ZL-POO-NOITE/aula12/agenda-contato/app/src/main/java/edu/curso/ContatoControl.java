package edu.curso;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class ContatoControl {
    private List<Contato> lista = new ArrayList<>();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = 
            new SimpleObjectProperty<>(LocalDate.now());

    // public ContatoControl() { 
    //     telefone.addListener((observable, antigo, novo)->{
    //         System.out.println(novo);
    //     });
    // }

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

    public StringProperty nomeProperty() { 
        return nome;
    }
    public StringProperty telefoneProperty() { 
        return telefone;
    }
    public StringProperty emailProperty() { 
        return email;
    }
    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return nascimento;
    }
}
