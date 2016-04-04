package pair3;

public class PairTest3 {

	public static void main(String[] args) {
		Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
		Manager cfo = new Manager("Sid Sneaky", 60000, 2003, 12, 15);
		Pair<Manager> buddies = new Pair<>(ceo, cfo);
		printBuddies(buddies);
		
		ceo.setBonus(1000000);
		cfo.setBonus(500000);
		Manager[] managers = { ceo, cfo };
		Pair<Employee> result = new Pair<>();
		
		minmaxBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName() + ", second: " +
		result.getSecond().getName());
		System.out.println(x);
	}

}
