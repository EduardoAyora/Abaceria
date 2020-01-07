/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

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
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        String dat = format.format(date.getTime());
        return dat;
    }
    
}
