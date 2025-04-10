package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class GestaoVendas implements PublicadorVendas {

    private List<AssinanteVendas> lista = new ArrayList<>();

    @Override
    public void adicionar(AssinanteVendas a) { 
        lista.add( a );
    }

    @Override
    public void remover(AssinanteVendas a) { 
        lista.remove(a);
    }

    public void avisarTodos( Produto p) { 
        for (AssinanteVendas ass : lista) { 
            ass.produtoVendido(p);
        }
    }
    
    public void fazerVenda(Produto p) { 
        System.out.println("\nProduto " + 
        p.getNome() + " vendido");
        avisarTodos(p);
    }
    
}
