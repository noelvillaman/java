/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author LS5028230
 */
public class ResultSetMetadata {
    public static void main(String args[]){  
            try{  
            OracleDAO ojdbc=new OracleDAO();
            Connection con=ojdbc.getOracleConnection();

            PreparedStatement ps=con.prepareStatement("select * from course");  
            ResultSet rs=ps.executeQuery();  

            ResultSetMetaData rsmd=rs.getMetaData();  

            System.out.println("Total columns: "+rsmd.getColumnCount());  
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  

            con.close();  

            }catch(Exception e){ System.out.println(e);}  

     }  
}
