package edu.curso;

public class TesteFuncionario {
    public static void main(String[] args) {
        // Funcionario f1 = new Funcionario("111", "João", 1500.0f);
        // Funcionario f2 = new Funcionario("222", "Maria", 1800.0f);
        // Funcionario f3 = new Funcionario("111", "João", 1500.0f);

        Funcionario f1 = Funcionario.getInstancia();
        Funcionario f2 = Funcionario.getInstancia();
        Funcionario f3 = Funcionario.getInstancia();

        System.out.println("F1: " + f1);
        System.out.println("F2: " + f2);
        System.out.println("F3: " + f3);

        if (f1==f2) { 
            System.out.println("F1 é igual a F2");
        } else { 
            System.out.println("F1 é diferente de F2");
        }
        if (f1==f3) { 
            System.out.println("F1 é igual a F3");
        } else { 
            System.out.println("F1 é diferente de F3");
        }
    }
}
