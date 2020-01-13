/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import algoritmo.Algorithm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import modelo.Factura;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorFactura {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_FACTURAS_CABECERA";
    private static final String CODE_NAME = "fac_id";
    
    public ControladorFactura() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(Factura factura) {
        int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(fac_cab_id, fac_cab_estado, fac_cab_fecha, fac_cab_subtotal, fac_cab_iva, fac_cab_total,"
                + "ABA_PERSONAS_PER_ID1, ABA_PERSONAS_PER_ID)" +
                " VALUES(" +
                "fac_cab_id_seq.nextval" + "," +
                factura.getEstado() + ",'" +
                Algorithm.dateToString(factura.getFecha()) + "', " +
                factura.getSubtotal()+ ", " +
                factura.getIva()+ ", " +
                factura.getTotal()+ ", " +
                factura.getCliente().getId() + "," +
                factura.getEmpleado().getId() + ")";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            factura.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Factura read(int code){
        Factura factura = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + code + "";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                factura = new Factura();
                factura.setId(rs.getInt("fac_cab_id"));
                factura.setEstado(rs.getInt("fac_cab_estado"));
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rs.getDate("fac_cab_fecha"));
                factura.setFecha(cal);
                factura.setSubtotal(rs.getDouble("fac_cab_subtotal"));
                factura.setIva(rs.getDouble("fac_cab_iva"));
                factura.setTotal(rs.getDouble("fac_cab_total"));
                factura.setCliente(new ControladorPersona().readByCode(rs.getInt("ABA_PERSONAS_PER_ID1")));
                factura.setEmpleado(new ControladorEmpleado().readByCode(rs.getInt("ABA_PERSONAS_PER_ID")));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return factura;
    }
    
    public void anular(int codigo) {
        String sql = "UPDATE " + TABLE_NAME +
                " SET fac_cab_estado = 0" +
                " WHERE " + CODE_NAME + " = " + codigo;
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}