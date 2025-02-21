package edu.curso;

public class Funcionario {

    float salario;

    float receberPagamento(float ... beneficios) { 
        float soma = 0.0f;
        for (int i = 0; i < beneficios.length; i++) { 
            soma += beneficios[i];
        }
        return salario + soma;
    }
    
}