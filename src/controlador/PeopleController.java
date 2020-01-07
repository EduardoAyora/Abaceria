/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Eduardo Ayora
 */
public class PeopleController {
    
    private DataBaseConnection dataBaseConnection;

    public PeopleController() {
        dataBaseConnection = new DataBaseConnection();
    }
    
    public String read(int code){
        String people = "";
        try{
            String sql = "select first_name, last_name from employees "
                    + "where employee_id = 100";
            dataBaseConnection.connect();
            Statement sta = dataBaseConnection.getConnection().createStatement();
            ResultSet rs = sta.executeQuery(sql);
            if(rs.next()){
                people = rs.getString("first_name") + rs.getString("last_name");
            }
            rs.close();
            sta.close();
            dataBaseConnection.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return people;
    }
    
}
