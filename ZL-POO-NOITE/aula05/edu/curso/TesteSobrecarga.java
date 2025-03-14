package edu.curso;

public class TesteSobrecarga {

    public int somar(int n1, int n2) {
        System.out.println("Função 1");
        return n1 + n2;
    }

    public int somar(int n1, int n2, int n3) {
        System.out.println("Função 2");
        return n1 + n2 + n3;
    }

    public int somar(int ... numeros) {
        System.out.println("Função 3");
        int soma = 0;
        for (int n : numeros) { 
            soma += n;
        }
        return soma;
    }    

    public static void main(String[] args) {
        TesteSobrecarga ts = new TesteSobrecarga();
        ts.somar(10, 20);
        ts.somar(10, 20, 30);
        ts.somar(10, 20, 30, 40);
    }
    
}
