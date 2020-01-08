/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import algoritmo.Algorithm;
import excepcion.ExcepcionBinaria;

/**
 *
 * @author Eduardo Ayora
 */
public class Empleado extends Persona{
    
    private int tipoAdministrador;
    private String usuario;
    private String contrasenia;

    public int getTipoAdministrador() {
        return tipoAdministrador;
    }

    public void setTipoAdministrador(int tipoAdministrador) throws ExcepcionBinaria {
        this.tipoAdministrador = Algorithm.verificacionBinaria(tipoAdministrador);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Empleado{" + "tipoAdministrador=" + tipoAdministrador + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
    
}
