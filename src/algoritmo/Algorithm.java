/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import excepcion.ExcepcionBinaria;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author eduar
 */
public class Algorithm {
    
    public static String dateToString(GregorianCalendar date){
        //Format format = new SimpleDateFormat("yyyy-MM-dd");
        Format format = new SimpleDateFormat("dd-MM-yyyy");
        String dat = format.format(date.getTime());
        return dat;
    }
    
    public static int verificacionBinaria(int numero) throws ExcepcionBinaria{
        if(numero == 1 || numero == 0){
            return numero;
        }else{
            throw new ExcepcionBinaria();
        }
    }
    
}
