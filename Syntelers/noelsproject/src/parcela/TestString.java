package parcela;

public class TestString {
	static StringBuilder s = new StringBuilder();
	public static void myString(String mia)
	{
		String p;
		int[] n;
		String[] sp;
		String[] parts = mia.split(" ");
		for(int i = 0; i < mia.length(); i++){
			if(Character.isLetter(parts[i].charAt(0)))
			{
				p = parts[i];
				s.append(p);
			}
		}
	}

}
