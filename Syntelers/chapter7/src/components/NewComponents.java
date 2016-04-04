package components;
import javax.swing.*;
import java.awt.*;

public class NewComponents {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable()
				{
					public void run()
					{
						JFrame frame = new NewComponentsFrame();
						frame.setTitle("Noel Villaman");
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
						
					}
				});
	}
}

class NewComponentsFrame extends JFrame
{
	public NewComponentsFrame()
	{
		add(new NewJcomponents());
	}
}

class NewJcomponents extends JComponent
{
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g)
	{
		g.drawString("Not a Way to start Cruel World pogram", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
}