package edu.curso.observer;

public class Marketing implements InteressadoVendas {
    @Override
    public void produtoVendido(Produto p) { 
        System.out.println("Fazendo enquete com o cliente" + 
        " para saber identificar a satisfação em ter comprado " + 
        p.getNome());
    }
}
