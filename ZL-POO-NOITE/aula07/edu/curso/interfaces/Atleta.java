package edu.curso.interfaces;

public class Atleta extends Pessoa implements Corredor {

    @Override
    public void correr() { 
        System.out.println("Atleta correndo..."); 
    }

    @Override
    public void aquecer() {
        System.out.println("Atleta aquecendo...");
    }
}
