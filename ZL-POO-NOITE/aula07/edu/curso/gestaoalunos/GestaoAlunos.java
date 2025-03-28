package edu.curso.gestaoalunos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestaoAlunos {

    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int indice=0;
    private Aluno[] alunos = new Aluno[50];


    public void criar() { 
        System.out.println("Criando Aluno");
        System.out.println(	"Digite o id: ");
        Long id = input.nextLong();
        input.nextLine(); // Para limpar o buffer
        System.out.println(	"Digite o nome: ");
        String nome = input.nextLine();
        System.out.println(	"Digite o ra: ");
        String ra = input.nextLine();
        System.out.println(	"Digite o nascimento (DD/MM/YYYY): ");
        String strNascimento = input.nextLine();
        LocalDate nascimento = LocalDate.from(fmt.parse(strNascimento));

        Aluno a = new Aluno();
        a.setId( id );
        a.setRa( ra );
        a.setNascimento(nascimento);
        a.setNome(nome);

        alunos[indice] = a;
        indice++;
    }

    public Aluno localizarPorRa() { 
        System.out.println("Informe o numero do RA para procurar");
        String ra = input.nextLine();
        for (int i = 0; i < alunos.length; i++) { 
            Aluno a = alunos[i];
            if ( a != null) { 
                if (a.getRa().contains(ra))  { 
                    return a;
                }
            }
        }
        return null;
    }

    public void exibir() { 
        Aluno a = localizarPorRa();
        if (a != null) { 
            System.out.println(a);
        }
    }

    public void menu() { 
        while (true) { 
            System.out.println("Gestão de Alunos");
            System.out.println("Escolha uma opção: ");
            System.out.println("(C)adastrar");
            System.out.println("(E)xibir");
            System.out.println("(S)air");
            String texto = input.nextLine().toUpperCase();
            char opcao = ' ';
            if (texto.length() > 0) { 
                opcao = texto.charAt(0);
            }
            if (opcao == 'C') { 
                criar();
            } else if (opcao == 'E') { 
                exibir();
            } else if (opcao == 'S') { 
                System.out.println("Saindo do sistema...");
                input.close();
                break;
            } else { 
                System.out.println("Por favor digite uma opção valida");
            }
        }
    }


    public static void main(String[] args) {
        GestaoAlunos ga = new GestaoAlunos();
        ga.menu();
    }
    
}
