package interfaces;

public class Employee implements Comparable<Employee> {
	private String name;
	private double salary;
	private int year;
	private int month;
	private int day;
	
	public Employee(String n,double s){
		name = n;
		salary =s;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public int compareTo(Employee other)
	{
		return name.compareTo(other.name);
		//return Double.compare(salary, other.salary);
	}
	
	public void setHiredDay(int y, int m, int d)
	{
		this.year = y;
		this.month = m;
		this.day = d;
	}

	@Override
	public String toString() {
		return "Employee name=" + name + ", salary=" + salary + ", " + month + " "+day +", "+year;
	}
	
	
}
