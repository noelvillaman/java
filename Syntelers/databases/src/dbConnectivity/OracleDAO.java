/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LS5028230
 */
public class OracleDAO {
    Connection connection;
    public Connection getOracleConnection(){
        try {
                   Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                    System.out.println("Where is your Oracle JDBC Driver?");
                    e.printStackTrace();                       
            }
            System.out.println("Oracle JDBC Driver Registered!");
            connection = null;
            try {
                    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","syntel123$");

            } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
            }   
            return connection;
    }
}
