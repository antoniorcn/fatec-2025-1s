package edu.curso;

public class Gato extends Animal {

    public void fazerSom() { 
        System.out.println("Miau .... Miau....");
        System.out.println("reaproveitando o fazerSom do animal");
        super.fazerSom();
    }
    
}
