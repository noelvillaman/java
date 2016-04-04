package treeRender;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class ClassTreeFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	private JTextField textField;
	private JTextArea textArea;
	
	public ClassTreeFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//THE ROOT OF THE CLASS TREE IS object
		root = new DefaultMutableTreeNode(java.lang.Object.class);
		model = new DefaultTreeModel(root);
		tree = new JTree(model);
		
		//add this class populate the tree with some data
		addClass(getClass());
		
		//set up node icons
		ClassNameTreeCellRenderer renderer = new ClassNameTreeCellRenderer();
		renderer.setClosedIcon(new ImageIcon(getClass().getResource("yellow-ball.gif")));
		renderer.setLeaffIcon(new ImageIcon(getClass().getResource("blue-ball.gif")));
		tree.setCellRenderer(renderer);
		
		//set up selection mode
		tree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent event){
				//the user selected a different node -- update descripi
				TreePath path = tree.getSelectionPath();
				if(path == null)
					return;
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)path.getLastPathComponent();
				Class<?> c = (Class<?>) selectedNode.getUserObject();
				String description = getFieldDescription(C);
				textArea.setText(description);
			}
		});
		int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
		tree.getSelectionModel().setSelectionMode(mode);
		
		//this text area holds the class desdcription
		textArea = new JTextArea();
		
		//add tree and text area
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(new JScrollPane(tree));
		panel.add(new JScrollPane(textArea));
		add(panel, BorderLayout.CENTER);
		addTextField();
	}
	
	public void addTextField()
	{
		JPanel panel = new JPanel();
		ActionListener addListener = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//add the class whose name is in the next field
				try
				{
					String text = textField.getText();
					addClass(Class.forName(text));
					//clear test field to indicate success
					textField.setText("");
				} catch(ClassNotFoundException ce){
					JOptionPane.showMessageDialog(null, "Class not found");
				}
			}
		};
		
		//new class names are typed into this field
		textField = new JTextField(20);
		textField.addActionListener(addListener);
		panel.add(textField);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(addListener);
		panel.add(addButton);
		add(panel, BorderLayout.SOUTH);
	}
	
	@SuppressWarnings("unchecked")
	public DefaultMutableTreeNode findUserObject(Object obj)
	{
		//find the node containing a user object
		Enumeration<TreeNode> e = (Enumeration<TreeNode>) root.breadthFirstEnumeration();
		while(e.hasMoreElements()){
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
			if(node.getUserObject().equals(obj)) return node;
		}
		return null;
	}
	
	public DefaultMutableTreeNode addClass(Class<?> c){
		//add a new class to the tree
		//skip non-class types
		if(c.isInterface() || c.isPrimitive()) return null;
		
		//if the class is already in the tree, return its node
		DefaultMutableTreeNode node = findUserObject(c);
		if(node != null) return node;
		
		//class isn't present--first
		
	}
	
	@SuppressWarnings("unchecked")
	public DefaultMutableTreeNode findUserObject(Object obj)
	{
		//find the node containing a user object
		Enumeration<TreeNode> e = (Enumeration<TreeNode>) root.breadthFirstEnumeration();
		while(e.hasMoreElements())
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
			if (node.getUserObject().equals(obj)) return node;
		}
		return null;
	}
	
	public DefaultMutableTreeNode addClass(Class<?> c)
	{
		//add a new classto the tree
		//skip non-class types
		if(c.isInterface() || c.isPrimitive()) return null;
		
		//if the class is already in the tree, return its node
		DefaultMutableTreeNode node = findUserObject(c);
		if(node != null) return node;
		
		//class isn't present -- first add class parent recusirvely
		Class<?> s = c.getSuperclass();
		DefaultMutableTreeNode parent;
		if(s == null) parent = root;
		else parent = addClass(s);
		
		//add the class as a child to the parent
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(c);
		model.insertNodeInto(newNode, parent, parent.getChildCount());;
		//make node vavible
		TreePath path = new TreePath(model.getPathToRoot(newNode));
		tree.makeVisible(path);
		
		return newNode;
	}
	
	public static String getFieldDescription(Class<?> c)
	{
		//use reflection to find types and names of fields
		StringBuilder r = new StringBuilder();
		Field[] fields = c.getDeclaredFields();
		for(int i = 0; i < fields.length; i++){
			Field f = fields[i];
			if((f.getModifiers() & Modifier.STATIC) != 0)
				r.append("static");
			r.append(f.getType().getName());
			r.append(" ");
			r.append(f.getName());
			r.append("\n");
		}
		return r.toString();
	}

}
