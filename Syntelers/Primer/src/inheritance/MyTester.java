package inheritance;

public class MyTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager boss= new Manager("Noel Villaman", 80000, 1987,12,15);
		boss.setBonus(5000);
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Pedro Ledesma", 40000, 1990, 3, 15);
		
		for(Employee e : staff)
		{
			System.out.println("name= " + e.getName() + ", salary= " + 
					e.getSalary());
		}
	}

}
