package treetSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 2345));
		parts.add(new Item("Modem", 3456));
		parts.add(new Item("Mixin", 4567));

		System.out.println(parts);

		SortedSet<Item> sortedByDescription = new TreeSet<>(new Comparator<Item>() 
		{
			public int compare(Item a, Item b) 
			{
				String descrA = a.getDescription();
				String descrB = b.getDescription();
				return descrA.compareTo(descrB);
			}
		});
		
		sortedByDescription.addAll(parts);
		System.out.println(sortedByDescription);
	}

}
