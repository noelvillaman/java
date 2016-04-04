package com.villaman.thread101;

public class MainTest {

	public static void main(String[] args) {
		MyFirstThread t1 = new MyFirstThread();
		t1.run();
		MyFirstThread t2 = new MyFirstThread();
		t2.run();
	}

}
