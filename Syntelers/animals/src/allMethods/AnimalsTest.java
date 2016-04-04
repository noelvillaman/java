package allMethods;

public class AnimalsTest {

	public static void main(String[] args) {
		Animal mydog = new Dog();
		Animal mydove = new Dove();
		Animal myfish = new Fish();
		
		mydog.move();
		mydog.stand();
		mydog.talk();
		
		System.out.println();
		
		mydove.move();
		mydove.stand();
		mydove.talk();
		
		System.out.println();
		
		myfish.move();
		myfish.talk();
		myfish.stand();
	}

}
