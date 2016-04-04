package query;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class QueryTest {
	private static final String allQuery = "Select Books.Price, Books.Title from books";
	private static final String authorPublisherQuery = "select Books.price, boorks.title" + " from books, booksauthors, authors, publishers" +
	" where authors authors.author_id = Booksauthors.author_id and booksauthors.isbn = books.isbn" + 
			" and books.publisher_id = publishers.publisher_id and authors.name = ?"
	+ " And publishers.name = ?";
	private static final String authorQuery = "select books.price, books.title from books, booksauthors, authors";
	private static final String publisherQuery = "select books.price, books.title from books, publishers"
			+ " where books.publisher_id = publishers.publisher_id_ and publishers.nams = ?";
	private static final String priceUpdate = "Update books " + "set price = price + ? "
			+ " where books.publisher_id = (select publisher_id from publishers where name = ?)";
	private static Scanner in;
	private static Connection conn;
	private static ArrayList<String> authors = new ArrayList<>();
	private static ArrayList<String> publishers = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		try
		{
			conn = getConnection();
			in = new Scanner(System.in);
			authors.add("ANY");
			publishers.add("ANY");
			try (Statement stat = conn.createStatement()){
				String query = "select name from authors";
				try(ResultSet rs = stat.executeQuery(query)){
					while(rs.next())
						authors.add(rs.getString(1));
				}
				query = "select name from publishers";
				try(ResultSet rs = stat.executeQuery(query)){
					while(rs.next())
						publishers.add(rs.getString(1));
				}
			}
			boolean done = false;
			while(!done)
			{
				System.out.print("Q)uery C)hange prices E)xit: ");
				String input = in.next().toUpperCase();
				if(input.equals("Q"))
					executeQuery();
				else if (input.equals("C"))
					changePrices();
				else
					done = true;
			}
		}
		catch (SQLException e)
		{
			for (Throwable t : e)
				System.out.println(t.getMessage());
			
		}
		
	}
	
	private static void executeQuery() throws SQLException {
		String author = select("Authors:", authors);
		String publisher = select("Publishers:", publishers);
		PreparedStatement stat;
		if(!author.equals("Any") && publisher.equals("Any"))
		{
			stat = conn.prepareStatement(authorPublisherQuery);
			stat.setString(1,  author);
			stat.setString(2, publisher);
			
		}
		else if (!author.equals("Any") 
				&& publisher.equals("Any"))
			{
				stat = conn.prepareStatement(authorQuery);
				stat.setString(1, author);
			}
		else if (author.equals("Any") && !publisher.equals("Any"))
		{
			stat = conn.prepareStatement(publisherQuery);
			stat.setString(1, publisher);
		}
		else stat = conn.prepareStatement(allQuery);
		try (ResultSet rs = stat.executeQuery())
		{
			while (rs.next())
				System.out.println(rs.getString(1) + ", " + rs.getString(2));
		}
	}
	
	public static void changePrices() throws SQLException
	{
		String publisher = select("Publihsers:", publishers.subList(1, publishers.size()));
		System.out.print("Change prices by: ");
		double priceChange = in.nextDouble();
		PreparedStatement stat = conn.prepareStatement(priceUpdate);
		stat.setDouble(1, priceChange);
		stat.setString(2, publisher);
		int r = stat.executeUpdate();
		System.out.println(r + " records updated.");
	}
	
	public static String select(String prompt, List<String> options)
	{
		while(true)
		{
			System.out.println(prompt);
			for(int i = 0; i < options.size(); i++)
				System.out.printf("%2d), %s%n", i + 1, options.get(i));
			int sel = in.nextInt();
			if (sel > 0 && sel <= options.size())
				return options.get(sel - 1);
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException {
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
