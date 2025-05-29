package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ContatoDAOImplementation 
                implements ContatoDAO {
    public static final String DB_URL =
        "jdbc:mysql://localhost:3307/poonoite";
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'pesquisarPorNome'");
    }

    @Override
    public List<Contato> pesquisarTodos() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contato";
        try { 
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery( sql );

            while (rs.next()) { 
                Contato c = new Contato();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                // LocalDate                java.sql.Date
                c.setNascimento( 
                    rs.getDate("nascimento")
                        .toLocalDate()
                );
                lista.add( c );
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void adicionar(Contato contato) {
        String sql = "INSERT INTO contato (nome, telefone, email) " + 
        "VALUES ('%s', '%s', '%s')";
        sql = String.format(sql, contato.getNome(), 
            contato.getTelefone(), contato.getEmail());
        System.out.println("adicionar() SQL: " + sql);
        try { 
            Statement stm = con.createStatement();
            stm.executeUpdate( sql );
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public boolean apagar(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'apagar'");
    }

    @Override
    public boolean atualizar(Long id, Contato contato) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Contato procurarPorId(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'procurarPorId'");
    }
    
}
