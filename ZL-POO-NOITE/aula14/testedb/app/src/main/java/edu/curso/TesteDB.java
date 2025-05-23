package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
    public static final String DB_URL = 
        "jdbc:mysql://localhost:3307/poonoite";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "alunofatec";
    
    public static void main(String[] args) {
        System.out.println("Teste de banco de dados");
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");
            Connection con = 
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conexão estabelecida com o database");
            Statement stm = con.createStatement();
            // stm.executeUpdate(
            //     "INSERT INTO contato (nome, telefone, email) "+
            //     "VALUES ('Maria Silva', '2222', 'maria@teste.com')"
            // );

            stm.executeUpdate("DELETE FROM contato WHERE " + 
                                "nome like 'Joao%'");


            ResultSet rs = stm.executeQuery(
                "SELECT * FROM contato");
            System.out.println("Comando executado com sucesso");

            while( rs.next()) { 
                System.out.println("Nome: " + 
                    rs.getString("nome"));
                System.out.println("Telefone: " + 
                    rs.getString("telefone"));
                System.out.println("Email: " + 
                    rs.getString("email"));
                System.out.println("---------------------");
            }

            con.close();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
