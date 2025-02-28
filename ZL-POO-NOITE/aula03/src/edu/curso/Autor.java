package src.edu.curso;

import java.time.LocalDate;

public class Autor {

    String nome;
    String formacao;
    LocalDate nascimento;

    public Autor(String nome, String formacao, LocalDate nascimento) { 
        this.nome = nome;
        this.formacao = formacao;
        this.nascimento = nascimento;
    }
    
}
