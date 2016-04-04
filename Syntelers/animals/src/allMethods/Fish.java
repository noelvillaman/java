package allMethods;

public class Fish implements Animal{

	@Override
	public void talk() {
		System.out.println("Fish do not talk");
		
	}

	@Override
	public void move() {
		System.out.println("The fish is moving A to B");
		
	}

	@Override
	public void stand() {
		System.out.println("The fish is on its tail");
	}

}
