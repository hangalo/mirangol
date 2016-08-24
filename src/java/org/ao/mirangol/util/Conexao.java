/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author informatica
 */
public class Conexao {

    public static Connection getConnection() {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mirangol";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro na conexao com a base de dados: " + ex.getMessage());
            return null;
        }
        return con;
    }

    public static void closeConnection(Connection conn){
        close(conn, null, null);    
    }
    
     public static void closeConnection(Connection conn, PreparedStatement ps){
        close(conn, ps, null);    
    }
     
      public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        close(conn, ps, rs);    
    }
    
    
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao desalocar recurso: "+ex.getMessage());
        }

    }

}
