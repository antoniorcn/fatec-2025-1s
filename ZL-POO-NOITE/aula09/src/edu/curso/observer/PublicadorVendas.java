package edu.curso.observer;

public interface PublicadorVendas {

    void adicionar( InteressadoVendas i );
    void remover( InteressadoVendas i );
    void avisarInteressados( Produto p );
    
}
