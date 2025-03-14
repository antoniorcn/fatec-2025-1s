package edu.curso;

public class LamborguiniAVT2020 extends Carro {

    public LamborguiniAVT2020() { 
        super("Lamborguini", "AVT2020");
    }

    public void turbo() { 
        System.out.println("Ativando o turbo");
        acelerar();
    }
    
}
