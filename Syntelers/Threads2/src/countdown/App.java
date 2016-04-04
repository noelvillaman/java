package countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 5; i++){
			executor.submit(new Processor(latch));
		}
		try{
			latch.await();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
	}

}

class Processor implements Runnable{
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run(){
		System.out.println("Started.");
		try{
			Thread.sleep(3000);
		} catch (InterruptedException e){
			
		}
		
		latch.countDown();
	}
}
