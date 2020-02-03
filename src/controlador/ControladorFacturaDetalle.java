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
import modelo.FacturaDetalle;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorFacturaDetalle {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_FACTURAS_DETALLE";
    private static final String CODE_NAME = "fac_det_id";
    
    public ControladorFacturaDetalle() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(FacturaDetalle facturaDetalle) {
        String sql = "INSERT INTO " + TABLE_NAME + 
                "(fac_det_id, fac_det_cantidad, fac_det_subtotal, fac_det_iva, fac_det_total,"
                + "ABA_PRODUCTOS_PRO_ID, FAC_CAB_ID)" +
                " VALUES(" +
                "fac_det_id_seq.nextval" + "," +
                facturaDetalle.getCantidad() + "," +
                facturaDetalle.getSubtotal()+ "," +
                facturaDetalle.getIva()+ ", " +
                facturaDetalle.getTotal()+ ", " +
                facturaDetalle.getProducto().getId() + "," +
                facturaDetalle.getFactura().getId() + ")";
        dataBaseConnection.connect();
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
            facturaDetalle.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public FacturaDetalle read(int code){
        FacturaDetalle factura = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + code + "";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                factura = new FacturaDetalle();
                factura.setId(rs.getInt("fac_det_id"));
                factura.setCantidad(rs.getInt("fac_det_cantidad"));
                factura.setSubtotal(rs.getDouble("fac_det_subtotal"));
                factura.setIva(rs.getDouble("fac_det_iva"));
                factura.setTotal(rs.getDouble("fac_det_total"));
                factura.setProducto(new ControladorProductos().read(rs.getInt("ABA_PRODUCTOS_PRO_ID")));
                factura.setFactura(new ControladorFactura().read(rs.getInt("FAC_CAB_ID")));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return factura;
    }
    
    public List<FacturaDetalle> listByFactura(String numeroFactura){
        List<FacturaDetalle> facturaDetalles = new ArrayList<>();
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE FAC_CAB_ID = " + numeroFactura;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while(rs.next()){
                FacturaDetalle factura = new FacturaDetalle();
                factura.setId(rs.getInt("fac_det_id"));
                factura.setCantidad(rs.getInt("fac_det_cantidad"));
                factura.setSubtotal(rs.getDouble("fac_det_subtotal"));
                factura.setIva(rs.getDouble("fac_det_iva"));
                factura.setTotal(rs.getDouble("fac_det_total"));
                factura.setProducto(new ControladorProductos().read(rs.getInt("ABA_PRODUCTOS_PRO_ID")));
                factura.setFactura(new ControladorFactura().read(rs.getInt("FAC_CAB_ID")));
                facturaDetalles.add(factura);
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
