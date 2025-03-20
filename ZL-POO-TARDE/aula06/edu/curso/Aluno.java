package edu.curso;

public class Aluno {
    String ra;

    public Aluno(String ra) { 
        Aluno.incrementaContador();
        this.ra = ra;
    }

    public static int contador ;

    public void mostrarAluno() { 
        System.out.println("RA: " + this.ra);
    }

    public static void incrementaContador() { 
        Aluno.contador ++;
    }
}
