package edu.curso;

public class Pessoa {
    String nome;    // null
    int idade;      // 0
    String genero;  // null
    public Pessoa(String nome, int idade) { 
        System.out.printf("Pessoa instanciada com Nome: %s e  Idade: %d %n",
           nome, idade );
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa() { 
        System.out.println("Pessoa instanciada com construtor vazio");
    }
}
