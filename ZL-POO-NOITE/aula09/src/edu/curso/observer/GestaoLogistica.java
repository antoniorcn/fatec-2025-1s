package edu.curso.observer;

public class GestaoLogistica implements InteressadoVendas{

    @Override
    public void produtoVendido(Produto p) {
        System.out.println("Preparando a entrega do produto " + 
        p.getNome() + " para o cliente");
    }
    
}
