package circleLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CircleLayoutFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CircleLayoutFrame()
	{
		setLayout(new CircleLayout());
		add(new JButton("Yello"));
		add(new JButton("Blue"));
		add(new JButton("Red"));
		add(new JButton("Green"));
		add(new JButton("Orange"));
		add(new JButton("Fuchsia"));
		add(new JButton("Indigo"));
	}
}
