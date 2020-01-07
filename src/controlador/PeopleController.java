/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Persona;
import modelo.Proveedor;

/**
 *
 * @author Eduardo Ayora
 */
public class PeopleController {
    
    private DataBaseConnection dataBaseConnection;

    public PeopleController() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public Proveedor read(String cedula){
        Proveedor persona = null;
        try{
            String sql = "select * from ABA_PERSONAS "
                    + "where per_cedula = '" + cedula + "'";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                persona = new Proveedor();
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
    
}
