package edu.curso;

public class Escola {

    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.matricula = "1111";
        a1.nome = "João Silva";
        a1.nota = 3.5f;

        a2.matricula = "2222";
        a2.nome = "Maria Silva";
        a2.nota = 6.7f;

        a1.matricularDisciplina("Matematica");
        a2.matricularDisciplina("POO");

    }
    
}
