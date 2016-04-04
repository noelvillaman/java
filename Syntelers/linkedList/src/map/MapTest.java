package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("884-23-5663", new Employee("Francesca Cruz"));
		
		System.out.println(staff);
		
		//remove an entry
		staff.remove("144-25-5464");
		
		//replace an entry
		staff.put("456-62-5527", new Employee("Francesca Miller"));
		
		//look up a value
		System.out.println(staff.get("157-62-7935"));
		
		//iterate through all entries
		for(Map.Entry<String, Employee> entry : staff.entrySet())
		{
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key=" + key + ", value=" + value.toString());
		}
	}

}
