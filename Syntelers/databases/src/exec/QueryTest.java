package exec;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

import javax.xml.transform.Result;

public class QueryTest {

	private static final String allQuery = "SELECT Books.prince, Books.title from books";
	private static final String authorPublisherQuery = "SELECT Books.price, Books.title"
			+ " where Authors.author_id = BooksAuthors.author_id and BooksAuthors.ISBN = Books.isbn"
			+ " and books.publisher_id and author.name =?" + " and Publishers.name = ?";
	private static final String authorQuery = "Select books.price,Books.title from books, booksauthors"
			+ " where authors.author_id = BooksAuthor.author_id and BooksAuthors.isbn = books.isbn"
			+ " And Authors.name = ?";
	private static final String publisherQuery = "Select books.price, books.title from books, publishers"
			+ " where books.publisher_id = publishers.publisher_id and publishers.name = ?";
	private static final String priceUpdate = "UPDATE books " + "set price = price + ?"
			+ " where books.publisher_id = (select publisher_id from publishers where name = ?)";
	private static Scanner in;
	private static Connection conn;
	private static ArrayList<String> publishers = new ArrayList<>();
	private static ArrayList<String> authors = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		try {
			conn = getConnection();
			in = new Scanner(System.in);
			authors.add("Any");
			publishers.add("Any");
			try (Statement stat = conn.createStatement()) {
				// Fill the authors arraylist
				String query = "Select name from Authors";
				try (ResultSet rs = stat.executeQuery(query)) {
					while (rs.next())
						authors.add(rs.getString(1));
				}
				// Fill the publishers array list
				query = "Select name from publishers";
				try (ResultSet rs = stat.executeQuery(query)) {
					while (rs.next())
						publishers.add(rs.getString(1));
				}
			}
			boolean done = false;
			while (!done) {
				System.out.print("Q)uery C)hange prices E)Xit: ");
				String input = in.next().toUpperCase();
				if (input.equals("Q")) {
					executeQuery();
				} else if (input.equals("C"))
					changePrices();
				else
					done = true;
			}
		} catch (SQLException e) {
			for (Throwable t : e)
				System.out.println(t.getMessage());
		}
	}

	private static void executeQuery() throws SQLException {
		String author = select("Authors:", authors);
		String publisher = select("Publishers:", publishers);
		PreparedStatement stat;
		if (!author.equals("ANY") && !publisher.equals("Any")) {
			stat = conn.prepareStatement(authorPublisherQuery);
			stat.setString(1, author);
			stat.setString(2, publisher);
		} else if (!author.equals("Any") && publisher.equals("Any")) {
			stat = conn.prepareStatement(authorQuery);
			stat.setString(1, author);
		} else if (author.equals("Any") && !publisher.equals("Any")) {
			stat = conn.prepareStatement(publisherQuery);
			stat.setString(1, publisher);
		} else
			stat = conn.prepareStatement(allQuery);
		try (ResultSet rs = stat.executeQuery()) {
			while (rs.next())
				System.out.println(rs.getString(1) + ", " + rs.getString(2));

		}
	}

	public static void changePrices() throws SQLException {
		String publisher = select("Publishers:", publishers.subList(1, publishers.size()));
		System.out.print("Change prices by: ");
		double priceChange = in.nextDouble();
		PreparedStatement stat = conn.prepareStatement(priceUpdate);
		stat.setDouble(1, priceChange);
		stat.setString(2, publisher);
		int r = stat.executeUpdate();
		System.out.println(r + " record updated.");
	}

	public static String select(String prompt, List<String> options) {
		while (true) {
			System.out.println(prompt);
			for (int i = 0; i < options.size(); i++)
				System.out.printf("%2d), %s%n", i + 1, options.get(i));
			int sel = in.nextInt();
			if (sel > 0 && sel <= options.size())
				return options.get(sel - 1);
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

}
