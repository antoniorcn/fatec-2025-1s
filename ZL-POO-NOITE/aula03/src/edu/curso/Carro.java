package edu.curso;

public class Carro { 

    String fabricante;
    int ano;
    String modelo;
    Pneu pneu;
    private Motor motor;

    public Carro(String fabricante, int ano, String modelo) { 
        this.pneu = new Pneu(14, 145);
        this.motor = new Motor(fabricante, 1.8);

        this.fabricante = fabricante;
        this.ano = ano;
        this.modelo = modelo;
    }
}