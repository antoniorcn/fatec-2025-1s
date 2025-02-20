package edu.curso;

public class RH {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.salario = 2500.0f;
        float r1 = f1.receberBeneficios(100.0f, 200.0f, 
            100.0f, 250.0f);

        Funcionario f2 = new Funcionario();
        f2.salario = 3500.0f;
        float r2 = f2.receberBeneficios(100.0f, 200.0f, 
            100.0f);

        System.out.println("Resultado: " + r1);
        System.out.println("Resultado: " + r2);



    }
}
