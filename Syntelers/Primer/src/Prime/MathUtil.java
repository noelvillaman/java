package Prime;

public class MathUtil{

		public static void main(String[] args) {
			//System.out.print("Hello World");
			for(int i = 0; i < 12; i++)
			{
				//System.out.println(isPrime(i));
			}
			
			System.out.println(isPrime(154));
			
		}
		
		public static boolean isPrime(int n) {
			   if (n <= 1) {
			       return false;
			   }
			   for (int i = 2; i <= Math.sqrt(n); i++) {
				   //System.out.println("here");
			       if (n % i == 0) {
			           return false;
			       }
			   }
			   return true;
			}
}
