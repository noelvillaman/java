/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqlConnectivity;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author LS5028230
 */
public class MySQLMetadata {
	public static void main(String args[]) {
		String[] tables;
		try {
			MySQLJDBC ojdbc = new MySQLJDBC();
			Connection con = ojdbc.getMySQLConnection();

			ConnectivityMethods select = new ConnectivityMethods();
			select.select(ojdbc);
			// select.insert(ojdbc);
			// select.delete(ojdbc);

			PreparedStatement ps = con.prepareStatement("select * from persons");
			ResultSet rs = ps.executeQuery();

			// ResultSetMetaData rsmd=rs.getMetaData();

			DatabaseMetaData dbmd = con.getMetaData();
			rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
			//
			// System.out.println("Total columns: "+rsmd.getColumnCount());
			// System.out.println("Column Name of 1st column:
			// "+rsmd.getColumnName(1));
			// System.out.println("Column Type Name of 1st column:
			// "+rsmd.getColumnTypeName(1));
			int count = 0;
			tables = new String[12];
			while (rs.next()) {
				count++;
				System.out.println(count + " " + rs.getString("TABLE_NAME"));
				tables[count - 1] = rs.getString("TABLE_NAME");
				// ps = con.prepareStatement("select * from " +
				// rs.getString(""));
				// rs = ps.executeQuery();
			}

			for (String tables1 : tables) {
				/*if(tables1 == null)
					continue;
				ps = con.prepareStatement("select * from " + tables1);
				rs = ps.executeQuery();*/
				
				System.out.println(tables1);
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
