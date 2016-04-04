package helloWeek1;

public class HelloWeek1 {

	public static void main(String[] args) {
		System.out.println("Hello World ");
		System.out.println(isPrime(100));
		
	}
	
	public static boolean isPrime(int n) {
		   if (n <= 1) {
		       return false;
		   }
		   for (int i = 2; i < Math.sqrt(n); i++) {
		       if (n % i == 0) {
		           return false;
		       }
		   }
		   return true;
		}

}
