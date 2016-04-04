package thread;

public class MaintThread1 {

	public static void main(String[] args) {
		Thread1 threadA = new Thread1();
		threadA.start();
		Thread threadB = new Thread(new Thread2());
		threadB.start();

	}

}

class Thread1 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 11; i++){
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 11; i++){
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
