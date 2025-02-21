package edu.curso;

public class RH {

    public static void main(String[] args) {
        Funcionario joao = new Funcionario();
        Funcionario maria = new Funcionario();

        joao.salario = 6000;
        float pg1 = joao.receberPagamento(
                200, 600 );
        System.out.println("Joao recebeu: " + pg1);

        maria.salario = 8000;
        float pg2 = maria.receberPagamento(
            0, 800, 900, 1000);
        System.out.println("Maria recebeu: " + pg2);
    }
    
}
