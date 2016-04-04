package methods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ManyMethods {
	public static <T extends Comparable> T max(Collection<T> c)
	{
		if(c.isEmpty()) throw new NoSuchElementException();
		Iterator<T> iter = c.iterator();
		T largest = iter.next();
		while(iter.hasNext())
		{
			T next = iter.next();
			if(largest.compareTo(next) < 0)
				largest = next;
		}
		return largest;
	}
	
	//Returns all the items in a menu
	List<JMenuItem> getAllItems(JMenu menu)
	{
		List<JMenuItem> items = new ArrayList<>();
		for(int i = 0; i < menu.getItemCount(); i++)
			items.add(menu.getItem(i));
		return items;
	}
	

}
