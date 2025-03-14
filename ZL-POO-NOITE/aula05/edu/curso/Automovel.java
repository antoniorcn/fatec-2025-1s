package edu.curso;
public class Automovel { 
    String combustivel;
    int velocidade;

    public Automovel( String combustivel ) { 
        super();
        this.combustivel = combustivel;
    }

    public void darPartida() {
        System.out.println("Dando a partida no automóvel");
    }

}