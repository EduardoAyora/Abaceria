package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paùl Arias
 */

public class Producto {
    private int id;
    private String codigo_barra;
    private String nombre_producto;
    private String nacionalidad;
    private String unidad_medida;
    private int stock;

    public Producto(String codigo_barra, String nombre_producto, String nacionalidad, String unidad_medida, int stock) {
        this.codigo_barra = codigo_barra;
        this.nombre_producto = nombre_producto;
        this.nacionalidad = nacionalidad;
        this.unidad_medida = unidad_medida;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo_barra=" + codigo_barra + ", nombre_producto=" + nombre_producto + ", nacionalidad=" + nacionalidad + ", unidad_medida=" + unidad_medida + ", stock=" + stock + '}';
    }

    

}
