package edu.curso;

public class Carro extends Automovel {

    Roda roda;
    String fabricante;
    String modelo;
    int ano;
    private Motor motor = new Motor();

    public Carro(String fabricante, String modelo) { 
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.roda = new Roda();
    }

    public void acelerar() { 
        System.out.println("Acelerando o carro");
        motor.acelerar();
        roda.rodar();
    }

    public void ligar() { 
        motor.ligar();
        darPartida();
        acelerar();
    }
    
}
