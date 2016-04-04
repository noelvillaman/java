package interview;

public class TestInterview {

	public static void main(String[] args) {
		Interview n = new Interview();
		n.stateNames();
		//n.setStateCd();
		n.states();
		n.print();
		Interview.InputData data = n.new InputData("of", "jr");
	}
}
