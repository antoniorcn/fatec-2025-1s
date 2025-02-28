package src.edu.curso;

import java.time.LocalDate;

public class TestePessoa {
    
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João Silva", 
            LocalDate.of(2006, 9, 13));
        
        // System.out.println(p1.nome + " possui " + p1.idade  + " anos");
        System.out.printf("%s possui %d anos %n", p1.nome, p1.idade);
    }
}
