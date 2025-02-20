package edu.curso;
public class Principal {
    
    public static void main(String[] args) {
        Caneta c1 = new Caneta();
        Caneta c2 = new Caneta();

        c1.ano=1984;
        c1.fabricante="Crown";
        c1.modelo="HC2384";
        c1.cor="preta";

        c2.ano=1989;
        c2.fabricante="Mon blanc";
        c2.modelo = "MB404";
        c2.cor = "azul nav";

        c1.desmontar();
        c1.montar();
        c1.escrever();
        
        c2.escrever();
        c2.desmontar();
        c2.montar();


    }
}
