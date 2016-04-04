package runnable;

public class RunnableDemo implements Runnable {
	private Thread it;
	private String threadName;
	
	RunnableDemo(String name)
	{
		this.threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try{
			for(int i = 4; i > 0; i--){
				//Let the thread sleep for a while
				Thread.sleep(50);
			}
		}catch (InterruptedException e){
			System.out.println("Thread " + threadName + " interrpted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	public void start()
	{
		System.out.println("Staring " + threadName);
		if(it == null)
		{
			it = new Thread(this, threadName);
			it.start();
		}
	}
}