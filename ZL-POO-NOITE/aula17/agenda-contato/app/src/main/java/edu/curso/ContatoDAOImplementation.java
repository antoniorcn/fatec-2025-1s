package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOImplementation 
                implements ContatoDAO {
    public static final String DB_URL =
        "jdbc:mysql://localhost:3307/poonoite?allowMultiQueries=true";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "alunofatec";

    private Connection con;

    public ContatoDAOImplementation() { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public List<Contato> pesquisarPorNome(String nome) {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato WHERE nome LIKE ?";
        try { 
            PreparedStatement stm = con.prepareStatement( sql );
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) { 
                lista.add( generateContatoFromResultSet(rs) );
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Contato> pesquisarTodos() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato";
        try { 
            PreparedStatement stm = con.prepareStatement( sql );
            ResultSet rs = stm.executeQuery();

            while (rs.next()) { 
                lista.add( generateContatoFromResultSet(rs) );
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void adicionar(Contato contato) {
        String sql = "INSERT INTO contato (nome, telefone, email, nascimento) " + 
        "VALUES (?, ?, ?, ?)";
        System.out.println("adicionar() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement( sql );
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getTelefone());
            stm.setString(3, contato.getEmail());
            stm.setDate(4, 
                java.sql.Date.valueOf( contato.getNascimento() )
            );
            stm.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public boolean apagar(Long id) {
        String sql = "DELETE FROM contato WHERE id = ?";

        System.out.println("apagar() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement( sql );
            stm.setLong(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean atualizar(Long id, Contato contato) {
        String sql = "UPDATE contato SET nome=?, telefone=?, " + 
        "email=?, nascimento=? WHERE id=?";
        System.out.println("atualizar() SQL: " + sql);
        try { 
            PreparedStatement stm = con.prepareStatement( sql );
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getTelefone());
            stm.setString(3, contato.getEmail());
            stm.setDate(4, 
                java.sql.Date.valueOf( contato.getNascimento() )
            );
            stm.setLong(5, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) { 
            e.printStackTrace();
        }    
        return false;
    }

    @Override
    public Contato procurarPorId(Long id) {
        String sql = "SELECT * FROM contato WHERE id = ?";
        try { 
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) { 
                return generateContatoFromResultSet(rs);
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return null;        
    }

    private Contato generateContatoFromResultSet(ResultSet rs) throws SQLException {
        Contato c = new Contato();
        c.setId(rs.getLong("id"));
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEmail(rs.getString("email"));
        c.setNascimento( 
            rs.getDate("nascimento")
                .toLocalDate()
        );
        return c;
    }
    
}
