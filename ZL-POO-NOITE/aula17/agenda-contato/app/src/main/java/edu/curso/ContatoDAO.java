package edu.curso;
import java.util.List;
public interface ContatoDAO {
    List<Contato> pesquisarPorNome( String nome );
    List<Contato> pesquisarTodos();
    void adicionar( Contato contato );
    boolean apagar( Long id );
    boolean atualizar( Long id, Contato contato );
    Contato procurarPorId( Long id );  
}
