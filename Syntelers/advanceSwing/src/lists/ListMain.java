package lists;

import java.awt.Frame;

import javax.swing.JFrame;

public class ListMain {

	public static void main(String[] args) {
		JFrame frame = new ListFrame();
		frame.setTitle("List on Me");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
