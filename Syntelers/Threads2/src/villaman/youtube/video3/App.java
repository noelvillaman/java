package villaman.youtube.video3;

public class App {

	private int count = 0;
	
	public synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		App ap1 = new App();
		ap1.doWork();

	}
	
	public void doWork(){
		Thread td1= new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i <= 10000; i++){
					increment();
				}
			}
			
		});
		
		Thread td2= new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i <= 10000; i++){
					increment();
				}
			}
			
		});
		
		td1.start();
		td2.start();
		
		try{
			td1.join();
			td2.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
	}

}
