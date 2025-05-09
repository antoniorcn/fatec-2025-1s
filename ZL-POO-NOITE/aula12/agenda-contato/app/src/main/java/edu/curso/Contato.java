package edu.curso;

import java.time.LocalDate;

public class Contato {
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private LocalDate nascimento = LocalDate.now();

    public String getNome() { 
        return this.nome;
    }
    public void setNome( String valor ) { 
        this.nome = valor;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
