package edu.curso;

public class TesteSobrecarga { 

    public int somaNumeros( int n1, int n2 ) { 
        System.out.println("Função 1");
        return n1 + n2;
    }

    public int somaNumeros(int n1, int n2, int n3) { 
        System.out.println("Função 2");
        return n1 + n2 + n3;
    }

    public int somaNumeros(int ... numeros) { 
        System.out.println("Função 3");
        int soma = 0;
        for (int numero : numeros) { 
             soma += numero;
        }
        return soma;
    }

    public static void main(String[] args) {
        TesteSobrecarga t1 = new TesteSobrecarga();

        t1.somaNumeros(10, 10, 20, 30);
    }

}