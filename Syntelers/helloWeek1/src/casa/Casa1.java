package casa;

public class Casa1 {

	public static void main(String[] args) {
		Casa1 casa = new Casa1();
		(new Thread(new MyThread(casa))).start();
		casa.ellEll();
	}

	
	public void ell(){
		double[][] doubles = new double[3][3];
		doubles[1] = new double[]{2.3,4.5,7.6};
		doubles[2] = new double[]{6.6,2.2,3.3};
		doubles[0] = new double[]{2.5,6.2};
//		for(double[] row : doubles)
//			for(double values : row)
//				System.out.print(" "+values);
		for(int i =0; i< doubles.length; i++){
			for(int j = 0; j < doubles[0].length; j++){
				System.out.println(doubles[i][j]);
			}
		}
	}
	
	public void callEll(){
		for(int i =0; i < 12; i++){
			ell();
		}
	}
	
	public void ellEll(){
		for(int i = 0; i < 12; i++){
			callEll();
			System.out.println();
		}
	}

}

class MyThread implements Runnable{
	private Casa1 casa;
	public MyThread(Casa1 casa) {
		this.casa = casa;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			for(int i = 0; i < 12; i++){
				casa.ellEll();
			}
			//casa.callEll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}