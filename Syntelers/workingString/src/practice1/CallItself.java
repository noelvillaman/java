package practice1;

public class CallItself {

	public static void main(String[] args) {
		CallItself call = new CallItself();
		System.out.println(call.factorial(10));

	}

	public int factorial(int number){
		//System.out.println(number);
		if(number == 1)

			return 1;
		else
			return factorial(number-1) * number;
	}
}
