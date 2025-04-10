package edu.curso.observer;

public class Aposentado implements Assinante {

    @Override
    public void lerNoticia(String n) { 
        System.out.println("Esta lendo sobre " + n +
         " no banco da praça");
    }
    
}
