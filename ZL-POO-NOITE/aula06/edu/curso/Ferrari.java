package edu.curso;

public class Ferrari extends Carro {
    
    public static void embalar() { 
        Carro.embalar();
        System.out.println("Embalando a ferrari");
    }
}
