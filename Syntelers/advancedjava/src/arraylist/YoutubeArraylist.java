package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class YoutubeArraylist {

	public static void main(String[] args) {
		ArrayList mylist = new ArrayList();
		mylist.add("Noe");
		mylist.add("Joe");
		mylist.add("Morrel");
		
		Iterator iterator = mylist.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		//System.out.println(mylist);
	}

}
