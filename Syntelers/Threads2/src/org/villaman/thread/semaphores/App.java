package org.villaman.thread.semaphores;

import java.util.concurrent.Semaphore;

public class App {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		
		sem.release();
		sem.release();
		
		System.out.println("Availabel permit: " + sem.availablePermits());
	}

}
