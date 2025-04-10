package edu.curso.observer;

public class Empresa {
    public static void main(String[] args) {
        GestaoVendas gv = new GestaoVendas();

        Marketing mkt = new Marketing();
        GestaoLogistica gl = new GestaoLogistica();

        Produto p1 = new Produto( "Camiseta", 60.00f);
        Produto p2 = new Produto( "Boné", 20.00f);

        gv.adicionar( mkt );
        gv.adicionar( gl );

        gv.fazerVenda( p1 );
        gv.fazerVenda( p2 );
    }
    
}
