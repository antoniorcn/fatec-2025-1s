package edu.curso.noticiario;

public interface Publicadora {

    void adicionar(Assinante a);
    void remover(Assinante a);
    void darNoticia(String noticia);
    
}
