package edu.curso;

public class Conexao { 

    String nome;
    String tipo;

    private static Conexao instancia;

    private Conexao(String nome, String tipo) { 
        this.nome = nome;
        this.tipo = tipo;
    }

    public static Conexao getInstancia() { 
        if (instancia == null) { 
            instancia = new Conexao("Fatec", "Oracle");
        }
        return instancia;
    }



}