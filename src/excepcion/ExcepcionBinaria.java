/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcion;

/**
 *
 * @author Eduardo Ayora
 */
public class ExcepcionBinaria extends Exception{

    public ExcepcionBinaria() {
        super("Solo se admite 1 o 0");
    }
    
}
