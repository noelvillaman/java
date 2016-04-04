package textFile;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	public static final int RECORD_SIZE = 10;
	private String empName;
	private double empSal;
	private Date hireDay;
	public final static int NAME_SIZE = 10;
	private String[] months = {"Jan", "Feb", "Mar","May", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public Employee(String empName, double salary, int year, int month, int day){
		this.empName = empName;
		this.empSal = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	public double raiseSalary(int percent)
	{
		this.empSal =this.empSal + (int) (this.empSal * ((float)percent/100));
		
		return this.empSal;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
}

