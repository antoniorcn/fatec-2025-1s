package edu.curso;

public class Escola {
    public static void main(String[] args) {
        Aluno.contador = 1000;
        
        Aluno a1 = new Aluno("00001");
        Aluno a2 = new Aluno("00002");
        Aluno a3 = new Aluno("00003");

        a1.mostrarAluno();
        a2.mostrarAluno();
        a3.mostrarAluno();

        System.out.println("Foram criados: " + Aluno.contador + " alunos");
    }
}
