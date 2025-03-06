package edu.curso;

public class Teste {

    public static void main(String[] args) { 
        // Porteiro p1 = new Porteiro( "111", "Joao", 8);
        // Porteiro p2 = new Porteiro( "222", "Maria", 9);
        Porteiro p1 = Porteiro.getInstancia();
        Porteiro p2 = Porteiro.getInstancia();

        System.out.println("P1 Nome: " + p1.nome);
        System.out.println("P2 Nome: " + p2.nome);
    }
    
}
