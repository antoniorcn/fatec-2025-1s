package src;
import java.util.Scanner;

public class Ex1 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        double numero1 = input.nextDouble();
        System.out.println("Digite outro numero: ");
        double numero2 = input.nextDouble();
        double soma = numero1 + numero2;
        System.out.println("Resultado: " + soma);        
        input.close();
    }
}
