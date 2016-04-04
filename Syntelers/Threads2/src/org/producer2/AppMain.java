package org.producer2;

public class AppMain {

	public static void main(String[] args) throws InterruptedException {
		final Producer processor = new Producer();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try{
					processor.producer();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					processor.producer();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
