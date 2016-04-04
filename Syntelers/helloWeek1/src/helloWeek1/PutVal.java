package helloWeek1;

import java.util.HashMap;
import java.util.Map;

public class PutVal {
	public static void main(String[] args) {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	map.put("cj", 1);
	map.put("cj", 2);
	
	System.out.println(map.get("cj"));
	}
}
