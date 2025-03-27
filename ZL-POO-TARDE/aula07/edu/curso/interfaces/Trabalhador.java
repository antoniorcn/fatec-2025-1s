package edu.curso.interfaces;

public interface Trabalhador {
    
    void trabalhar();
    void descansar();

    default void receberSalario( float salario ) { 
        trabalhar();
        System.out.println("Oba... Recebendo salario: " + salario);
        descansar();
    }
}
