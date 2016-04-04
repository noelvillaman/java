package comboBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 24;
	
	public ComboBoxFrame()
	{
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		//make a combo box and add face names
		faceCombo = new JComboBox<>();
		faceCombo.addItem("serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		//the combo box listener changes the label font to the selected face
		//name
		faceCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
						Font.PLAIN, DEFAULT_SIZE));
				
			}
		});
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel, BorderLayout.SOUTH);
	}

}
