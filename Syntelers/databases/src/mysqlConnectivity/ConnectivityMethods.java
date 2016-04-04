package mysqlConnectivity;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.*;

public class ConnectivityMethods {
	Statement stmt = null;
	
	public ConnectivityMethods(){};
	
	public void select(MySQLJDBC myconn)
	{
		try{ 
		myconn = new MySQLJDBC();
		Connection con = (Connection) myconn.getMySQLConnection();
		
		stmt = (Statement) con.createStatement();

	      String sql = "SELECT personid, lastname, firstname, address, city FROM persons order by personid";
	      java.sql.ResultSet rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      
			while(rs.next()){
				//Retrieve by column name
		         int id  = rs.getInt("Personid");
		         String last = rs.getString("LastName");
		         String first = rs.getString("FirstName");
		         String address = rs.getString("Address");
		         String city = rs.getString("city");
		         
		         System.out.print(id + " " + first  +" " + last + " " + address + ", " + city +"\n");
	      }
	      rs.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void insert(MySQLJDBC myconn){
		try
		{
			myconn = new MySQLJDBC();
			myconn = new MySQLJDBC();
			Connection con = (Connection) myconn.getMySQLConnection();
			
			stmt = (Statement) con.createStatement();

		      String sql = "INSERT INTO PERSONS (personid, lastname, firstname, address, city) "
		      		+ "values(45, 'Beggerly', 'Peter', '50 Milk', 'Boston')";
		      stmt.executeUpdate(sql);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void delete(MySQLJDBC myconn){
		try
		{
			myconn = new MySQLJDBC();
			//myconn = new MySQLJDBC();
			Connection con = (Connection) myconn.getMySQLConnection();
			
			stmt = (Statement) con.createStatement();

		      String sql = "DELETE FROM persons WHERE firstname='Peter' AND lastname='Beggerly';";
		      stmt.executeUpdate(sql);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void metaData() throws SQLException{
      java.sql.Connection rs = null;
	ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();  

      System.out.println("Total columns: "+rsmd.getColumnCount());  
      System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
      System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
	}

}
