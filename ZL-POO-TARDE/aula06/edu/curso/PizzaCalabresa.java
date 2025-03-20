package edu.curso;

public class PizzaCalabresa extends Pizza {
    
    @Override
    public void preparar() { 
        System.out.println("Colocando calabreza");
        System.out.println("Deixando assar por 8 minutos");
    }
}
