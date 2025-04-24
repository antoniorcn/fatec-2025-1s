package org.example;

interface Operacao {
    int executar(int a, int b);
}

public class Operacoes {
    public static void main(String[] args) {
        // Função lambda para somar dois números
        Operacao soma = (a, b) -> a + b;
        Operacao multiplicacao = (a, b) -> a * b;

        // Usando a função lambda
        int resultado = multiplicacao.executar(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}