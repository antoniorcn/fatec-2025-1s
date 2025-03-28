package edu.curso.interfaces;

public interface Corredor {
    
    void correr();
    void aquecer();
    default void fazerAquecimento() { 
        System.out.println("Fazendo aquecimento antes de correr..."); 
        aquecer();
    }

}
