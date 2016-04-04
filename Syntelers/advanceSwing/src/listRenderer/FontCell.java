package listRenderer;

import java.awt.*;
import javax.swing.*;

public class FontCell extends JComponent implements ListCellRenderer<Font> {

	private Font font;
	private Color background;
	private Color foreground;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Font> 
	list, Font value, int index, boolean isSelected,
			boolean cellHasFocus) {
		font = value;
		background = isSelected ? list.getSelectionBackground() : list.getBackground();
		foreground = isSelected ? list.getSelectionBackground() : list.getBackground();
		return this;
	}
	
	public void paintComponent(Graphics g)
	{
		String text = font.getFamily();
		FontMetrics fm = g.getFontMetrics(font);
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(foreground);
		g.setFont(font);
		g.drawString(text, 0, fm.getAscent());
	}
	
	public Dimension getPreferredSize()
	{
		String text = font.getFamily();
		Graphics g = getGraphics();
		FontMetrics fm = g.getFontMetrics(font);
		return new Dimension(fm.stringWidth(text), fm.getHeight());
	}
	
}
