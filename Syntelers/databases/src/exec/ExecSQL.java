package exec;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.sql.*;

public class ExecSQL {

	public static void main(String[] args) throws IOException {
		try {
			Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0]));
			try (Connection conn = getConnection()) {
				Statement stat = conn.createStatement();
				while (true) {
					if (args.length == 0)

						System.out.println("Enter command or EXIT to exit:");
					if (!in.hasNextLine())
						return;
					String line = in.nextLine();
					if (line.equalsIgnoreCase("EXIT"))
						return;
					if (line.trim().endsWith(";")) // remove trailing semicolon
					{
						line = line.trim();
						line = line.substring(0, line.length() - 1);
					}
					try {
						boolean isResult = stat.execute(line);
						if (isResult) {
							ResultSet rs = stat.getResultSet();
							showResultSet(rs);
						} else {
							int updateCount = stat.getUpdateCount();
							System.out.println(updateCount + " rows updated");
						}
					} catch (SQLException ex) {
						for (Throwable e : ex)
							e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			for (Throwable t : e)
				t.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
			props.load(in);
		}
		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);
	}

	public static void showResultSet(ResultSet result) throws SQLException {
		ResultSetMetaData metadata = result.getMetaData();
		int columnCount = metadata.getColumnCount();

		for (int i = 1; i <= columnCount; ++i) {
			if (i > 1)
				System.out.println(", ");
			System.out.print(metadata.getColumnLabel(i));
		}
		System.out.println();
		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				if (i > 1) {
					System.out.print(", ");
					System.out.print(result.getString(i));
				}
				System.out.println();
			}
		}
	}
}
