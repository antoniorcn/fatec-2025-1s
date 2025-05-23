package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/pootarde";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "alunofatec";
    public static void main (String [] args ) {
        try {
            System.out.println("Acessando banco de dados");
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado");
            Connection con = 
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stm = con.createStatement();
            stm.executeUpdate( 
                "INSERT INTO contato (nome, telefone, email) " +
                "VALUES ('Jose Santos', '333333', 'jose@teste.com')"
            );
            System.out.println("Comando executado com sucesso");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) { 
            e.printStackTrace();
        }
    }
}
