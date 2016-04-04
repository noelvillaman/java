package dialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutDialog extends JDialog {
	public AboutDialog(JFrame owner)
	{
		super(owner, "About DialogTest", true);
		add(new JLabel(
				"<html><h1><i>Core Java</i></h1><hr>By Noel Villaman</html>"
				), BorderLayout.CENTER);
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();
	}

}
