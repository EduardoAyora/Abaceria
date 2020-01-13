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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import modelo.CompraProveedor;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorCompraProveedor {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_COMPRAS_PROVEEDOR";
    private static final String CODE_NAME = "com_prov_id";
    
    public ControladorCompraProveedor() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(CompraProveedor compraProveedor) {
        int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(com_prov_id, com_prov_fecha, com_prov_cantidad, com_prov_numero_factura,"
                + "ABA_PRODUCTOS_PRO_ID, ABA_PERSONAS_PER_ID)" +
                " VALUES(" +
                "fac_cab_id_seq.nextval" + ",'" +
                Algorithm.dateToString(compraProveedor.getFecha()) + "'," +
                compraProveedor.getCantidad() + "," +
                compraProveedor.getNumeroFacturaProveedor()+ ", " +
                compraProveedor.getProducto().getId() + ", " +
                compraProveedor.getPersona().getId() + ")";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            compraProveedor.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public CompraProveedor read(int code){
        CompraProveedor compraProveedor = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + code + "";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                compraProveedor = new CompraProveedor();
                compraProveedor.setId(rs.getInt("com_prov_id"));
                compraProveedor.setCantidad(rs.getInt("com_prov_cantidad"));
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rs.getDate("com_prov_fecha"));
                compraProveedor.setFecha(cal);
                compraProveedor.setNumeroFacturaProveedor(rs.getInt("com_prov_numero_factura"));
                compraProveedor.setProducto(new ControladorProductos().read(rs.getInt("ABA_PRODUCTOS_PRO_ID")));
                compraProveedor.setPersona(new ControladorPersona().readByCode(rs.getInt("ABA_PERSONAS_PER_ID")));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return compraProveedor;
    }
    
    public List<CompraProveedor> list(){
        List<CompraProveedor> facturaDetalles = new ArrayList<>();
        try{
            String sql = "SELECT * FROM " + TABLE_NAME;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next()){
                CompraProveedor compraProveedor = new CompraProveedor();
                compraProveedor.setId(rs.getInt("com_prov_id"));
                compraProveedor.setCantidad(rs.getInt("com_prov_cantidad"));
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rs.getDate("com_prov_fecha"));
                compraProveedor.setFecha(cal);
                compraProveedor.setNumeroFacturaProveedor(rs.getInt("com_prov_numero_factura"));
                compraProveedor.setProducto(new ControladorProductos().read(rs.getInt("ABA_PRODUCTOS_PRO_ID")));
                compraProveedor.setPersona(new ControladorPersona().readByCode(rs.getInt("ABA_PERSONAS_PER_ID")));
                facturaDetalles.add(compraProveedor);
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return facturaDetalles;
    }
    
}
