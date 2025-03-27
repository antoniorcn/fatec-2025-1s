package edu.curso.interfaces;

public interface Professor extends Trabalhador {
    @Override
    default void receberSalario(float salario) {
        trabalhar();
        System.out.println("Professor... Recebendo salario: " + salario);
        descansar();
    }
}
