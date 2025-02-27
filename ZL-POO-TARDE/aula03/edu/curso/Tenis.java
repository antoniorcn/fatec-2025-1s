package edu.curso;

public class Tenis {
    String cor;
    int tamanho;
    String marca;

    Cadarco cadarcoEsquerdo;
    Cadarco cadarcoDireito;

    public Tenis() { 
        cadarcoEsquerdo = new Cadarco();
        cadarcoDireito = new Cadarco();
    }

    public void anunciar() { 
        System.out.printf("Oferta tenis %s tamanho %d na cor %s %n",
            this.marca, this.tamanho, this.cor);
    }
}
