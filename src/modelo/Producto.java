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
    private String codigoBarra;
    private String descripcion;
    private int nacional;
    private String unidadMedida;
    private int stock;
    private double precio;
    private int tieneIva;
    private CategoriaProducto cateriaProducto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNacional() {
        return nacional;
    }

    public void setNacional(int nacional) {
        this.nacional = nacional;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTieneIva() {
        return tieneIva;
    }

    public void setTieneIva(int tieneIva) {
        this.tieneIva = tieneIva;
    }

    public CategoriaProducto getCateriaProducto() {
        return cateriaProducto;
    }

    public void setCateriaProducto(CategoriaProducto cateriaProducto) {
        this.cateriaProducto = cateriaProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigoBarra=" + codigoBarra + ", descripcion=" + descripcion + ", nacional=" + nacional + ", unidadMedida=" + unidadMedida + ", stock=" + stock + ", precio=" + precio + ", tieneIva=" + tieneIva + ", cateriaProducto=" + cateriaProducto + '}';
    }

}
