import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class AdminTwitter  {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JPanel topPanel1;
	private JPanel topPanel2;
	private JPanel midPanel;
	private JPanel bottomPanel1;
	private JPanel bottomPanel2;

	private JTextField userIDTextField;
	private JTextField groupIDTextField;

	private JLabel userIDLabel;
	private JLabel groupIDLabel;
	private Button userAddBtn;
	private Button groupAddBtn;
	private Button userViewBtn;
	private Button totalUserBtn;
	private Button totalGroupBtn;
	private Button totalMsgBtn;
	private Button positiveWordBtn;
	
	private UserComponent currentNode;
	private User user;
	private User currentUserNode;
	private GroupUser group;
	private GroupUser rootGroup;
	private GroupUser currentGroupUserNode;

	private JTree treeView;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode parentNode;
	private DefaultMutableTreeNode node;
	private DefaultTreeModel treeModel;
	private TreePath parentPath;
	
	private int xBtn = 180;
	private int yBtn = 55;
 
	/***************************
	 * Launch the application.
	 ***************************/
	public void AdminWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdminTwitter window = new AdminTwitter();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/******************************
	 * Create the application.
	 *****************************/
	public AdminTwitter() {
		initialize();
		
	}

	/**************************************
	 * Initialize the contents of the frame.
	 **************************************/
	private void initialize() {
		
	
		frame = new JFrame("Mini Twitter by Hetal Sakaria");
		frame.setSize(450, 450);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		/*****************************************************
		 * mainPanel- contains two sub panels (rightPanel and
		 * 				leftPanel)
		 ****************************************************/
		//mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.gray,10));
		
		

			/*****************************************************
			 * rightPanel- contains treeView and added to mainPanel
			 ****************************************************/ 

			rightPanel = new JPanel(new BorderLayout());
			rightPanel.setBackground(Color.DARK_GRAY);
			rightPanel.setPreferredSize(new Dimension(200,450));
			rightPanel.setOpaque(true);
			
	//			root = new DefaultMutableTreeNode("Root");
				rootGroup = new GroupUser();
				rootGroup.setGroup("CS356", null);
				//rootGroup.toString();
				root = new DefaultMutableTreeNode(rootGroup);
				
				treeModel = new DefaultTreeModel( root );
				
					treeView = new JTree(treeModel);
					treeView.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
					treeView.setBackground(Color.DARK_GRAY);
					treeView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
					treeView.setBackground(Color.darkGray);
					
				
			 /************************************************************************************************
			  * Listen to selected node in the tree
			  ************************************************************************************************/
			 treeView.addTreeSelectionListener(new TreeSelectionListener(){

				@Override
				public void valueChanged(TreeSelectionEvent e) {
//			
					
					node = (DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
					parentPath = treeView.getSelectionPath();
					parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
					
//					if (node == null) {
//						return;
//					}
					
//					Object selectedNode = node.getUserObject();
//					//  ???????????? //
//					System.out.println("Selected User " + selectedNode);
//					
//					if (selectedNode instanceof User) {
//						currentNode = (User) selectedNode;
//					} 
//					else if (selectedNode instanceof GroupUser) {
//						currentNode = (GroupUser) selectedNode;
//					}
				}
			 });
			 JScrollPane treeScrollPane = new JScrollPane(treeView);
			 treeScrollPane.setPreferredSize(new Dimension(200,450));
//			 rightPanel.add(new JScrollPane(treeView ), BorderLayout.WEST);
			 rightPanel.add(treeScrollPane, BorderLayout.WEST);
			 mainPanel.add(rightPanel, BorderLayout.WEST);
				
			
			/*********************************************************************************************
			 * leftPanel- contains three subpanels, top, mid, and
			 * 			bottomPanel.
			 * 			topPanel contains userIdTextArea, userAddBtn,
			 * 			groupIDTextArea, and groudAddBtn
			 * 			midPanel contains userViewBtn
			 * 			bottomPanel contains four buttons which 
			 * 			display the statistics.
			 * 			leftPanel added to mainPanel.***
			 *********************************************************************************************/
			//leftPanel = new JPanel(new GridLayout(3,1));
			 leftPanel = new JPanel(new FlowLayout());
			 	
				leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,10));
				leftPanel.setOpaque(true);
				leftPanel.setBackground(Color.darkGray);
				leftPanel.setPreferredSize(new Dimension(410,450));
				
				topPanel1 = new JPanel(new FlowLayout());
					topPanel1.setOpaque(true);
					topPanel1.setBackground(Color.darkGray);
					//userIDLabel = new JLabel("UserID:");
					//topPanel.add(userIDLabel);
					userIDLabel = new JLabel();
						userIDLabel.setText("UserID: " );
						userIDLabel.setForeground(Color.cyan);
					
						/*******************************************************************************
						 *userIDTextArea
						 *******************************************************************************/
						userIDTextField = new JTextField(15);
							
//							userIDTextField.setBackground(UIManager.getColor("Slider.background"));
							userIDTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							userIDTextField.setForeground(Color.darkGray);
							userIDTextField.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
							userIDTextField.setFocusable(true);
							
							
							/*********************************************************************************
							 * userAddBtn
							 ********************************************************************************/
							userAddBtn = new Button();
							userAddBtn.setLabel("Add User");
							userAddBtn.setPreferredSize(new Dimension(120,45));
								
								/*****************************************************************************
								 * Add User Button ActionListener
								 * If node is not selected or textfield is empty, It throws a warning message.
								 * else a user gets added to chosen parent node.
								 *****************************************************************************/
								userAddBtn.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										
									String	id = userIDTextField.getText();
								
									// check if node is selected or not??
									
									DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
										if(!id.equals("") && node != null){
											
											/************************************************
											 * The following loop checks if the selected user
											 * is a GroupID or a Root. If selected node is a
											 * instanceof a GroupUse then that GroupID = root
											 * and check if user exist from that node. Not from
											 * the root.
											 ***********************************************/
											
											Object thisUser = node.getUserObject();
										 
											if( thisUser instanceof GroupUser){
												
												root = node;
											}
									
											addNewUser(id, root);
											userIDTextField.setText("");
										}
										else{
											
											displayWarningMessage("Please enter UseID or Parent node is not selected");
											
										}
									}
								});
								
							topPanel1.add(userIDLabel);		
							topPanel1.add(userIDTextField);	
							topPanel1.add(userAddBtn);
						
						leftPanel.add(topPanel1, BorderLayout.NORTH);
							 	
						topPanel2 = new JPanel(new FlowLayout());
							topPanel2.setOpaque(true);
							topPanel2.setBackground(Color.darkGray);
						
							groupIDLabel = new JLabel();
								groupIDLabel.setText("GroupID:");
								groupIDLabel.setForeground(Color.cyan);
						
							/*********************************************************************************
							 *groupIDTextArea
							 ********************************************************************************/
						
							groupIDTextField = new JTextField(15);
							groupIDTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							groupIDTextField.setForeground(Color.DARK_GRAY);
							groupIDTextField.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
						
							/*****************************************************
							 * groupAddBtn
							 ****************************************************/		
							groupAddBtn = new Button();
							groupAddBtn.setLabel("Add Group");
							groupAddBtn.setPreferredSize(new Dimension(120,45));
							
							/************************************************
							 * ActionListener
							 ***********************************************/
							groupAddBtn.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
									
									String	id = groupIDTextField.getText();
									DefaultMutableTreeNode node = 
											(DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();

								
									if(!id.equals("") && node != null){
										
										addNewGroupUser(id);
										groupIDTextField.setText("");

									}
									else{
										displayWarningMessage("Please enter GroupUseID or Parent node is not selected");
									}
								}
							});
							
			
					topPanel2.add(groupIDLabel);		
					topPanel2.add(groupIDTextField);	
					topPanel2.add(groupAddBtn);
					leftPanel.add(topPanel2, BorderLayout.NORTH);
				 
				midPanel =  new JPanel(new BorderLayout());
				
					midPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					midPanel.setBackground(Color.DARK_GRAY);
					midPanel.setOpaque(true);
//					midPanel.setPreferredSize(new Dimension(350,100));
					/*****************************************************
					 * userViewBtn - Display UserUI
					 ****************************************************/		
					userViewBtn = new Button();
						userViewBtn.setBackground(Color.CYAN);
						userViewBtn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
						userViewBtn.setForeground(Color.BLACK);
						userViewBtn.setLabel("Open User View");

						userViewBtn.setPreferredSize(new Dimension(300,60));
						/**********************************************************
						 *when UserViewBtn gets trigger, it will instantiate UserUI
						 *and display userTwitterUI using Singleton Pattern
						 **********************************************************/
						userViewBtn.addActionListener(new ActionListener(){
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								DefaultMutableTreeNode model = 
										(DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
								String userID = model.getUserObject().toString();
								
								UserTwitterUI.getUserTwitterInstance().UserTwitter(userID); 
								
							}
						});
						
					midPanel.add(userViewBtn, BorderLayout.CENTER);
				leftPanel.add(midPanel);

				bottomPanel1 = new JPanel(new FlowLayout());
				bottomPanel1.setBackground(Color.DARK_GRAY);
					/*****************************************************
					 * totalUserBtn
					 ****************************************************/	
					totalUserBtn = new Button();
						totalUserBtn.setPreferredSize(new Dimension(xBtn, yBtn));
						totalUserBtn.setForeground(SystemColor.controlHighlight);
						totalUserBtn.setLabel("Show User Total");
					totalGroupBtn = new Button();
						totalGroupBtn.setPreferredSize(new Dimension(xBtn, yBtn));
						totalGroupBtn.setForeground(SystemColor.controlHighlight);
						totalGroupBtn.setLabel("Show Group Total");
					
				
					bottomPanel1.add(totalUserBtn);
			    	bottomPanel1.add(totalGroupBtn);
			    leftPanel.add(bottomPanel1, BorderLayout.NORTH);
			    
			    	bottomPanel2 = new JPanel(new FlowLayout());
			    	bottomPanel2.setBackground(Color.DARK_GRAY);
			    	
					totalMsgBtn = new Button();
						totalMsgBtn.setPreferredSize(new Dimension(xBtn, yBtn));
						totalMsgBtn.setForeground(UIManager.getColor("RadioButton.select"));
						totalMsgBtn.setLabel("Show Total Messages");
					positiveWordBtn = new Button();
						positiveWordBtn.setPreferredSize(new Dimension(xBtn, yBtn));
						positiveWordBtn.setForeground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
						positiveWordBtn.setLabel("Show Positive%");
					
			    	bottomPanel2.add(totalMsgBtn);
			    	bottomPanel2.add(positiveWordBtn);
			   leftPanel.add(bottomPanel2, BorderLayout.NORTH);
		    	
			 mainPanel.add(leftPanel);
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null); /* location center */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void displayWarningMessage(String warningMsg) {
		
		JOptionPane.showMessageDialog(frame, warningMsg,	
				"Warning", JOptionPane.WARNING_MESSAGE);
		
	}

	/********************************************************
	 * Add a new GroupUser
	 ********************************************************/
	
	protected void addNewGroupUser(String groupId) {
		
		if(IsUserExists(groupId, root)){
			JOptionPane.showMessageDialog (frame, "Group User already exists!", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			
			GroupUser pgroupUser = group;
			group=new GroupUser();
		
			if(getParentGroup().equals(null)){
				group.setGroup(groupId, pgroupUser);
			}
			else{
				group.setGroup(groupId, (GroupUser)getParentGroup());
			}
						
			addObject(group.getGroupID(), group);
			
			
			//accept???
			
			
		}
	}
	
	/********************************************************
	 * Add a new User
	 ********************************************************/
	
	public void addNewUser(String userId, DefaultMutableTreeNode root){
		
		if(IsUserExists(userId, root)){
			JOptionPane.showMessageDialog (frame, "User already exists.", "Message", JOptionPane.INFORMATION_MESSAGE);

		}
		else{
			user = new User();
			group = getSelectedGroupUserNode();
			user.addUser(user, userId, group.getGroupID());
			group.addUserToGroup(user);
			addObject(user.getUserID(), user);
			
			//user.accept(AdminVisitor);
					
		
		}
		
	}
	
	
	public DefaultMutableTreeNode addObject(String name, Object child) {
		parentNode = null;
		parentPath = treeView.getSelectionPath();
	
		if (parentPath == null) {
			parentNode = root;
		} else {
			parentNode = 
					(DefaultMutableTreeNode) (parentPath.getLastPathComponent());
		}
	
		return addObject(parentNode, child, name, true);
	}

	
	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, String name) {
		return addObject(parent, child, name, false);
	}

	
	private DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, String name, boolean visible) {
		
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = root;
		}

		if (parent.getAllowsChildren()) {
			if (child instanceof User && parent.getAllowsChildren()) {
				childNode.setAllowsChildren(false);
				treeModel.insertNodeInto(childNode, parent, parent.getChildCount());
			} 
			else if (child instanceof GroupUser) {
				childNode.setAllowsChildren(true);
				treeModel.insertNodeInto(childNode, parent, parent.getChildCount());
			}
		}

		if (visible) {
			treeView.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}

	// Returns the parent group node
		public Object getParentGroup() {
			return parentNode.getUserObject();
		}
	/********************************************************
	 * Returns the currently selected node in GroupUser object
	 * @return
	 ********************************************************/
	private GroupUser getSelectedGroupUserNode() {

		if ((currentNode != null) && (currentNode instanceof GroupUser)) {
			currentGroupUserNode = (GroupUser) currentNode;
		} else {
			currentGroupUserNode = rootGroup;
		}
		return currentGroupUserNode;
	}
	
	/********************************************************
	 * Returns the currently selected node in User object
	 * @return
	 ********************************************************/
	public User getSelectedUserNode() {
		if (currentNode instanceof User) {
			currentUserNode = (User) currentNode;
		}
		return currentUserNode;
	}
	
	public boolean IsUserExists(String id, DefaultMutableTreeNode root){
		
		
		User currentUser;
		GroupUser currentGroupUser;
		String currentID =null;
		
		Enumeration en = root.breadthFirstEnumeration();
		while(en.hasMoreElements()){
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) en.nextElement();
			Object currentNode = node.getUserObject();
			
			if(currentNode instanceof User){
				currentUser = (User) currentNode;
				currentID = currentUser.getUserID();
			}
			else if(currentNode instanceof GroupUser){
				currentGroupUser = (GroupUser) currentNode;
				currentID = currentGroupUser.getGroupID();
			}
			
			if(currentID.equals(id)){
				return  true;
			}
			
		}
		
		return false;
	}
	

//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		String ids;
//		String msg;
//		
//		if(e.getActionCommand().equals("Add User")){
//			
//			ids = userIDTextField.getText();
//			msg = "Please enter UserID!";
//			
//			//addUser(ids, msg);
//			
//			if(!ids.equals("")){
//				messageLabel.setText("");
//			//	newUser = new GroupUser(ids);
//				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(ids);
//				
//				// check if user already exists.
//				//user.add(user);
//				
//					//	newUser.add(newUser);
//						
//						userIDTextField.setText("");
//						//user.add(root, ids);
//						//System.out.println(newUser);
//						
//						root.add(new DefaultMutableTreeNode(ids));
//						
//						treeModel.reload(root);
//					
//			
//			
//			
//			
//			
//			
//			}
//			userIDTextField.setText("");
//			
//		}
//			
//		
//		if(e.getActionCommand().equals("Add Group")){
//				
//			ids = groupIDTextField.getText();
//			msg = "Please enter GroupUserID!";
//			
//			addUser(ids, msg);
//			
//			groupIDTextField.setText("");
//			
//			
//			//make newly added groupId in the tree selected
//			//int newGroupNo =  treeView.getRowCount();
//			
//			//TreePath userIDfromTree = treeView.getSelectionModel().getSelectionPath();
//			
////			DefaultMutableTreeNode model = (DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
//			
//			//treeView.setSelectionRow(newGroupNo);
//			
////			TreePath path = treeView.getSelectionPath();
////		    MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
////
////			MutableTreeNode newNode = new DefaultMutableTreeNode(ids);
////
////		    model.insertNodeInto(newNode, node, node.getChildCount());
////			
//			
////			System.out.println(model.getUserObject() + "newgroupid   "+newGroupNo);
//			
//			
//			
//			
//		}
//	
////	}
//
//	private void addUser(String ids, String msg) {
//		
//		if(!ids.equals("")){
//			messageLabel.setText("");
//		//	newUser = new GroupUser(ids);
//			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(ids);
//			
//			// check if user already exists.
//			//user.add(user);
//			
//				//	newUser.add(newUser);
//					
//					userIDTextField.setText("");
//					//user.add(root, ids);
//					//System.out.println(newUser);
//					
//					root.add(new DefaultMutableTreeNode(ids));
//					
//					treeModel.reload(root);
//				
//		}
//		else{
//			messageLabel.setText(msg);
//		}
//	}

//	@Override
//	public void valueChanged(TreeSelectionEvent e) {
////		
////		
//		 DefaultMutableTreeNode parentNode = 
//				 (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
////		
////			DefaultTreeCellRenderer renderer = 
////					(DefaultTreeCellRenderer) treeView.getCellRenderer();
////			 renderer.setTextSelectionColor(Color.white);
////		        renderer.setBackgroundSelectionColor(Color.blue);
////		        renderer.setBorderSelectionColor(Color.black);
//		
//			
//			
//		root = parentNode;
//		
////		System.out.println(e.getPath().getLastPathComponent());
//		
//		
//	}

}

