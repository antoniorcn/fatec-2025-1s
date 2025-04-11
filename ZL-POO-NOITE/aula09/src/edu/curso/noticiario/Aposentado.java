package edu.curso.noticiario;

public class Aposentado implements Assinante {

    private String nome;

    public Aposentado(String nome) { 
        this.nome = nome;
    }

    @Override
    public void receberNoticia(String noticia) {
        System.out.printf("Aposentado %s lendo sobre %s no banco da praça %n",
            this.nome, noticia);
    } 

    public String getNome() { 
        return this.nome;
    }
    
}
