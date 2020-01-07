import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Arichabala
 */
public class CategoriaProducto {
    private int id;
    private String nombre;
    private Producto producto;

    public CategoriaProducto(int id, String nombre, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" + "id=" + id + ", nombre=" + nombre + ", producto=" + producto + '}';
    }

   
    
}
