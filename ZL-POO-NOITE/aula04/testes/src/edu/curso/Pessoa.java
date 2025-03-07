package edu.curso;

public class Pessoa {
    String nome;
    String documento;

    Pessoa( String nome, String documento) { 
        this.nome = nome;
        this.documento = documento;
    }

    public boolean equals(Pessoa outra) { 
        return this.nome.equals(outra.nome) 
            && this.documento.equals(outra.documento);
    }

    public String toString() { 
        return String.format("[nome: '%s', documento: '%s']", this.nome, this.documento);
        // return "[nome: '" + this.nome + "', documento: '" + this.documento + "']";
    }
}
