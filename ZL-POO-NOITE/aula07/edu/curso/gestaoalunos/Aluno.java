package edu.curso.gestaoalunos;

import java.time.LocalDate;

public class Aluno {

    private long id;
    private String nome = "";
    private LocalDate nascimento = LocalDate.now();
    private String ra = "";

    public long getId() { 
        return this.id;
    }
    public void setId(long valor) { 
        this.id = valor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer("");
        sb.append("Id: " + this.id + "\n");
        sb.append("Nome: " + this.nome + "\n");
        sb.append("Ra: " + this.ra + "\n");
        sb.append("Nascimento: " + this.nascimento + "\n");
        return sb.toString();
    }
    
}
