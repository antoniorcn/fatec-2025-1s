package edu.curso.interfaces;

public class Cavalo extends Animal implements Corredor {
    public void correr() { 
        System.out.println("Cavalo correndo..."); 
    }

    public void aquecer() {
        System.out.println("Cavalo aquecendo dando voltas hipódromo...");
    }
}
