/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorCategoria {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_CATEGORIAS";
    private static final String CODE_NAME = "cat_id";

    public ControladorCategoria() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(Categoria categoria) {
        int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(cat_id, cat_nombre)" + 
                " VALUES(" +
                "cat_id_seq.nextval" + ",'" +
                categoria.getNombre()+ "')";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            categoria.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Categoria read(int codigo){
        Categoria categoria = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + codigo;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                categoria = new Categoria();
                categoria.setId(rs.getInt(CODE_NAME));
                categoria.setNombre(rs.getString("cat_nombre"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categoria;
    }
    
    public void update(Categoria categoria) {
        String sql = "UPDATE " + TABLE_NAME +
                " SET cat_nombre = '" + categoria.getNombre()+ "'" +
                " WHERE " + CODE_NAME + " = " + categoria.getId();
        dataBaseConnection.connect();

        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(int code){
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + code;
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.executeUpdate(sql);
            dataBaseConnection.disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
