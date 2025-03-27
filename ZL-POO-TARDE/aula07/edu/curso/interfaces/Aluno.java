package edu.curso.interfaces;

public class Aluno { 
    private String nome;
    private String ra;
    private int idade;

    public Aluno() { 
        this("Desconhecido", "000000", 18);
    }

    public Aluno(String nome, String ra, int idade) { 
        super();
        setNome(nome);
        setRa(ra);
        setIdade(idade);
    }

    public void estudar() { 
        System.out.println("Aluno estudando...");
    }


    public String getNome() { 
        return nome;
    }
    public void setNome(String valor) {
        if (valor != null && valor.length() > 0) { 
            this.nome = valor;
        }
    }

    public String getRa() { 
        return this.ra;
    }
    public void setRa(String valor) { 
        this.ra = valor;
    }

    public int getIdade() { 
        return this.idade;
    }
    public void setIdade(int valor) { 
        if (valor > 0) {
            this.idade = valor;
        }
    }

}