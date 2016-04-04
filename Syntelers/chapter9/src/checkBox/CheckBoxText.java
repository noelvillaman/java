package checkBox;

import java.awt.EventQueue;
import calculator.*;
import comboBox.ComboBoxFrame;
import radioButton.RadioButtonFrame;

import javax.swing.JFrame;
import circleLayout.CircleLayoutFrame;
public class CheckBoxText {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new JFrame();
				frame.setTitle("CheckBoxText");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CalculatorPanel  cal = new CalculatorPanel();
				//frame.add(cal);
				ComboBoxFrame comb = new ComboBoxFrame();
				//frame.add(comb);
				RadioButtonFrame radio = new RadioButtonFrame();
				//frame.add(radio);
				CircleLayoutFrame  circle = new CircleLayoutFrame();
				frame.add(circle);
				frame.setSize(800,500);
				frame.setVisible(true);
			}
		});
	}
}
