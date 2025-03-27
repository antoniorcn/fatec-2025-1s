package edu.curso.interfaces;

public class EstagiarioFatec extends AlunoFatec implements Trabalhador, Uber {
    
    @Override
    public void trabalhar() { 
        System.out.println("Estagiario trabalhando...");
    }

    @Override
    public void descansar() { 
        System.out.println("Estagiario descansando...");
    }

    @Override
    public void dirigir() { 
        System.out.println("Estagiario dirigindo...");
    }

    @Override
    public void estacionar() { 
        System.out.println("Estagiario estacionando...");
    }

    @Override
    public void acessarApp() { 
        System.out.println("Estagiario acessando app...");
    }

    @Override
    public void aceitarCorrida() { 
        System.out.println("Estagiario aceitando corrida...");
    }
}

