package org.villaman.youtube.threads;

import java.util.Scanner;

class Processor extends Thread{
	private volatile boolean running = true;
	public void run(){
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shoutdown(){
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press enter to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		proc1.shoutdown();
	}

}
