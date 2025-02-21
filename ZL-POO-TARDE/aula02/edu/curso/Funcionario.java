package edu.curso;

public class Funcionario {
    float salario;
    float receberBeneficios(float ... beneficios) { 
        float soma = salario;
        for (int i = 0; i < beneficios.length; i++) { 
            soma += beneficios[i];
        }
        return soma;
    }
}


