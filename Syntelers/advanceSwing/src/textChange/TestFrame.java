package textChange;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import tree.SimpleTreeFrame;

public class TestFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new ColorFrame("Set Background");
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);					
			}
			
		});
	}

}
