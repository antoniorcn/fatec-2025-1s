package edu.curso.interfaces;

public class Escola {

    public static void criarAluno() { 
        Aluno a1 = new Aluno();
        System.out.println("Nome: " + a1.getNome());
        a1.setNome( null );
        a1.setNome( "" );
        System.out.println("Nome: " + a1.getNome());
        a1.setNome("Joao Silva");
        System.out.println("Nome: " + a1.getNome());

        System.out.println("Idade: " + a1.getIdade());
        a1.setIdade(0);
        System.out.println("Idade: " + a1.getIdade());
        a1.setIdade(-9);
        System.out.println("Idade: " + a1.getIdade());
        a1.setIdade(20);
        System.out.println("Idade: " + a1.getIdade());
        
    }

    public static void criarEstagiarioFatec() { 
        EstagiarioFatec est1 = new EstagiarioFatec();
        est1.acessarApp();
        est1.aceitarCorrida();
        est1.dirigir();
        est1.estacionar();
        est1.estudarMuito();
        est1.dirigir();
        est1.trabalhar();
        est1.descansar();
    }

    public static void main(String[] args) {
        Escola.criarEstagiarioFatec();
    }
}
