package edu.curso;

public class Caneta {
    String cor;
    String fabricante;
    String modelo;
    int ano;
    boolean possuiHaste;

    public void escrever() { 
        System.out.println("Caneta escrevendo");
    }

    public void desmontar() { 
        System.out.println("Caneta desmontada");
    }

    public void montar() { 
        System.out.println("Caneta montada");
    }
}
