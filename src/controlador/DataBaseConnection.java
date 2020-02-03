/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Eduardo Ayora
 */
public class DataBaseConnection {
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    
    public void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abaceria", "abaceria123");
            if (connection.isValid(4000)) {
                System.out.println("Conectado!");
            } else {
                System.out.println("No se pudo conectar!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect(){
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public int getCode(String nombreColumna, String nombreTabla){
        int code = 0;
        //SELECT MAX(salary) "Maximum" FROM employees;
        String sql = "SELECT MAX(" + nombreColumna + ") FROM " + nombreTabla;
        connect();
        try {
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if (rs.next()) {
                code = rs.getInt(1);
            }
            rs.close();
            sta.close();
            disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return code;
    }
    
}
