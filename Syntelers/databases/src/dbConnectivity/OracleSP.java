/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author LS5028230
 */

/*
Procedure: 
    create or replace function sum1(a in number,b in number)  
    return number  
    is   
        temp number(8);  
    begin  
        temp :=a+b;  
        return temp;  
    end;  
    /  

*/
public class OracleSP {
        public static void main(String[] args) throws Exception{  

            OracleDAO ojdbc=new OracleDAO();
            Connection con=ojdbc.getOracleConnection();
            
            CallableStatement stmt=con.prepareCall("{?= call sum1(?,?)}");  
            stmt.setInt(2,10);  
            stmt.setInt(3,40);  
            stmt.registerOutParameter(1,Types.INTEGER);  
            stmt.execute();  

            System.out.println(stmt.getInt(1));  

    }  
}
