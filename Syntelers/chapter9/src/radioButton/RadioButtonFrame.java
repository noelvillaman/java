package radioButton;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class RadioButtonFrame extends JPanel{
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;

	public RadioButtonFrame() {
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		buttonPanel = new JPanel();
		group = new ButtonGroup();

		addRadioButton("small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra Large", 36);

		add(buttonPanel, BorderLayout.SOUTH);
		//pack();
	}

	private void addRadioButton(String name, final int size) {
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name, selected);
		group.add(button);
		buttonPanel.add(button);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				label.setFont(new Font("Serif", Font.PLAIN, size));
			}
		};
		button.addActionListener(listener);
	}
}
