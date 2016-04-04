package dialog;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class TestDialog {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new DialogFrame();
				frame.setTitle("CheckBoxText");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
