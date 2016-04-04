/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LS5028230
 */
public class JDBCandObjects {
    public static void main(String args[]) throws Exception {
        
            OracleDAO ojdbc=new OracleDAO();
            Connection con=ojdbc.getOracleConnection();
            
            Emp employee = new Emp(42, "Alexis", 9);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(employee);
            byte[] employeeAsBytes = baos.toByteArray();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO EMP(e) VALUES(?)");
            ByteArrayInputStream bais = new ByteArrayInputStream(employeeAsBytes);
            pstmt.setBinaryStream(1, bais, employeeAsBytes.length);
            pstmt.executeUpdate();
            pstmt.close();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT e FROM Emp");
            while (rs.next()) {
                byte[] st = (byte[]) rs.getObject(1);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                Emp emp = (Emp) ois.readObject();
                System.out.println(emp.name);
            }
            stmt.close();
            rs.close();
            con.close();
  }
}
