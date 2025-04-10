package edu.curso.observer;

import java.util.ArrayList;
import java.util.List;

public class GestaoVendas implements PublicadorVendas {

    private List<InteressadoVendas> lista = new ArrayList<>();

    @Override
    public void adicionar(InteressadoVendas i) {
        lista.add( i );
    }

    @Override
    public void remover(InteressadoVendas i) {
        lista.remove( i );
    }

    @Override
    public void avisarInteressados(Produto p) {
        for (InteressadoVendas i : lista) { 
            i.produtoVendido( p );
        }
    }

    public void fazerVenda(Produto p) { 
        System.out.printf("Ebah conseguimos vender %s por R$ %7.2f %n", 
            p.getNome(), p.getPreco());
        avisarInteressados( p );
    }
    
}
