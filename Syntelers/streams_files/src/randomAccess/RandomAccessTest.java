package randomAccess;

import java.io.*;
import java.util.*;
import textFile.Employee;

public class RandomAccessTest {

	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Jose Guevo", 75000, 1987, 12, 15);
		staff[1] = new Employee("Noel Villaman", 89000, 1999, 8, 16);
		staff[2] = new Employee("Mia Chila", 56000, 1990, 3, 15);
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee1.dat")))
		{
			//save all employee records to the file employee1.net
			for(Employee e : staff)
				writeData(out, e);
		}
		try(RandomAccessFile in = new RandomAccessFile("employee1.dat", "r"))
		{
			//retrieve all records into a new array
			//compute the array size 
			int n = (int)(in.length()/ Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			
			//read employees in reverse order
			for(int i = n - 1; i >= 0; i--)
			{
				newStaff[i] = new Employee();
				in.seek(i * Employee.RECORD_SIZE);
				newStaff[i] = readData(in);
			}
			
			//print the newly read employee records
			for(Employee e : newStaff)
				System.out.println(e);
		}
	}
	
	public static void writeData(DataOutput out, Employee e) throws IOException
	{
		DataIO.writeFixedString(e.getEmpName(), Employee.NAME_SIZE, out);
		out.writeDouble(e.getEmpSal());
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) - 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	public static Employee readData(DataInput in) throws IOException
	{
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(name, salary, y, m -1, d);
	}

}
