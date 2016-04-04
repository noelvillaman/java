package org.villaman.thread.semaphores;

public class Connection {
	
	private static Connection instance = new Connection();
	private Connection(){
		
	}
	
	public static Connection getIntance(){
		return instance;
	}

}
