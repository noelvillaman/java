package sizedFrame;

import java.awt.*;
import javax.swing.*;

public class SizedFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("Noel Villaman");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}


class SizedFrame extends JFrame
{
	public SizedFrame()
	{
		//get the screen dimensions
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		//set the frame width, height, and let platform pic screen location
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);
		//set frame icon
		Image img = new ImageIcon("icon.gif").getImage();
		setIconImage(img);
	}
}