package arrayList;

public class Employee {
	private String empName;
	private int empSal;
	private int year;
	private String month;
	private int day;
	private String[] months = {"Jan", "Feb", "Mar","May", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public Employee(String empName, int salary, int year, String month, int day){
		this.empName = empName;
		this.empSal = salary;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSal() {
		return empSal;
	}
	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int raiseSalary(int percent)
	{
		this.empSal =this.empSal + (int) (this.empSal * ((float)percent/100));
		
		return this.empSal;
	}
	@Override
	public String toString() {
		return "Employee Name=" + empName + ", Salary=" + empSal + ", date Hired=" + month + " " + day + ", "
				+ year;
	}
	
	

}
