package edu.curso;

public class Aluno {
    String matricula;
    String nome;
    float nota;

    boolean matricularDisciplina(String nome) { 
        System.out.println("Matriculando na disciplina " + nome);
        if ("POO".equals(nome)) { 
            return nota > 6.0f;
        } else { 
            return true;
        }
    }
}
