package edu.curso;

public class Fogao {
    float tamanho;
    int quantidadeBocas;
    float consumoEnergia;
    float capacidadeForno;
    String cor;

    public void ignicaoBoca( int boca ) {
        System.out.println("Acendendo boca " + boca); 
    }

    public void liberarGas( int boca ) { 
        System.out.println("Gas liberado na boca " + boca);
    }

    public void abrirForno() { 
        System.out.println("Forno aberto");
    }
}
