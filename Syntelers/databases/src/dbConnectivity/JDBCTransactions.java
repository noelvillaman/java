/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author LS5028230
 */
public class JDBCTransactions {
    public static void main(String args[])throws Exception{  
         OracleDAO ojdbc=new OracleDAO();
         Connection con=ojdbc.getOracleConnection();
        con.setAutoCommit(false);  

        Statement stmt=con.createStatement();  
        stmt.executeUpdate("insert into course12 values('C005','SQL',2000)");  
        stmt.executeUpdate("insert into course12 values('C006','Unix',5000)");  

        con.commit();  
        con.close();  
    }
}
