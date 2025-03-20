package edu.curso;

abstract public class Pizza { 

    private int fatias = 8;

    public void cortar() { 
        System.out.println("Cortando em " + fatias + " fatias");
    }

    public void servir() { 
        System.out.println("Colocando uma fatia no prato");
    }

    abstract public void preparar();

}