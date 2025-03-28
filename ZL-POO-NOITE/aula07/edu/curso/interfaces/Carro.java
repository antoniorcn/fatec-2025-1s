package edu.curso.interfaces;

public class Carro implements Corredor {
    public void correr() { 
        System.out.println("Carro correndo..."); 
    }

    public void aquecer() {
        System.out.println("Carro aquecendo, na garagem..."); 
    }
}
