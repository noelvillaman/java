package tree;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TreeMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new SimpleTreeFrame("Mutable Trees");
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);					
			}
			
		});
			
	}

}
