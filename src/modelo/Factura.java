/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import algoritmo.Algorithm;
import excepcion.ExcepcionBinaria;
import java.util.GregorianCalendar;

/**
 *
 * @author Eduardo Ayora
 */
public class Factura {
    
    private int id;
    private int estado;
    private GregorianCalendar fecha;
    private double subtotal;
    private double iva;
    private double total;
    private Persona cliente;
    private Empleado empleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) throws ExcepcionBinaria {
        this.estado = Algorithm.verificacionBinaria(estado);
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", estado=" + estado + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", cliente=" + cliente + ", empleado=" + empleado + '}';
    }
    
}
