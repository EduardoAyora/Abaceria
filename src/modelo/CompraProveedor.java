/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author Eduardo Ayora
 */
public class CompraProveedor {
    
    private int id;
    private GregorianCalendar fecha;
    private int cantidad;
    private int numeroFacturaProveedor;
    private Persona persona;
    private Producto producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroFacturaProveedor() {
        return numeroFacturaProveedor;
    }

    public void setNumeroFacturaProveedor(int numeroFacturaProveedor) {
        this.numeroFacturaProveedor = numeroFacturaProveedor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "CompraProveedor{" + "id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", numeroFacturaProveedor=" + numeroFacturaProveedor + ", persona=" + persona + ", producto=" + producto + '}';
    }
    
    
}
