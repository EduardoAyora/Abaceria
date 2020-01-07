/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Persona;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorPersona {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_PERSONAS";
    private static final String CODE_NAME = "per_id";

    public ControladorPersona() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(Persona persona) {
        int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(per_id, per_cedula, per_nombre, per_apellido, per_direccion, per_telefono, per_celular,"
                + "per_activo)" +
                " VALUES(" +
                code + ",'" +
                persona.getCedula() + "', '" +
                persona.getNombre() + "', '" +
                persona.getApellido() + "', '" +
                persona.getDireccion() + "', '" +
                persona.getTelefono() + "', '" +
                persona.getCelular() + "'," +
                persona.getActivo() + ")";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            persona.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Persona read(String cedula){
        Persona persona = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + "per_cedula" + " = '" + cedula + "'";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                persona = new Persona();
                persona.setId(rs.getInt("per_id"));
                persona.setCedula(cedula);
                persona.setNombre(rs.getString("per_nombre"));
                persona.setApellido(rs.getString("per_apellido"));
                persona.setDireccion(rs.getString("per_direccion"));
                persona.setTelefono(rs.getString("per_telefono"));
                persona.setCelular(rs.getString("per_celular"));
                persona.setActivo(rs.getInt("per_activo"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return persona;
    }
    
    public void update(Persona persona) {
        String sql = "UPDATE " + TABLE_NAME +
                " SET per_cedula = '" + persona.getCedula() + "'," +
                "per_nombre = '" + persona.getNombre() + "'," + 
                "per_apellido = '" + persona.getApellido() + "'," + 
                "per_direccion = '" + persona.getDireccion() + "'," + 
                "per_telefono = '" + persona.getTelefono() + "'," + 
                "per_celular = '" + persona.getCelular() + "'," + 
                "per_activo = " + persona.getActivo() + 
                " WHERE " + CODE_NAME + " = " + persona.getId();
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
        
    }
    
}
