package textFile;

import java.io.*;
import java.util.*;

public class TextFileTest {

	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987,01, 15);
		staff[1] = new Employee("Noel Villaman", 87000, 1998, 02, 1);
		staff[2] = new Employee("Pedro Vargas", 49000, 2012, 10, 3);
		
		//save all employee records to a the file employee.dat
		try(PrintWriter out = new PrintWriter("employee.dat", "UTF-8"))
		{
			writeData(staff, out);
			
		}
		try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8"))
		{
			Employee[] newStaff = readData(in);
			//print the newly read employee records
			for(Employee e : newStaff)
				System.out.println(e);
		}
	}
	
	private static void writeData(Employee[] employees, PrintWriter out) throws IOException
	{
		//write number of employees
		out.println(employees.length);
		
		for(Employee e : employees)
			writeEmployee(out, e);
	}
	
	private static Employee[] readData(Scanner in)
	{
		//retrieve the array size
		int n = in.nextInt();
		in.nextLine(); // consume newline
		Employee[] employees = new Employee[n];
		for(int i = 0; i < n; i++)
		{
			employees[i] = readEmployee(in);
		}
		return employees;
	}
	
	public static void writeEmployee(PrintWriter out, Employee e)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		Date date = new Date(e.getDay() + e.getMonth() + e.getYear());
		calendar.setTime(date);
		out.println(e.getEmpName() + "|" + e.getEmpSal() + "|" + calendar.get(Calendar.YEAR) + "|" + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public static Employee readEmployee(Scanner in)
	{
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		int year = Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[3]);
		int day = Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);
	}
}
