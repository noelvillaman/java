package parcela;

import java.util.ArrayList;

public class MyString {
		static StringBuilder s = new StringBuilder();
		static StringBuilder num = new StringBuilder();
		static StringBuilder special = new StringBuilder();
		public static void main(String[] args)
        {
            //System.out.println("Hello");
            myString("1abc$e3h#47");
            System.out.println(s);
			System.out.println(num);
			System.out.println(special);
        }
		public static void myString(String mia)
		{
			ArrayList<String> p = new ArrayList();
			ArrayList<String> n = new ArrayList();
			ArrayList<String> prt = new ArrayList();
			String[] parts = new String[mia.length()];
			//System.out.println(mia);
			for(char letter: mia.toCharArray()){
				//System.out.println(letter);
				try{
				if(Character.isLetter(letter))
				{				
					s.append(letter);
					
					 
				}
				}catch (ArrayIndexOutOfBoundsException e){
					System.out.println("No good");
				}
				try{
				if(Character.isDigit(letter))
				{
					num.append(letter);
					int charValue= Character.getNumericValue(letter);
					//System.out.println(charValue + "....");
					if(isPrime(charValue))
					{
						System.out.println(letter + " is prime");
					}
					//System.out.println(num);
				}
				} catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("NO good");
				}
				try{
					if(!Character.isDigit(letter) && !Character.isLetter(letter))
				{
					special.append(letter);
					
				}
				}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("NO good");
					}
				}
			//System.out.println(s);
			//System.out.println(num);
			//System.out.println(special);
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
