package edu.curso.observer;

public class Estudante implements Assinante {

    private String nome;

    public Estudante( String nome ) { 
        this.nome = nome;
    }

    @Override
    public void lerNoticia(String noticia) { 
        System.out.println(this.nome + " lendo sobre " + noticia + 
                    " sentado no sofá da Fatec ZL");
    }

    public String getNome() { 
        return this.nome;
    }
    
}
