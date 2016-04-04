package optionDialog;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class OptionDialogFrame extends JPanel {
	private ButtonPanel typePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel optionTypePanel;
	private ButtonPanel optionPanel;
	private ButtonPanel inputPanel;
	private String messageString = "Message";
	private Icon messageIcon = new ImageIcon("blue-ball.gig");
	private Object messageObject = new Date();
	private Component messageComponent = new SampleComponent();

	public OptionDialogFrame() 
	{
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2, 3));
		typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
		messageTypePanel = new ButtonPanel("Message Type", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE",
				"QUESTION_MESSAGE", "PLAIN_MESSAGE");
		messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other", "Other", "Object[]");
		optionTypePanel = new ButtonPanel("Corfirm", "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION");
		optionPanel = new ButtonPanel("Option", "String[]", "Icon[]", "Object[]");
		inputPanel = new ButtonPanel("Input", "Text field", "Combo box");

		gridPanel.add(typePanel);
		gridPanel.add(messageTypePanel);
		gridPanel.add(messagePanel);
		gridPanel.add(optionTypePanel);
		gridPanel.add(inputPanel);

		// add a panel with show button
		JPanel showPanel = new JPanel();
		JButton showButton = new JButton("Show");
		showButton.addActionListener(new ShowAction());
		showPanel.add(showButton);
		add(gridPanel, BorderLayout.CENTER);
		add(showPanel, BorderLayout.SOUTH);
	}

	public Object getMessage() {
		String s = messagePanel.getSelection();
		if (s.equals("String"))
			return messageString;
		else if (s.equals("Icon"))
			return messageIcon;
		else if (s.equals("Component"))
			return messageComponent;
		else if (s.equals("Object[]"))
			return new Object[] { messageString, messageIcon, messageComponent, messageObject };
		else if (s.equals("Other"))
			return messageObject;
		else
			return null;
	}

	public Object[] getOptins() {
		String s = optionPanel.getSelection();
		if (s.equals("String[]"))
			return new String[] { "Yellow", "Blue", "Red" };
		else if (s.equals("Icon[]"))
			return new Icon[] { new ImageIcon("yellow-ball.gif"), new ImageIcon("blue-ball.gif"),
					new ImageIcon("red-ball.gif"), new ImageIcon("red-ball.gif") };
		else if (s.equals("Object[]"))
			return new Object[] { messageString, messageIcon, messageComponent, messageObject };
		else
			return null;
	}

	public int getType(ButtonPanel panel) {
		String s = panel.getSelection();
		try {
			return JOptionPane.class.getField(s).getInt(null);
		} catch (Exception e) {
			return -1;
		}
	}

	private class ShowAction implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) {
			if (typePanel.getSelection().equals("Confirm"))
				JOptionPane.showConfirmDialog(OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
						getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Input")) {
				if (inputPanel.getSelection().equals("Text field"))
					JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title",
							getType(messageTypePanel));
				else
					JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title",
							getType(messageTypePanel), null, new String[] { "Yellow", "Blue", "Red" }, "Blue");
			} else if (typePanel.getSelection().equals("Message"))
				JOptionPane.showMessageDialog(OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
			else if (typePanel.getSelection().equals("Options"))
				JOptionPane.showOptionDialog(OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
						getType(messageTypePanel), null, getOptions(), getOptions()[0]);
		}

		private Object[] getOptions() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	class SampleComponent extends JComponent {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
			g2.setPaint(Color.YELLOW);
			g2.fill(rect);
			g2.setPaint(Color.BLUE);
			g2.draw(rect);
		}

		public Dimension getPreferredSize() {
			return new Dimension(10, 10);
		}
	}
}