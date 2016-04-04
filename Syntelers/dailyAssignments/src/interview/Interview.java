package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Interview {
	private static HashMap<String, Integer> stateCd;
	private static HashMap<String, String> stateNames;
	private static List<InputData> inputList;

	

	public void stateNames() {

		InputData data = new InputData("Noel Villaman", "MA");
		InputData data1 = new InputData("Charles Tires", "NY");
		InputData data2 = new InputData("Teza Perez", "WA");
		InputData data3 = new InputData("Morrel Santiago", "MA");
		InputData data4 = new InputData("Cornelius Brickford", "GA");

		inputList = new ArrayList<InputData>();

		inputList.add(data);
		inputList.add(data1);
		inputList.add(data2);
		inputList.add(data3);
		inputList.add(data4);

		// Iterator iterator = inputList.iterator();
		// while(iterator.hasNext())
		// System.out.println(iterator.next());
	}

	public void states() {
		stateNames = new HashMap<String, String>();
		stateNames.put("NY", "New York");
		stateNames.put("MA", "Massachussets");
		stateNames.put("GA", "Georgia");
		stateNames.put("TX", "Texas");

		// Iterator it = stateNames.entrySet().iterator();
		// while(it.hasNext())
		// System.out.println(it.next());

		// Iterator iterator = inputList.iterator();
		// while (iterator.hasNext())
		// System.out.println(iterator.next());

	}

	public void print() {
		for (Map.Entry<String, String> entry : stateNames.entrySet()) {
			System.out.println(entry.getValue() + " " + stateCd.get(3));
			for (Map.Entry<String, Integer> map1 : stateCd.entrySet())
				System.out.println(" " + entry.getKey() + " " + stateCd.get(2));
		}
	}

	public final class InputData {
		private String fullName;
		private String stateCd;

		public InputData(String fullName, String stateCd) {
			super();
			this.fullName = fullName;
			this.stateCd = stateCd;
		}
		
		public void stateNames() {

			InputData data = new InputData("Noel Villaman", "MA");
			InputData data1 = new InputData("Charles Tires", "NY");
			InputData data2 = new InputData("Teza Perez", "WA");
			InputData data3 = new InputData("Morrel Santiago", "MA");
			InputData data4 = new InputData("Cornelius Brickford", "GA");

			inputList = new ArrayList<InputData>();

			inputList.add(data);
			inputList.add(data1);
			inputList.add(data2);
			inputList.add(data3);
			inputList.add(data4);

			// Iterator iterator = inputList.iterator();
			// while(iterator.hasNext())
			// System.out.println(iterator.next());
		}
		
		

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getStateCard() {
			return stateCd;
		}

		public void setStateCard(String stateCard) {
			this.stateCd = stateCard;
		}

		public void accumulate(List<InputData> inputList) {
			for (int i = 0; i < inputList.size() - 1; i++)
				inputList.get(i);
		}

		@Override
		public String toString() {
			return fullName + ", " + stateCd;
		}

	}
}
