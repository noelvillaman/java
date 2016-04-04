package readWritingAPI2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

import readWritingAPI1.Employee;

public class RandomAccessTest {

	public static void main(String[] args)throws IOException {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Michael Jordan", 100000.00, 1985, 12,15);
		staff[1] = new Employee("Magic Johnson", 200000.00, 1978, 9,1);
		staff[2] = new Employee("Charles Barkley", 300000.00, 1999,10,2);
		
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee1.dat"))){
			//save all employee records to the file employee1.dat
			for(Employee e : staff)
				writeData(out, e);
		}
		
		try(RandomAccessFile in = new RandomAccessFile("employee1.dat", "r"))
		{
			//compute the array size
			int n = (int) (in.length() / Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			for(int i = n - 1; i >= 0; i--)
			{
				newStaff[i] = new Employee();
				in.seek(i * Employee.RECORD_SIZE);
				newStaff[i] = readData(in);
			}
			
			for (Employee e : newStaff)
				System.out.println(e);
		}
	}
	
	public static void writeData(DataOutput out, Employee e) throws IOException
	{
		DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
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
