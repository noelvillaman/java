package threadsFunctions;

public class MainTests {

	public static void main(String[] args) {
		MathSin st = new MathSin(45);
		MathCos ct = new MathCos(60);
		MathTan tt =  new MathTan(30);
		st.start();
		ct.start();
		tt.start();
		try{
			st.join();
			ct.join();
			tt.join();
			
			double z = st.res + ct.res + tt.res;
			System.out.println("Sum of sin, cos tan = "+z);
		}
		catch(InterruptedException ie){
			System.out.println("Something happed "+ie.getMessage());
		}
	}

}
