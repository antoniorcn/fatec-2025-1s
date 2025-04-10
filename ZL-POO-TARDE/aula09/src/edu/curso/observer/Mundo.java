package edu.curso.observer;

public class Mundo {
    public static void main(String[] args) {
        Revista veja = new Revista("Veja");
        Revista forbes = new Revista("Forbes");

        Estudante joao = new Estudante("Joao");
        Estudante maria = new Estudante("Maria");
        Aposentado pedro = new Aposentado();
        Aposentado sofia = new Aposentado();

        veja.adicionar( joao );
        veja.adicionar( pedro );
        forbes.adicionar( maria );
        forbes.adicionar( sofia );
        forbes.adicionar( joao );

        veja.avisarAssinante("Entrada gratuita no estado do Itaquerão para o proximo campeonato");

        forbes.avisarAssinante("Empresa unicornio nascida na Fatec Zona Leste conquista o mercado");




    }
    
}
