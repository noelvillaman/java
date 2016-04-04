package interview2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;

public class Interview {
	HashMap<String, Integer> stateCounts = new HashMap<String, Integer>();
	HashMap<String, String> codes = new HashMap<String, String>();
	List<InputData> inputList = new ArrayList<InputData>();

	public void stateNames() {
		codes.put("NY", "New York");
		codes.put("KY", "Kentucky");
		codes.put("TX", "Texas");
	}

	public void inputList() {

		inputList.add(new InputData("Mary Jane Smith", "TX"));
		inputList.add(new InputData("John Jones", "NY"));
		inputList.add(new InputData("Maddona", "NY"));
		inputList.add(new InputData("Mark Anthony Lewis", "KY"));
		inputList.add(new InputData("Sue Reae", "TX"));
		inputList.add(new InputData("Tim Oscar Steeler", "TX"));

	}

	public void stCounter() {
		int count = 0;
		Set<String> states = codes.keySet();
		for (String code : states) {
			for (InputData data : inputList) {
				if (code.equalsIgnoreCase(data.getStateCd()))
					count++;
			}
			stateCounts.put(code, count);
			count = 0;
		}

	}

	public void print() {
		//System.out.println("hoy");
		//System.out.println(codes.get("NY"));
		Set<Entry<String, String>> entries= codes.entrySet();
		
		for(Entry<String, String> entry : entries){
			System.out.println(entry.getValue() + " (" + stateCounts.get(entry.getKey()) + ")");
			for(InputData data : inputList){
				if(entry.getKey().equals(data.getStateCd()))
					System.out.println("\t" + data.getFullName());
			}
		}
			
	}

	final class InputData {
		private String fullName, stateCd;

		public InputData(String fullName, String stateCd) {
			this.fullName = fullName;
			this.stateCd = stateCd;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getStateCd() {
			return stateCd;
		}

		public void setStateCd(String stateCd) {
			this.stateCd = stateCd;
		}

		@Override
		public String toString() {
			return "InputData" + fullName + ", " + stateCd;
		}

	}
}
