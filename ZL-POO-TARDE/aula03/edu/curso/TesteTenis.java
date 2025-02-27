package edu.curso;
public class TesteTenis {

    public static void main(String[] args) {
        Tenis t1 = new Tenis();
        t1.marca = "Olympikus";
        t1.tamanho = 42;
        t1.cor = "preta";

        Tenis t2 = new Tenis();
        t2.marca = "Fila";
        t2.tamanho = 42;
        t2.cor = "preta";

        t1.anunciar();
        t2.anunciar();
    }
    
}
