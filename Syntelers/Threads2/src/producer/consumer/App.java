package producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	private BlockingQueue queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args){
		App produc = new App();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					produc.producer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					produc.consumer();;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void producer(){
		Random random = new Random();
		while(true){
			try {
				queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void consumer() throws InterruptedException{
		Random random = new Random();
		
		while(true){
			Thread.sleep(100);
			
			if(random.nextInt(10) == 0){
				Integer value = (Integer) queue.take();
				
				System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
			}
		}
	}
}
