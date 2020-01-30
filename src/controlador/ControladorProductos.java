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
        String sql = "INSERT INTO " + TABLE_NAME + 
                "("+ CODE_NAME +", ABA_CATEGORIAS_CAT_ID, pro_descripcion, pro_stock, pro_tiene_iva, pro_nacional,"
                + "uni_med_id, pro_precio, pro_codigo_barras, pro_activo)" + 
                " VALUES(" + CODE_NAME + "_seq.nextval" + "," +
                producto.getCateriaProducto().getId() + ",'" +
                producto.getDescripcion() + "'," +
                producto.getStock() + "," +
                producto.getTieneIva() + "," +
                producto.getNacional() + "," +
                producto.getUnidadMedida().getId() + "," +
                producto.getPrecio() + ",'" +
                producto.getCodigoBarra() + "'," +
                producto.getActivo() + ")";
        dataBaseConnection.connect();
        System.out.println(sql);
        try {
            Statement sta = dataBaseConnection.getConnection().createStatement();
            sta.execute(sql);
            dataBaseConnection.disconnect();
            int code = dataBaseConnection.getCode(CODE_NAME, TABLE_NAME);
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
                producto.setCateriaProducto(new ControladorCategoria().read(rs.getInt("ABA_CATEGORIAS_CAT_ID")));
                producto.setDescripcion(rs.getString("pro_descripcion"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setTieneIva(rs.getInt("pro_tiene_iva"));
                producto.setNacional(rs.getInt("pro_nacional"));
                producto.setUnidadMedida(new ControladorUnidadMedida().read(rs.getInt("uni_med_id")));
                producto.setPrecio(rs.getDouble("pro_precio"));
                producto.setCodigoBarra(rs.getString("pro_codigo_barras"));
                producto.setActivo(rs.getInt("pro_activo"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return producto;
    }
    
    public Producto readByBarCode(String codigo){
        Producto producto = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE pro_codigo_barras = '" + codigo + "'";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(CODE_NAME));
                producto.setCateriaProducto(new ControladorCategoria().read(rs.getInt("ABA_CATEGORIAS_CAT_ID")));
                producto.setDescripcion(rs.getString("pro_descripcion"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setTieneIva(rs.getInt("pro_tiene_iva"));
                producto.setNacional(rs.getInt("pro_nacional"));
                producto.setUnidadMedida(new ControladorUnidadMedida().read(rs.getInt("uni_med_id")));
                producto.setPrecio(rs.getDouble("pro_precio"));
                producto.setCodigoBarra(rs.getString("pro_codigo_barras"));
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(producto);
        return producto;
    }
    
    public Producto readByName(String nombre){
        Producto producto = null;
        try{
            String sql = "SELECT * FROM " + TABLE_NAME + " WHERE LOWER(pro_descripcion) LIKE LOWER('" + nombre + "%')";
            System.out.println(sql);
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(CODE_NAME));
                producto.setCateriaProducto(new ControladorCategoria().read(rs.getInt("ABA_CATEGORIAS_CAT_ID")));
                producto.setDescripcion(rs.getString("pro_descripcion"));
                producto.setStock(rs.getInt("pro_stock"));
                producto.setTieneIva(rs.getInt("pro_tiene_iva"));
                producto.setNacional(rs.getInt("pro_nacional"));
                producto.setUnidadMedida(new ControladorUnidadMedida().read(rs.getInt("uni_med_id")));
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
                "ABA_CATEGORIAS_CAT_ID = " + producto.getCateriaProducto().getId() + "," +
                "pro_stock = " + producto.getStock() + "," +
                "pro_tiene_iva = " + producto.getTieneIva() + "," +
                "pro_nacional = " + producto.getNacional() + "," +
                "uni_med_id = " + producto.getUnidadMedida().getId() + "," +
                "pro_precio = " + producto.getPrecio() + "," +
                "pro_codigo_barras = '" + producto.getCodigoBarra() + "'" +
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
