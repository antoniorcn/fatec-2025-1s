package edu.curso;

public class Pizzaria {
    public static void main(String[] args) {
        Pizza p1 = new PizzaCalabresa();
        Pizza p2 = new PizzaMussarela();

        p1.preparar();
        p1.cortar();
        p1.servir();

        p2.preparar();
        p2.cortar();
        p2.servir();
    }
}
