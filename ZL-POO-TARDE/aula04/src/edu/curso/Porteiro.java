package edu.curso;

public class Porteiro { 
    String numero;
    String nome;
    int hora;

    private static Porteiro instancia;

    private Porteiro( String numero, String nome, int hora) { 
        this.numero = numero;
        this.nome = nome;
        this.hora = hora;
    }

    public boolean equals(Porteiro outro) { 
        return numero.equals(outro.numero) && nome.equals(outro.nome);
    }

    public static Porteiro getInstancia() { 
       /* if (instancia == null) { 
            instancia = new Porteiro("222", "Maria", 9);
        } 
        return instancia;
        */ 
        
        return new Porteiro("222", "Maria", 9);
    }
}