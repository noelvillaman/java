package clone;

public class CloneTest {
	private static int p;
	public static void main(String[] args)
	{
		System.out.println("Here is p: " +p);
		System.out.println("This is the result: " + string1());
		myarr();
		try
		{
			Employee original = new Employee("John Q. Doe", 50000);
			original.setHireDay(2000, 1, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			
			System.out.println("original=" + original);
			System.out.print("copy=" + copy);
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean string1(){
		String a = "Syntel";
		String b = "Syntel";
		if(a.equals(b))
			return true;
		else
			return false;
	}
	
	public static void myarr(){
		int[] a = {01,2,3,4};
		int b[] = {10,11,12,13,14};
		a = b;
		b = new int[] {20,21,22,23,24};
		for(int i=0; i<a.length && i<b.length; i++){
			System.out.println(a[i]+" "+b[i]);
		}
	}

}
