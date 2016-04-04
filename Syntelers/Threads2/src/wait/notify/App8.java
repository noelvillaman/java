package wait.notify;

import java.util.Scanner;

public class App8 {

	public static void main(String[] args) {
		
	}
	
	public void producer() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread running....");
			wait();
			
		}
	}
	
	public void consume() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this){
			System.out.println("Waiting for return key...");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			notify();
		}
	}

}
