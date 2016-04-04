package noelsproject;



	/**
	 *
	 * @author villaman
	 */
	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	/**
	 *
	 * @author LS5028230
	 */
	public class DBConnection {
	    public static void main(String args[]){  
	    	LoginAction login = new LoginAction();
	    	String name = login.getCname();
	    	//String password = login.getPassword();
	            try{  
	            //step1 load the driver class  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  

	            //step2 create  the connection object  
	            Connection con=DriverManager.getConnection(  
	            "jdbc:oracle:thin:@localhost:1521:xe","system","syntel123$");  

	            //step3 create the statement object  
	            Statement stmt=con.createStatement();  

	            if (con != null) {
		System.out.println("You made it, take control your database now!");
	            } else {
		System.out.println("Failed to make connection!");
	            }
	            
	          /*      OracleDAO ojdbc=new OracleDAO();
	                Connection con=ojdbc.getOracleConnection();
	              Statement stmt=con.createStatement();  */
	            
	            
	            //step4 execute query  
	            ResultSet rs=stmt.executeQuery("select * from course1");
	            System.out.println("Fetch Size:"+rs.getFetchSize());
	            System.out.println("CID\tCNAME\tCFESS");
	            while(rs.next())  
	                //System.out.println(rs.getInt("cid")+"\t  "+rs.getString(2)+"\t  "+rs.getString(3));  
	                System.out.format("%7s %7s %7s\n",rs.getInt("cid"),rs.getString(2),rs.getString(3));

	            //step5 close the connection object  
	            con.close();  

	            }catch(Exception e){ System.out.println(e);}  

	    }  
	}
