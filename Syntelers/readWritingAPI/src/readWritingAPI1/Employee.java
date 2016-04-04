package readWritingAPI1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Employee{

	private double salary;
	private Date hireDay;
	private String name;
	public final static int NAME_SIZE = 10;
	public final static int RECORD_SIZE = 10;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String n, double s, int year, int month, int day) {
		this.name = n;
		this.salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		hireDay = calendar.getTime();
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee name=" + name + ", hireDay=" + hireDay + ", salary=" + salary;
	}
	
	
}
