package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public void listNames(){
	List<String> names = new ArrayList<String>();
	
	names.add("Noel");
	names.add("Pedro");
	names.add("Comesolo");
	names.add("Fernandez");
	names.add("Leonel");
	names.add("Ladron");
	names.add("Danilo");
	names.add("De los mios");
	
	for(String pedo : names)
		System.out.println(pedo);
	
	}
}
