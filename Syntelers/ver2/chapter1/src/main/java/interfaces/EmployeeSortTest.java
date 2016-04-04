package interfaces;
import java.util.Arrays;


public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Zoel Villaman", 65000);
		staff[1] = new Employee("Jonni Villaman", 75000);
		staff[2] = new Employee("Aoel Villaman", 65000);
		
		Arrays.sort(staff);
		for(Employee e : staff)
			System.out.println(e.toString());
	}

}
