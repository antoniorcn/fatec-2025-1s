package edu.curso.aeroporto;

public class Passageiro extends Pessoa {
    private String numeroPassagem;
    private String origem;
    private String destino;

    public Passageiro(String nome, String documento, int idade, 
                String numeroPassagem, 
                String origem, String destino) {
        super(nome, documento, idade);
        this.numeroPassagem = numeroPassagem;
        this.origem = origem;
        this.destino = destino;
    }

    public String getNumeroPassagem() {
        return numeroPassagem;
    }
    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
