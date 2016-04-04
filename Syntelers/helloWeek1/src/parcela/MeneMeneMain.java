package parcela;

public class MeneMeneMain {

	public static void main(String[] args) {
		MeneMeneMain mene = new MeneMeneMain();
		mene.exceptionDemo();
		//System.out.println(mene.divideIntegers(10, 0));
		Divident div2 = new Divident();
		System.out.println(div2.div());
		System.out.println(div2.div());
		div2.exceptionDemo();
	}
	
	public void exceptionDemo(){
		int r = 0;
		int k = 10;
		try{
			int t = k/r;
		} catch(ArithmeticException ae){
			System.out.println(ae.getMessage());
		} //finally {
//			System.out.println("Todo se derrumbo dentro de mi:" + "\n");
//		}
		System.out.println("Hello");
	}
	
	public double divideIntegers(int num1, int num2){
		try{
			if(num2 == 0)
				throw new ArithmeticException("divisor cannot be zero");
			else
				return num1/num2;
		} catch(ArithmeticException ae){
			System.out.println("Go away! " + ae.getMessage());
		}
		return num2;
	}
	
	public double divideIntegers(int num1, int num2, int num3){
		System.out.println("This method is in the parent class");
		return num1/num2/num3;
	}
	
	

}