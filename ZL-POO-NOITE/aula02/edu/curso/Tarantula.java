package edu.curso;

import java.time.LocalDate;

public class Tarantula {
    int idade;
    int ecdise;
    String nome;
    String especie;
    LocalDate ultimaRefeicao;
    

    public void trocarPele() { 
        ecdise += 1;
    }

    public LocalDate seAlimentar() { 
        ultimaRefeicao = LocalDate.now();
        return ultimaRefeicao;
    }

    public void refazerToca() { 
        System.out.println("Refazendo a toca");
    }
    
}
