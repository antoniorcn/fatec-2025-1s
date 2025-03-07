package edu.curso;

public class TestePorteiro {

    public static void main(String[] args) { 
        // Porteiro p1 = new Porteiro( "111", "Joao", 8);
        // Porteiro p2 = new Porteiro( "222", "Maria", 9);
        Porteiro p1 = Porteiro.getInstancia();
        Porteiro p2 = Porteiro.getInstancia();

        System.out.println("P1 Nome: " + p1.nome);
        System.out.println("P2 Nome: " + p2.nome);

        if (p1 == p2) { 
            System.out.println("P1 é a mesma instância do P2");
        } else { 
            System.out.println("P1 é uma instância diferente de P2");
        }

        if (p1.equals(p2)) { 
            System.out.println("P1 tem os mesmos valores de P2");
        } else { 
            System.out.println("P1 possui valores diferentes de P2");
        }
    }
    
}
