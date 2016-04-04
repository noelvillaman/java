/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author LS5028230
 */
public class DatabaseMetaDataEx {
     public static void main(String args[]){  
            try{  
            OracleDAO ojdbc=new OracleDAO();
            Connection con=ojdbc.getOracleConnection();

            DatabaseMetaData dbmd=con.getMetaData();  
  
            System.out.println("Driver Name: "+dbmd.getDriverName());  
            System.out.println("Driver Version: "+dbmd.getDriverVersion());  
            System.out.println("UserName: "+dbmd.getUserName());  
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
           System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

            con.close();  

            }catch(Exception e){ System.out.println(e);}  

     }  
}
