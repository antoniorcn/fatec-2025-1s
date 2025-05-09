package edu.curso;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteProperties {


    public static void main(String[] args) {
        System.out.println("Teste de JavaFX Properties");

        StringProperty email = 
            new SimpleStringProperty("email");

        StringProperty outroEmail = 
            new SimpleStringProperty("email");
        

        // ChangeListener<String> assinante = new ChangeListener<>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, 
        //                 String oldValue, String newValue) {
        //         valorTrocado(oldValue, newValue);
        //     }
        // };

        // email.addListener( (observable, antigo, novo) -> {
        //     valorTrocado(antigo, novo);
        // });
        // outroEmail.bind(email);
        Bindings.bindBidirectional(email, outroEmail);
        email.set( "teste@teste.com" );
        System.out.println("Outro Email: " + outroEmail.get());
    }

    public static void valorTrocado( String velho, String novo) { 
        System.out.println("O email foi trocado de " + 
            velho + " para " + novo );
    }
    
}
