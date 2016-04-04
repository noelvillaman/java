/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package noelsproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author LS5002117
 * 
 * Creating the POJO to be used with the Action Class
 */
public class LoginAction {
	private int cid;
    private String cname;
    private int cfees;
    private String word;

    
    
    public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCfees() {
		return cfees;
	}

	public void setCfees(int cfees) {
		this.cfees = cfees;
	}

	public String execute1(){
    	int p = authenticate();
    	
        if(p == 1)
        		/*userName.equals("noel") || password.equals("villaman") || password.length()<4 || password.equals(userName))*/
        	
            return "success";
        else
            return "fail";
    }
    
    public boolean useList(List<String> arr, String targetValue) {
    	return Arrays.asList(arr).contains(targetValue);
    }
    
    public int authenticate()
    {
    	
    	//List <String> arr = new ArrayList();
    	    try{  
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  

            //step2 create  the connection object  
            Connection con=DriverManager.getConnection(  
            "jdbc:oracle:thin:@localhost:1521:xe","system","syntel123$");  

            //step3 create the statement object  
            Statement stmt=con.createStatement();  

            /*if (con != null) {
				//System.out.println("You made it, take control your database now!");
            } else {
				//System.out.println("Failed to make connection!");
            }
            
          /*      OracleDAO ojdbc=new OracleDAO();
                Connection con=ojdbc.getOracleConnection();
              Statement stmt=con.createStatement();  */
            
            
            //step4 execute query  
            //ResultSet rs=stmt.executeQuery("select * from course1");
            //select cname from course1 where cname='java'
            ResultSet rs=stmt.executeQuery("select cname from course1 where cname='"+cname+"'");
            
            //System.out.println("Fetch Size:"+rs.getFetchSize());
            //System.out.println("CID\tCNAME\tCFESS");
          //  while(rs.next())  
                //System.out.println(rs.getInt("cid")+"\t  "+rs.getString(2)+"\t  "+rs.getString(3));  
                //System.out.format("%7s %7s %7s\n",rs.getInt("cid"),rs.getString(2),rs.getString(3));
            rs.next();	
            //System.out.println(rs.getString("cname"));
            	word = rs.getString("cname");
            	//arr.add(rs.getString(2));
            //step5 close the connection object  
            con.close();  

            }catch(Exception e){ System.out.println(e);
            
        } 
    	   // System.out.println(word);
    	    if(word.equals(cname))
    	    	
            	
        		return 1;
    	    
        	 else
        		 
        		return 0;
    }
}
