package test;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class TestDB {

	public static void main(String[] args) throws IOException {
		try {
			runTest();
		} catch (SQLException ex) {
			for (Throwable t : ex)
				t.printStackTrace();
		}
	}

	public static void runTest() throws SQLException, IOException {
		try (Connection conn = getConnection()) {
			Statement stat = conn.createStatement();
			stat.executeUpdate("CREATE TABLE GREETING (Message char(20))");
			stat.executeUpdate("Insert into greetings values('Hello, World!')");
			try (ResultSet result = stat.executeQuery("Select * from greetings")) {
				if (result.next())
					System.out.println(result.getString(1));
			}
			stat.executeUpdate("Drop table greetings");
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
		Properties props = new Properties();
		try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
		{
			props.load(in);
		}
		String drivers = props.getProperty("jdbc.drivers");
		if(drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}

}
