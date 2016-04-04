package circleLayout;

import java.awt.*;

public class CircleLayout implements LayoutManager{
	private int minWidth = 0;
	private int minHeight = 0;
	private int preferredWidth =0;
	private int preferredHeight = 0;
	private boolean sizesSet = false;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;

	@Override
	public void addLayoutComponent(String name, Component comp) {
		
	}

	@Override
	public void layoutContainer(Container comp) {
		
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		setSizes(parent);
		Insets inserts = parent.getInsets();
		int width = minWidth + inserts.left + inserts.right;
		int height = minHeight + inserts.top + inserts.bottom;
		
		return new Dimension(width, height);
	}

	private void setSizes(Container parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		if(sizesSet) return null;
		int n = parent.getComponentCount();
		
		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;
		//compute the maximum component widths and heights
		//and set the preferred size to the sum of the component
		//sizes.
		for(int i  = 0; i < n; i++)
		{
			Component c = parent.getComponent(i);
			if(c.isVisible())
			{
				Dimension d = c.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentWidth, d.width);
				maxComponentHeight = Math.max(maxComponentHeight, d.height);
				preferredWidth += d.width;
				preferredHeight += d.height;
			}
		}
			minWidth = preferredWidth / 2;
			minHeight =preferredHeight /2;
			sizesSet = true;
			return null;
	}

	@Override
	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}

}
