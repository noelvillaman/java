package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame{
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//create button
		JButton yellowButton = new JButton("Yello");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		buttonPanel = new JPanel();
		
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		//add a panel to frame
		add(buttonPanel);
		
		//create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	private class ColorAction implements ActionListener {
		private Color backgroundcolor;
		
		public ColorAction(Color c)
		{
			backgroundcolor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			buttonPanel.setBackground(backgroundcolor);
		}
	}
	
	public void makeButton(String name, Color backgroundColor)
	{
		JButton button = new JButton(name);
		buttonPanel.add(button);
		ColorAction action = new ColorAction(backgroundColor);
		button.addActionListener(action);
	}
	

	public static void main(String[] args) {
		
	}

}
