package src;
public class TesteVarArgs { 
    public static double somar ( double m, 
                                double ... numeros ) {
        System.out.println("Quantidade de numeros informados:" + 
            numeros.length);
        double soma = 0.0;
        for (double numero : numeros) { 
            soma += numero;
        }
        return soma * m;
    }

    public static void main(String[] args) {
        double resultado = somar( 10.0, 1.0, 2.0, 3.0 );
        System.out.println("Resultado: " + resultado);
    }
}