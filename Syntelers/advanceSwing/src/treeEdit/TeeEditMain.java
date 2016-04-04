package treeEdit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import tree.SimpleTreeFrame;

public class TeeEditMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				JFrame frame = new TreeEditFame("The List");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
