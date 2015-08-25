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
	private JPanel bottomPanel;
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
		ImageIcon image = new ImageIcon(this.getClass().getResource("groupIcon.png"));
		Image groupImage = image.getImage();
		
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
			
				rootGroup = new GroupUser();
				rootGroup.setGroup("CS356", null);
				root = new DefaultMutableTreeNode(rootGroup);
				
				treeModel = new DefaultTreeModel( root );
				
					treeView = new JTree(treeModel);
					treeView.setBorder(new LineBorder(Color.CYAN, 3));
					treeView.setForeground(Color.CYAN);
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
				
			 leftPanel = new JPanel();
			 BoxLayout boxLayout= new BoxLayout( leftPanel, BoxLayout.Y_AXIS); 
			 	leftPanel.setLayout(boxLayout);
				leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,10));
				leftPanel.setOpaque(true);
				leftPanel.setBackground(Color.darkGray);
				leftPanel.setPreferredSize(new Dimension(410,450));
				
				topPanel1 = new JPanel(new FlowLayout());
					topPanel1.setOpaque(true);
					topPanel1.setBackground(Color.darkGray);

					userIDLabel = new JLabel();
						userIDLabel.setText("UserID: " );
						userIDLabel.setForeground(Color.cyan);
					
						/*******************************************************************************
						 *userIDTextArea
						 *******************************************************************************/
						userIDTextField = new JTextField(15);
							
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
											
											/********************************************************************
											 * The following loop checks if the selected useris a GroupID or a Root. 
											 * If selected node is a instanceof a GroupUse then that GroupID = root
											 * and check if user exist from that node. Not from the root.
											 *******************************************************************/
											
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
							topPanel1.setAlignmentY(Component.TOP_ALIGNMENT);

						leftPanel.add(topPanel1);
							 	
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
					topPanel2.setAlignmentY(Component.TOP_ALIGNMENT);

					leftPanel.add(topPanel2);
				 
				midPanel =  new JPanel();
				
					midPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					midPanel.setBackground(Color.DARK_GRAY);
					midPanel.setOpaque(true);
					
					/*****************************************************
					 * userViewBtn - Display UserUI
					 ****************************************************/		
					userViewBtn = new Button();
						userViewBtn.setBackground(Color.BLACK);
						userViewBtn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
						userViewBtn.setForeground(Color.BLUE);
						userViewBtn.setLabel("Open User View");

						userViewBtn.setPreferredSize(new Dimension(250,60));
						/**********************************************************
						 *when UserViewBtn gets trigger, it will instantiate UserUI
						 *and display userTwitterUI using Singleton Pattern
						 *First make sure the node is a User not a GroupID
						 **********************************************************/
						userViewBtn.addActionListener(new ActionListener(){
							
							@Override
							public void actionPerformed(ActionEvent e) {

								DefaultMutableTreeNode selectedUser = 
										(DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
				
								if(selectedUser != null){
									
//									String userID = selectedUser.getUserObject().toString();
									
									Object currentUser = selectedUser.getUserObject();
									
									if(currentUser instanceof User){
										
										currentUserNode = (User) currentUser;
										
										System.out.println("USER:  " + currentUserNode);// 
										
//										user.addFollowing(currentUserNode); // add user itself in following list
										
										System.out.println( "----- " +user.getFollowingsList());
										
											UserTwitterUI.getUserTwitterInstance().UserTwitter(currentUserNode); 
//											
//											UserTwitterUI.getUserTwitterInstance().UserTwitter(userID); 

											
											User.getFollowingsList().clear();
//											System.out.println("USER:2  " + currentUserNode);//

											// adding current user to followingUserlist in User 
											
											
									
									}
									else{
											JOptionPane.showMessageDialog (frame, "GroupID cannot be viewed a UserView.",
													"Message", JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else{
									JOptionPane.showMessageDialog (frame, "UserID must be selected", "Message", 
											JOptionPane.INFORMATION_MESSAGE);
								}
							}
						});
						
					midPanel.add(userViewBtn, BorderLayout.CENTER);
					midPanel.setAlignmentY(Component.TOP_ALIGNMENT);

				leftPanel.add(midPanel);

				
					bottomPanel1 = new JPanel(new FlowLayout());
					bottomPanel1.setBorder(new LineBorder(Color.CYAN, 2));
					bottomPanel1.setBackground(Color.DARK_GRAY);
						/*****************************************************
						 * totalUserBtn
						 ****************************************************/	
						totalUserBtn = new Button();
							totalUserBtn.setPreferredSize(new Dimension(xBtn, yBtn));
							totalUserBtn.setForeground(SystemColor.controlHighlight);
							totalUserBtn.setLabel("Show User Total");
							
							/****************************
							 * Tota User Button Action Listener
							 ***************************/
							totalUserBtn.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									// count if object is instance of user.
									
								}
								
							});
							
							
						totalGroupBtn = new Button();
							totalGroupBtn.setPreferredSize(new Dimension(xBtn, yBtn));
							totalGroupBtn.setForeground(SystemColor.controlHighlight);
							totalGroupBtn.setLabel("Show Group Total");
							
							/****************************
							 * Action Listener
							 ***************************/
							
							totalGroupBtn.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									// display total groups are created.
									// go through entire treeView and do root.breathsearch
									// of object instanceof GroupUse, then count++;
									
								}
								
							});
					
						bottomPanel1.add(totalUserBtn);
				    	bottomPanel1.add(totalGroupBtn);
						bottomPanel1.setAlignmentY(Component.TOP_ALIGNMENT);

				    leftPanel.add(bottomPanel1);
				    
				    	bottomPanel2 = new JPanel(new FlowLayout());
				    	bottomPanel2.setBorder(new LineBorder(Color.CYAN, 2));
				    	bottomPanel2.setBackground(Color.DARK_GRAY);
				    	
						totalMsgBtn = new Button();
							totalMsgBtn.setPreferredSize(new Dimension(xBtn, yBtn));
							totalMsgBtn.setForeground(UIManager.getColor("RadioButton.select"));
							totalMsgBtn.setLabel("Show Total Messages");
						
							/****************************
							 * Action Listener
							 ***************************/
							
							totalMsgBtn.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
									
									
									// display total messages posted.
								}
								
							});
							
							
						positiveWordBtn = new Button();
							positiveWordBtn.setPreferredSize(new Dimension(xBtn, yBtn));
							positiveWordBtn.setForeground(Color.GREEN);
							positiveWordBtn.setLabel("Show Positive%");
							
							/****************************
							 * Action Listener
							 ***************************/
							positiveWordBtn.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
									
									
									
									// get the word from the list of positive words and
									// find it in the tweet message.
									// Positive words: good, wonderful, great, nice, excellent, etcs.
									
									
								}
								
							});
							
							
							
							
				    	bottomPanel2.add(totalMsgBtn);
				    	bottomPanel2.add(positiveWordBtn);
						bottomPanel2.setAlignmentY(Component.TOP_ALIGNMENT);

				   leftPanel.add(bottomPanel2);

			   leftPanel.add(bottomPanel2);

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
			
			displayMsgIDExists("Group User already exists!");
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
			
			 displayMsgIDExists("User already exists.");
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

	/********************************************************
	 * Display message if userId or GroupId already in the
	 * treeView.
	 ********************************************************/
	
	private void displayMsgIDExists(String msg) {
		
		JOptionPane.showMessageDialog (frame, msg, "Message", 
				JOptionPane.INFORMATION_MESSAGE);
		
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
		}
		else {
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
	/**********************************************************
	 * This function returns the User of given userID from the
	 * treeView.
	 * @param userID
	 * @return User
	 *********************************************************/

	public User returnUserOfthisUserID(String userID) {
		
		User userOfthatUserID = null;
		
		Enumeration en = root.breadthFirstEnumeration();
		System.out.println("Admin 1   " + en.nextElement());

		while (en.hasMoreElements()) {
			
			DefaultMutableTreeNode node = 
					(DefaultMutableTreeNode) en.nextElement();
			
			Object thisNode = node.getUserObject();
			
			System.out.println("Test Admin:  " + thisNode);
			
			if (thisNode instanceof User) {
				
				userOfthatUserID = (User) thisNode;
				
				System.out.println("Admin 2   " + userOfthatUserID);
				if (userID.equals(userOfthatUserID.getUserID())) {
					return userOfthatUserID;
				}
			}
			System.out.println("Admin 1-->   " + en.nextElement());

		}
		System.out.println("Admin3   " + userOfthatUserID);

		return userOfthatUserID;
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
	

}

