package Noel2.noel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransactions {
	private Statement stmt;
	private Connection con;

	public JDBCTransactions() {
		try {
			//1. Define the driver for the database.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Get a connection from the driver manager
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "syntel123$");
			
			//3. Create a statement from the connection
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/*
	 * Execute queries
	 */
	public boolean insert() {
		try {
			return stmt.execute("Insert into authors values(3, 'Noelf', 'Villaman')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean displayAuthors()
	{
		ResultSet rs;
		try {
			rs = stmt.executeQuery("select * from Authors");
			
			while(rs.next()){
				int aid = rs.getInt("id");
				String name = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				System.out.println(aid + " " + name + " "+ lastname);
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteItem()
	{
		try {
			return stmt.execute("Delete from authors where first_name = 'Noel'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	/*
	 * Close all and call for garbage collection
	 */
	public void close() {
		con = null;
		stmt = null;
		System.gc();
	}

}
