/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;

/**
 *
 * @author Eduardo Ayora
 */
public class ControladorProductos {
    
    private DataBaseConnection dataBaseConnection;
    private static final String TABLE_NAME = "ABA_PRODUCTOS";
    private static final String CODE_NAME = "pro_id";

    public ControladorProductos() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public void create(Producto producto) {
        int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
        String sql = "INSERT INTO " + TABLE_NAME + 
                "("+ CODE_NAME +", pro_descripcion, pro_stock, pro_tiene_iva, pro_nacional,"
                + "pro_unidad_medida, pro_precio, pro_codigo_barras)" + 
                " VALUES(" + CODE_NAME + "_seq.nextval" + ",'" +
                producto.getDescripcion() + "'," +
                producto.getStock() + "," +
                producto.getTieneIva() + "," +
                producto.getNacional() + ",'" +
                producto.getUnidadMedida() + "'," +
                producto.getPrecio() + ",'" +
                producto.getCodigoBarra() + "')";
        dataBaseConnection.connect();
        System.out.println(sql);
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            producto.setId(code);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Producto read(int codigo){
        Producto producto = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CODE_NAME + " = " + codigo;
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(CODE_NAME));
                producto.setDescripcion(rs.getString("pro_descripcion"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setTieneIva(rs.getInt("pro_tiene_iva"));
                producto.setNacional(rs.getInt("pro_nacional"));
                producto.setUnidadMedida(rs.getString("pro_unidad_medida"));
                producto.setPrecio(rs.getDouble("pro_precio"));
                producto.setCodigoBarra(rs.getString("pro_codigo_barras"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return producto;
    }
    
    public void update(Producto producto) {
        String sql = "UPDATE " + TABLE_NAME +
                " SET pro_descripcion = '" + producto.getDescripcion()+ "'," +
                "pro_stock = " + producto.getStock() + "," +
                "pro_tiene_iva = " + producto.getStock() + "," +
                "pro_nacional = " + producto.getStock() + "," +
                "pro_unidad_medida = " + producto.getStock() + "," +
                "pro_precio = " + producto.getStock() + "," +
                "pro_codigo_barras = " + producto.getStock() + "," +
                " WHERE " + CODE_NAME + " = " + producto.getId();
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
