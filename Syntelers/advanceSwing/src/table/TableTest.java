package table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TableTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new PlaneTableFrame();
				frame.setTitle("TableTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class PlaneTableFrame extends JFrame{
	private String[] columnNames = {"Planet", "Radius", "Moons", "Gaseous", "Color"};
	private Object[][] cells = {{"Mecury", 2440.0, 0, false, Color.YELLOW}, 
			{"Venus", 6052.0, 1, false, Color.YELLOW}, {"Earth", 6397.0, 1, false, Color.BLUE},
			{"Mars", 3397.0, 2, false, Color.RED},{"Jupiter", 71492.0, 18, true, Color.ORANGE},
			{"Saturn", 60268.0, 17, false, Color.BLUE}, {"Uranus", 25559.0, 17, true, Color.BLUE},
			{"Pluto", 1137.0, 1, false, Color.BLACK}};
	
	public PlaneTableFrame()
	{
		final JTable table = new JTable(cells, columnNames);
		table.setAutoCreateRowSorter(true);
		add(table, BorderLayout.CENTER);
		JButton printButton = new JButton("Print");
		printButton.addActionListener(EventHandler.create(ActionListener.class, table, "print"));
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(printButton);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
}