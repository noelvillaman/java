package swingprojects;


import javax.swing.JFrame;
import java.awt.EventQueue;

public class SimpleEx extends JFrame{
	
	public SimpleEx()
	{
		unitUI();
	}
	
	

	private void unitUI() {
		setTitle("My first Page");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				SimpleEx ex = new SimpleEx();
				ex.setVisible(true);
			}
		});
	}

}
