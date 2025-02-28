package src.edu.curso;

public class GaragemTeste { 

    public static void main(String[] args) {

        Carro q8 = new Carro("Audi", 2025, "Q8");
        Pneu pneuMeiaVida = new Pneu(13, 120);

        Pneu pneuSubtraido = q8.pneu;
        System.out.println("Pneu que esta no carro: " + q8.pneu.aro);

        q8.pneu = pneuMeiaVida;
        System.out.println("Pneu que esta no carro: " + q8.pneu.aro);

        q8 = null;
        System.out.println("Carro sumiu, mas o Pneu ficou: " + pneuSubtraido.aro);

        // Motor motorSubtraido = q8.motor;

        
    }
}