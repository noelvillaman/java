package org.villaman.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<Integer> future = executor.submit(new Callable<Integer>(){
			@Override
			public Integer call() throws Exception{
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				System.out.println("Starting ...");
				try{
					Thread.sleep(duration);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
				
				System.out.println("Finished.");
				
				return duration;
			}
		});
		
		executor.shutdown();
		
		System.out.println("Result is: " +future.get());
		}
}
