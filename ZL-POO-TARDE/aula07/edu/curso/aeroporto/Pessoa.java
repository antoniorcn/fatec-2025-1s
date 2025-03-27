package edu.curso.aeroporto;

public class Pessoa {   
    private String nome;
    private String documento;
    private int idade;

    public Pessoa( String nome, String documento, int idade) { 
        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
