package edu.curso;

public class LojaCelulares {
    
    public static void main(String[] args) {
        Celular c1 = new Celular("Samsung", "A05", 
            64, 6, 36);
        Celular c2 = new Celular("Motorola", "G10", 
            128, 7, 48);

        Tela telaAmoled = new Tela(7, "Amoled");

        c1.tela = telaAmoled;

        // Bateria b1 = new Bateria(8000, 64, "ShinZhen");
        // c1.bateria = b1;

        c1.ligar();
        c2.ligar();
    }
}
