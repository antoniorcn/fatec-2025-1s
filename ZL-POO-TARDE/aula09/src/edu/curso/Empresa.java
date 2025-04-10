package edu.curso;

public class Empresa {

    public static void main(String[] args) {
        GestaoVendas gv = new GestaoVendas();

        GestaoLogistica gl = new GestaoLogistica();

        Marketing mkt = new Marketing();

        gv.adicionar( gl );
        gv.adicionar( mkt );

        Produto p1 = new Produto("Camiseta", 250.0);
        Produto p2 = new Produto("Calça Jeans", 300.0);

        gv.fazerVenda(p1);
    }
    
}
