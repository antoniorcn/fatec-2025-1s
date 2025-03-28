package edu.curso.interfaces;

public class Arena {
    
    public static void main(String[] args) {
        Cavalo c1 = new Cavalo();
        c1.comer();
        c1.fazerAquecimento();
        c1.correr();

        Carro c2 = new Carro();
        c2.fazerAquecimento();
        c2.correr();
    }

}
