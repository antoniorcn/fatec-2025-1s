package edu.curso;
public class Zoologico {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Cachorro c1 = new Cachorro();
        a1.fazerSom();
        c1.fazerSom();
        Animal b1 = new Cachorro();
        b1.fazerSom();
        b1.dormir();
    }
}
