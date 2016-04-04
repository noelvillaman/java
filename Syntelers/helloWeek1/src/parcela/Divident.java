package parcela;

public class Divident extends MeneMeneMain {
	public double divideIntegers(int num1, int num2, int num3){
		return num2/num1;
	}
	
	public double div(){
		Divident div = new Divident();
		System.out.print("This method is in the child class: ");
		return div.divideIntegers(4, 5, 7);
	}
}
