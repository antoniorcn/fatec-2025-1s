package edu.curso;

public class PizzaMussarela extends Pizza {

    @Override
    public void preparar() { 
        System.out.println("Colocando queijo");
        System.out.println("Deixando assar por 5 minutos");
    }

}
