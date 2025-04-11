package edu.curso.noticiario;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicadora {
    private String nome = "";
    private List<Assinante> lista = new ArrayList<>();

    public Jornal(String nome) { 
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
    public void darNoticia(String noticia) {
        for (Assinante a : lista) { 
            a.receberNoticia(noticia);
        }
    }

    public String getNome() {
        return nome;
    }
}
