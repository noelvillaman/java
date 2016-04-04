package treeRender;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class ClassNameTreeCellRenderer extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	private JTextField textField;
	private JTextArea textArea;
	
	public ClassTreeFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		root = new DefaultMutableTreeNode(java.lang.Object.class);
		model = new DefaultTreeModel (root);
		tree = new JTree(model);
		
		//add this class to populate the tree with some data
		addClass(getClass());
		
		//set up node icons
		ClassNameTreeCellRenderer renderer = new 
	}

}
