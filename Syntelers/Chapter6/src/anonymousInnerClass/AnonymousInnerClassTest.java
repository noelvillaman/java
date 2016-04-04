package anonymousInnerClass;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		JOptionPane.showConfirmDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	public void start(int interval, final boolean beep) {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
