package edu.curso;

public class Celular {
    String marca;
    String modelo;
    int memoria;
    Tela tela;
    private Bateria bateria;

    public Celular(String marca, String modelo, 
            int memoria, int tamanhoTela, int duracaoBateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoria = memoria;
        this.tela = new Tela(tamanhoTela,
                     "Gorilla glass");
        this.bateria = new Bateria(6000, duracaoBateria,
            marca);      
    }

    public void ligar() { 
        System.out.printf("Celular %s modelo %s ligado %n",
            this.marca, this.modelo);
        System.out.printf("Tela tipo %s tamanho %d %n", this.tela.tipo,
        this.tela.tamanho);
        System.out.printf("Carga da bateria: %dmha  duracao: %d horas%n",
            this.bateria.carga, this.bateria.duracao);
    }
}
