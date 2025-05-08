package edu.curso;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteProperties {

    public static void main(String[] args) {
        StringProperty email = new SimpleStringProperty("");
        StringProperty outroEmail = new SimpleStringProperty("");
        // outroEmail.bind(email);
        Bindings.bindBidirectional(email, outroEmail);

        // ChangeListener<String> listener = new ChangeListener<>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, 
        //                             String oldValue, String newValue) {
        //         atualizada(newValue);
        //     }
        // };
        // email.addListener( listener );
        email.addListener( (observable, oldValue, newValue)->{
            atualizada(newValue);
        });
        email.set( "email2@teste.com" );
        System.out.println("Atualizei o email");
        System.out.println(outroEmail.get());
    }

    public static void atualizada(String valorAtual) { 
        System.out.println("Novo email: " + valorAtual);
    }
    
}
