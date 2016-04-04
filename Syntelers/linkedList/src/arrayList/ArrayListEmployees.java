package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEmployees {
	
	public static void main(String[] args) throws Exception {
	       
        List<Employees> col = new ArrayList<Employees>();

        col.add(new Employees(5, "Frank", 28));
        col.add(new Employees(1, "Jorge", 19));
        col.add(new Employees(6, "Bill", 34));
        col.add(new Employees(3, "Michel", 10));
        col.add(new Employees(7, "Simpson", 8));
        col.add(new Employees(4, "Clerk",16 ));
        col.add(new Employees(8, "Lee", 40));
        col.add(new Employees(2, "Mark", 30));
        
        // Iterating through the Employee List
        for (Employees s : col){
            System.out.println(s);   
        }
        
        ArrayListDemo demon = new ArrayListDemo();
        demon.listNames();
    }

}
