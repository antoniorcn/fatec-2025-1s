package edu.curso;
public class Teste { 
    public static void main( String[] args ) { 
        System.out.println("Executando a classe Teste");

        String diaSemana = "Quinta-Feira";
        int diaMes = 27;
        String mes = "Fevereiro";

        // System.out.println("Hoje é " + diaSemana + 
        // " dia " + diaMes + " de " + mes);
        System.out.printf("Hoje é %s dia %d de %s  %n",
        diaSemana, diaMes, mes);

        Pessoa p1 = new Pessoa("João Silva", 25);
        Pessoa p2 = new Pessoa("Maria Silva", 23);
        Pessoa p3 = new Pessoa("José Santos", 26);
        Pessoa p4 = new Pessoa();
    }
}