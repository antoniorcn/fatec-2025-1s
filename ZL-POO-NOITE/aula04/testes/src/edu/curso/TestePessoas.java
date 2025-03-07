package edu.curso;

public class TestePessoas {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", "111");
        Pessoa p2 = new Pessoa("Maria", "222");
        Pessoa p3 = new Pessoa("João", "111");

        System.out.printf("P1 ==> (%s)%n", p1);
        System.out.printf("P2 ==> (%s)%n", p2);
        System.out.printf("P3 ==> (%s)%n", p3);

        if (p1.equals(p2)) { 
            System.out.println("P1 é igual a P2");
        } else { 
            System.out.println("P1 é diferente de P2");
        }

        if (p1.equals(p3)) { 
            System.out.println("P1 é igual a P3");
        } else { 
            System.out.println("P1 é diferente de P3");
        }
    }
}
