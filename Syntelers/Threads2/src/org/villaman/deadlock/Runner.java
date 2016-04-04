package org.villaman.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account acc1 = new Account();
	private Account acc2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquireLock(Lock firstL, Lock secondL) throws InterruptedException {
		
		while (true) {
			// Acquire locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try{
				gotFirstLock = firstL.tryLock();
				gotSecondLock = secondL.tryLock();
			}
			finally{
				if(gotFirstLock && gotSecondLock){
					return;
				}
				if(gotFirstLock){
					firstL.unlock();
				}
				if(gotSecondLock){
					secondL.unlock();
				}
			}
			
			//Locks not acquired
			Thread.sleep(1);
		}
	}

	public void firsThread() throws InterruptedException {

		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			// lock1.lock();
			// lock2.lock();
			acquireLock(lock1, lock2);
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			// lock1.lock();
			// lock2.lock();
			acquireLock(lock2, lock1);
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}

}
