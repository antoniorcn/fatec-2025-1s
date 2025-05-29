package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import edu.curso.Contato;
import edu.curso.ContatoDAO;

public class ContatoDAOImplementation implements ContatoDAO {
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/pootarde?allowMultiQueries=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "alunofatec";
    private Connection con = null;

    public ContatoDAOImplementation() { 
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }

    private Contato gerarContatoDoResultSet( ResultSet rs ) { 
        Contato contato = new Contato();
        try { 
            contato.setId( rs.getLong("id") );
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            contato.setEmail(rs.getString("email"));
            contato.setNascimento(  // <== LocalDate
                rs.getDate("nascimento").toLocalDate()  // <== SQLDate
            );
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return contato;
    }

    public List<Contato> lerTodosContatos(){
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato";
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while( rs.next() ) { 
                lista.add( gerarContatoDoResultSet( rs ) );
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    public void guardar(Contato contato){
        String sql = "INSERT INTO contato (nome, telefone, email, nascimento) " + 
        "VALUES (?, ?, ?, ?)";
        System.out.println("guardar() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, contato.getNome() );
            stm.setString(2, contato.getTelefone() );
            stm.setString(3, contato.getEmail() );
            stm.setDate(4, Date.valueOf( contato.getNascimento() ) );
            stm.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    public boolean atualizar(Long id, Contato contato){
        String sql = "UPDATE contato SET nome = ?, telefone = ?, " + 
        " email = ?, nascimento = ? WHERE id = ?";
        
        System.out.println("atualizar() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, contato.getNome() );
            stm.setString(2, contato.getTelefone() );
            stm.setString(3, contato.getEmail() );
            stm.setDate(4, Date.valueOf( contato.getNascimento() ) );
            stm.setLong(5, contato.getId() );
            stm.executeUpdate();
            return true;
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return false;
    }

    public boolean excluir(Long id){
        String sql = "DELETE FROM contato WHERE id = ?";
        
        System.out.println("excluir() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return false;
    }

    public Contato procurarPorId(Long id){
        String sql = "SELECT * FROM contato WHERE id = ?";
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            if( rs.first() ) { 
                return gerarContatoDoResultSet( rs );
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return null;
    }

    public List<Contato> pesquisarPorNome(String nome){
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato WHERE nome LIKE ?";
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while( rs.next() ) { 
                lista.add( gerarContatoDoResultSet( rs ) );
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }
}
