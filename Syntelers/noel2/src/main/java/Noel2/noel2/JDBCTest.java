package Noel2.noel2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JDBCTest {
	static JDBCTransactions reference;
	
	@BeforeClass
	public static void setup()
	{
		reference = new JDBCTransactions();
	}
	
	
	@Test
	public void insert(){
		Assert.assertTrue(reference.insert());
	}
	
	@Test
	public void retrieveAuthors()
	{
		Assert.assertTrue(reference.displayAuthors());
	}
	
	@Test
	public void deletetTest()
	{
		Assert.assertTrue(reference.deleteItem());
	}
	
	@AfterClass
	public static void teardown(){
		reference.close();
	}

}
