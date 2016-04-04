package hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Details {

	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HahsMap */
		hmap.put(12, "Come here");
		hmap.put(2, "Rahul");
		hmap.put(7, "Go there");
		hmap.put(49, "Mario");
		hmap.put(55, "Morrel");

		Set set = hmap.entrySet();

		Iterator iter = set.iterator();

		while (iter.hasNext()) {
			Map.Entry mentry = (Map.Entry) iter.next();
			System.out.println(mentry.getKey());
			if(mentry.getKey().equals(7)){
				mentry.getValue().equals("Vete");
				System.out.println(mentry.getValue());
			}
			System.out.println(mentry.getValue());
		}
	}

}
