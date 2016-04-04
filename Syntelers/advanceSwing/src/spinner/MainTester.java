package spinner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import tree.SimpleTreeFrame;

public class MainTester {

	public static void main(String[] args) {
		String noel = new String("123");
		String noel1 = new String("123");
		Object
	//	String noel1 = "123";
		
		
//		if(noel == noel1)
//			System.out.println("NOel is good");
//		else
//			System.out.println("Noel is not good");
//		
//		if(noel.equals(noel1))
//			System.out.println("Today");
//		else
//			System.out.println("Tomorrow");
		
		A a = new A();
		B b = new B();
		if(a.equals(b))
			System.out.println("yes");
		else
			System.out.println("No");
//		SwingUtilities.invokeLater(new Runnable(){
//
//			@Override
//			public void run() {
//				JFrame frame = new SpinnerFrame("Spinner Tester");
//				
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.setVisible(true);					
//			}
//			
//		});
//
//	}
	}
}

class A{
	private String n;
	
	public void car(){
		System.out.println("Hello car");
}
}

class B{
	public void today(){
		System.out.println("Hello today");
	}
}