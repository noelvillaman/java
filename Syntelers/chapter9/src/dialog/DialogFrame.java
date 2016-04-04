package dialog;

import java.awt.event.*;
import javax.swing.*;

public class DialogFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	private AboutDialog dialog;
	
	public DialogFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(dialog == null)
					dialog = new AboutDialog(DialogFrame.this);
				dialog.setVisible(true);
			}
		});
		fileMenu.add(aboutItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
	}
}
