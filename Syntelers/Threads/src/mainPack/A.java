package mainPack;

public class A extends Thread {
	public void run(){
		System.out.println("Thread A started");;
		for (int i = 1; i <= 4; i++){
			System.out.println("\t From ThreadA: i= " +i);
		}
		System.out.println("Exit from A");
	}
}

class B extends Thread{
	public void run(){
		System.out.println("Thread B started");
		for(int j = 1; j <=4; j++){
			System.out.println("\t From ThreadB: j= "+j);
		}
		System.out.println("Exit from B");
	}
}

class C extends Thread {
	public void run(){
		System.out.println("Thread C started");
		for(int k = 1; k <=4; k++){
			System.out.println("\t From ThreadC: k= "+k);
		}
		System.out.println("Exit from C");
	}
}
