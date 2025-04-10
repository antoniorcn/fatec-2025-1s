package edu.curso.observer;

import java.util.ArrayList;
import java.util.List;

public class Revista implements Publicadora {

    private List<Assinante> lista = new ArrayList<>();
    private String nome;

    public Revista(String nome) { 
        this.nome = nome;
    }

    @Override
    public void adicionar(Assinante a) {
        lista.add( a );
    }

    @Override
    public void remover(Assinante a) {
        lista.remove( a );
    }

    @Override
    public void avisarAssinante(String noticia) {
        System.out.println("Revista " + this.nome + " publicando novo exemplar");
        for (Assinante a : lista) { 
            a.lerNoticia(noticia);
        }
    }

    public String getNome() { 
        return this.nome;
    }
    
}
