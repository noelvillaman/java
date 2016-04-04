package equals;

public class EqualsTester {
    static int age = 10;
	public static void main(String[] args) {
		age = age + 1;
		System.out.print(age);
		Boolean p = true;
		// TODO Auto-generated method stub
		Employee alice1 = new Employee("Alicia Malte", 75000, 1987, 12, 15);
		Employee alice2 = new Employee("Alica Oltega", 75000, 1987, 12, 15);

		Employee alice3 = new Employee("Alicia Malte", 75000, 1987, 12, 15);
		Employee alice4 = new Employee("Alica Oltega", 75000, 1987, 12, 15);

		Employee alice5 = new Employee("Alicia Malte", 75000, 1987, 12, 15);
		Employee alice6 = new Employee("Alica Oltega", 75000, 1987, 12, 15);

		Employee alice7 = new Employee("Alicia Malte", 75000, 1987, 12, 15);
		Employee alice8 = new Employee("Alica Oltega", 75000, 1987, 12, 15);
		
		double d = 34.5;
		
		String[] test ={"n", "p", "h"};
		
	}
	
	public void test()
	{
		int i = this.age;
		System.out.println(i);
	}

}
