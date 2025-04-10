package edu.curso;

public class Marketing implements AssinanteVendas {

    @Override
    public void produtoVendido(Produto p) {
        System.out.println("Parabenizar o cliente e contabilizar " + 
        "que houve mais uma venda de " + p.getNome());
    }

    
}
