package com.villaman.thread101;

public class MyFirstThread implements Runnable{
	private Thread t1;

	@Override
	public void run() {
		Thread t = new Thread(new MyFirstThread());
		t1 = new Thread(new MyFirstThread());
		
		System.out.println("t1 pid: " + t1.getId());
		
		System.out.println("t pid: " + t.getId());
	}

}
