package edu.curso;

import java.time.LocalDate;

public class Autor {
    String nome;
    LocalDate nascimento;
    String formacao;

    public Autor(String nome, LocalDate nascimento, String formacao) { 
        this.nome = nome;
        this.nascimento = nascimento;
        this.formacao = formacao;
    }
}
