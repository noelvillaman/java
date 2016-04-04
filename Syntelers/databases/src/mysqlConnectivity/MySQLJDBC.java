/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqlConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LS5028230
 */
public class MySQLJDBC {
    Connection connection;
    public Connection getMySQLConnection() throws InstantiationException, IllegalAccessException{
        try {
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (ClassNotFoundException e) {
                    System.out.println("Where is your MySQL JDBC Driver?");
                    e.printStackTrace();                       
            }
            //System.out.println("MySQL JDBC Driver Registered!");
            connection = null;
            try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elnino", "root", "987vn746");

            } catch (SQLException ex) {
            	// handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }   
            return connection;
    }
}

