package tree;

import javax.swing.*;
import javax.swing.tree.*;

public class SimpleTreeFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleTreeFrame(String title){
		super(title);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//Set up tree model data
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Word");
		DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
		root.add(country);
		DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
		country.add(state);
		DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
		state.add(city);
		city = new DefaultMutableTreeNode("Cupertino");
		state.add(city);
		country = new DefaultMutableTreeNode("Germany");
		root.add(country);
		state = new DefaultMutableTreeNode("Schleswig-Holstein");
		country.add(state);
		city = new DefaultMutableTreeNode("Kiel");
		state.add(city);
		
		// construct tree and put it in a scroll pane
		JTree tree = new JTree(root);
		add(new JScrollPane(tree));
	}
}
