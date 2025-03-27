package edu.curso.gestaoalunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoTela {

    private List<Aluno> alunos = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private int contadorRA = 0;


    public void cadastrarAluno() { 
        System.out.println("Digite o nome do aluno: ");
        String nome = input.nextLine();
        System.out.println("Digite a idade do aluno: ");
        int idade = input.nextInt();
        input.nextLine(); // Limpa o buffer do scanner após ler um inteiro

        contadorRA += 1;
        String ra = String.format("%06d", contadorRA); // Formata o RA com 6 dígitos

        Aluno a = new Aluno(nome, ra, idade);
        alunos.add(a);
    }

    public void listarAlunos() { 
        System.out.println("Lista de Alunos: ");
        for (Aluno aluno : alunos) { 
            System.out.println("------------------------------------");
            System.out.println("RA: " + aluno.getRa() );
            System.out.println("Nome: " + aluno.getNome() + ", Idade: " + aluno.getIdade());
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("(C)adastrar Aluno");
            System.out.println("(L)istar Alunos");
            System.out.println("(S)air");
            System.out.print("Escolha uma opção: ");
            char opcao = input.nextLine().toUpperCase().charAt(0);
            if (opcao == 'C') { 
                cadastrarAluno();
            } else if (opcao == 'L') { 
                listarAlunos();
            } else if (opcao == 'S') { 
                System.out.println("Saindo...");
                break;
            } else { 
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    public static void main(String[] args) {
        AlunoTela alunoTela = new AlunoTela();
        alunoTela.menu();
    }



    public List<Aluno> getAlunos() {
        return alunos;
    }
   
}
