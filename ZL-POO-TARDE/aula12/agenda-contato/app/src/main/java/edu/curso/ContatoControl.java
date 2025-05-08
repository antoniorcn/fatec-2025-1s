package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class ContatoControl {
    private List<Contato> lista = new ArrayList<>();

    public void cadastrar( Contato contato ) { 
        lista.add(contato);
    }


    public Contato pesquisarContato( String nome ) { 
        for (Contato c : lista) { 
            if ( c.getNome().contains( nome )) { 
                return c;
            }
        }
        return null;
    }
}
