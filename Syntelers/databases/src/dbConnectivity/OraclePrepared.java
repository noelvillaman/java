/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author LS5028230
 */
public class OraclePrepared {
    public static void main(String args[]){  
        try{  
        //Class.forName("oracle.jdbc.driver.OracleDriver");  
            OracleDAO ojdbc=new OracleDAO();
            Connection con=ojdbc.getOracleConnection();
           

            PreparedStatement stmt=con.prepareStatement("insert into course12 values(?,?,?)");  
            stmt.setInt(3,5000);//1 specifies the first parameter in the query  
            stmt.setString(2,"Python");  
             stmt.setString(1,"C004");  
             
        int i=stmt.executeUpdate();  
        System.out.println(i+" records inserted");  

        con.close();  

        }catch(Exception e){ System.out.println(e);}  
  
}  
}
