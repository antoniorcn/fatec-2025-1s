package src.edu.curso;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
public class Pessoa {
    String nome;
    long idade;
    LocalDate nascimento;

    public Pessoa(String nome, LocalDate nascimento) { 
        this.nome = nome;
        this.nascimento = nascimento;
        this.idade = calcularIdade();
        System.out.println("Pessoa criada");
    }

    private long calcularIdade() { 
        // return ChronoUnit.YEARS.between( 
        //     this.nascimento,
        //     LocalDate.now() 
        // );
        return Period.between(this.nascimento, LocalDate.now()).getYears();
    }
}
