package longList;

import javax.swing.*;

public class WordListModel extends AbstractListModel<String> {
	private int length;
	public static final char FIRST = 'A';
	public static final char LAST = 'Z';
	
	public WordListModel(int n)
	{
		length = n;
	}
	
	public int getSize()
	{
		return (int) Math.pow(LAST - FIRST + 1,	length);
	}
	
	public String getElementAt(int n)
	{
		StringBuilder r = new StringBuilder();
		for(int i = 0; i < length; i++)
		{
			char c = (char) (FIRST + n % (LAST - FIRST + 1));
			r.insert(0, c);
			n = n / (LAST - FIRST + 1);
		}
		return r.toString();
	}
}
