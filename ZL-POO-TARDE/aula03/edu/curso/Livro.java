package edu.curso;

public class Livro {
    String titulo;
    int ano;
    Autor autor;
    String publicadora;

    public Livro( String titulo, int ano, Autor autor, String publicadora) { 
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.publicadora = publicadora;
    }
}
