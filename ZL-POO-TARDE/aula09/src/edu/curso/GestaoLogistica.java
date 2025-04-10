package edu.curso;

public class GestaoLogistica implements AssinanteVendas {

    @Override
    public void produtoVendido(Produto p) { 
        System.out.println(
            "Trabalhando para entregar o produto " +
         p.getNome());
    }
    
}
