package arrayList;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<Employee>();
		staff.add(new Employee("Noel Villama", 75000, 1987, "Dec", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Nov", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Oct", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Jan", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Mar", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "May", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Jun", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Jul", 15));
		staff.add(new Employee("Noel Villama", 75000, 1987, "Jul", 15));
		
		
		
		for(Employee e : staff)
			e.raiseSalary(5);
		
		for(Employee e: staff)
			System.out.println(e.toString());
	}

}
