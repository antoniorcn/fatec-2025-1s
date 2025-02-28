package edu.curso;

public class Livro {

    String titulo;
    int ano;
    String publicadora;
    Autor autor;

    public Livro( String titulo, int ano, String publicadora, Autor autor) { 
        this.titulo = titulo;
        this.ano = ano;
        this.publicadora = publicadora;
        this.autor = autor;
    }

    public void vitrine() { 
        System.out.printf("Oferta livro %s, autor %s, ano %d publicado por %s%n",
            this.titulo, this.autor.nome, this.ano, this.publicadora);

    }
    
}
