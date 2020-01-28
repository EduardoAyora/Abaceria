/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.UnidadMedida;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorUnidadMedida {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_UNIDADES_MEDIDA";
    private static final String CODE_NAME = "uni_med_id";

    public ControladorUnidadMedida() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(UnidadMedida unidadMedida) {
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(uni_med_id, uni_med_descripcion)" + 
                " VALUES(" +
                "uni_med_id_seq.nextval" + ",'" +
                unidadMedida.getDescripcion() + "')";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
            unidadMedida.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public UnidadMedida read(int codigo){
        UnidadMedida unidadMedida = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + codigo;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                unidadMedida = new UnidadMedida();
                unidadMedida.setId(rs.getInt(CODE_NAME));
                unidadMedida.setDescripcion(rs.getString("uni_med_descripcion"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return unidadMedida;
    }
    
    public UnidadMedida read(String nombre){
        UnidadMedida unidadMedida = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE uni_med_descripcion = '" + nombre + "'";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                unidadMedida = new UnidadMedida();
                unidadMedida.setId(rs.getInt(CODE_NAME));
                unidadMedida.setDescripcion(rs.getString("uni_med_descripcion"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return unidadMedida;
    }
    
    public void update(UnidadMedida unidadMedida) {
        String sql = "UPDATE " + TABLE_NAME +
                " SET uni_med_descripcion = '" + unidadMedida.getDescripcion()+ "'" +
                " WHERE " + CODE_NAME + " = " + unidadMedida.getId();
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
    
    public void deleteByName(String nombre){
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + "uni_med_descripcion" + " ='" + nombre+"'";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.executeUpdate(sql);
            dataBaseConnection.disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<UnidadMedida> list(){
        List<UnidadMedida> categorias = new ArrayList<>();
        try{
            String sql = "SELECT * FROM " + TABLE_NAME;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next()){
                UnidadMedida unidadMedida = new UnidadMedida();
                unidadMedida.setId(rs.getInt(CODE_NAME));
                unidadMedida.setDescripcion(rs.getString("uni_med_descripcion"));
                categorias.add(unidadMedida);
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categorias;
    }
    
}
