package edu.curso;

public class Aluno { 

    String ra;
    static int contador;

    public Aluno( String ra ) { 
        super();
        Aluno.contador = Aluno.contador + 1;
        this.ra = ra;
    }

    public void mostrar() { 
        System.out.println("RA: " + this.ra);
    }

    public static void mostrarQuantidade() { 
        System.out.printf("Foram criados %d alnuos %n",
            Aluno.contador
            );
    }

}