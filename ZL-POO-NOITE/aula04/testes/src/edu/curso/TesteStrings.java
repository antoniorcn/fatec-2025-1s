package edu.curso;
public class TesteStrings { 

    public static void main(String[] args) {
        String a = "João";
        String b = "João";
        String c = a + "";
        System.out.printf("A: (%s)%n", a);
        System.out.printf("B: (%s)%n", b);
        System.out.printf("C: (%s)%n", c);
        if ( a.equals(b) ) { 
            System.out.println("A é igual a B");
        } else { 
            System.out.println("A é diferente de B");
        }

        if ( a.equals(c) ) { 
            System.out.println("A é igual a C");
        } else { 
            System.out.println("A é diferente de C");
        }

        if ( b.equals( c ) ) { 
            System.out.println("B é igual a C");
        } else { 
            System.out.println("B é diferente de C");
        }

    }
}