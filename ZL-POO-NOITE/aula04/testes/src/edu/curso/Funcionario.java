package edu.curso;

public class Funcionario {
    String matricula;
    String nome;
    float salario;

    private static Funcionario instancia;

    private Funcionario(
        String matricula, String nome, float salario
    ) { 
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public void trabalhar() { 
        System.out.println("Trabalhando");
    }

    public void baterPonto() { 
        System.out.println("Batendo o ponto");
    }

    public boolean equals(Funcionario outro) { 
        boolean mesmoNome = this.nome.equals(outro.nome);
        boolean mesmaMatricula = this.matricula.equals(outro.matricula);
        boolean mesmoSalario = this.salario == outro.salario;

        return mesmoNome && mesmaMatricula && mesmoSalario;
    }

    public String toString() { 
        StringBuffer sb = new StringBuffer();
        sb.append("Funcionario: [\n");
        sb.append("matricula: " + this.matricula + "\n");
        sb.append("nome: " + this.nome + "\n");
        sb.append("salario: " + this.salario + "]");
        return sb.toString();
    }

    public static Funcionario getInstancia() {
        if (instancia == null) { 
            instancia = new Funcionario("111", "Maria", 1800.0f );
        }
        return instancia;
    }
}
