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
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class AdminTwitter implements ActionListener ,TreeSelectionListener {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel topPanel;
	private JPanel midPanel;
	private JPanel bottomPanel;

	private JTree treeView;
	private JTextField userIDTextField;
	private JTextField groupIDTextField;
	private JLabel groupdIDLable;
	private JLabel userIDLabel;
	private Button userAddBtn;
	private Button groupAddBtn;
	private Button userViewBtn;
	private Button totalUserBtn;
	private Button totalGroupBtn;
	private Button totalMsgBtn;
	private Button positiveWordBtn;
	private JDialog msgDL;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("CS356");
	 DefaultTreeModel treeModel;
	User newUser;
	User newGroupUser;
	java.util.List<String> idsList;
	private int count =0;
	
	
	//ArrayList<String> idsList; 
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
		
		idsList = new ArrayList();
		
		frame = new JFrame("Mini Twitter by Hetal Sakaria");
		frame.setSize(650, 450);
		
	
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		/*****************************************************
		 * mainPanel- contains two sub panels (rightPanel and
		 * 				leftPanel)
		 ****************************************************/
		mainPanel = new JPanel(new GridLayout(1,2));
		
			/*****************************************************
			 * rightPanel- contains treeView and added to mainPanel
			 ****************************************************/
			 //rightPanel = new JPanel();
//			 root = new DefaultMutableTreeNode("CS356");
			
//			 DefaultMutableTreeNode model =new DefaultMutableTreeNode(root);
			 
			 
//		
			 treeModel = new DefaultTreeModel( root );	
			 
			 treeView = new JTree(treeModel);
		
			 treeView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			 treeView.setBackground(UIManager.getColor("Button.background"));

			 treeView.addTreeSelectionListener(this);
//			 treeView.addTreeSelectionListener(new TreeSelectionListener(){
//
//				@Override
//				public void valueChanged(TreeSelectionEvent e) {
//					 DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
//					          .getPath().getLastPathComponent();
//					      System.out.println("You selected " + node);					
//				}
//				 
//			 });
				

			 mainPanel.setBorder(BorderFactory.createLineBorder(Color.gray,10));
				
				mainPanel.add(new JScrollPane(treeView ));
			
			
			/*****************************************************
			 * leftPanel- contains three subpanels, top, mid, and
			 * 			bottomPanel.
			 * 			topPanel contains userIdTextArea, userAddBtn,
			 * 			groupIDTextArea, and groudAddBtn
			 * 			midPanel contains userViewBtn
			 * 			bottomPanel contains four buttons which 
			 * 			display the statistics.
			 * 			leftPanel added to mainPanel.
			 ****************************************************/
			leftPanel = new JPanel(new GridLayout(3,1));
			
				leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,10));
				topPanel = new JPanel(new GridLayout(2,2));
					//userIDLabel = new JLabel("UserID:");
					//topPanel.add(userIDLabel);
						/*****************************************************
						 *userIDTextArea
						 ****************************************************/
						userIDTextField = new JTextField("UserID",10);
							userIDTextField.setBackground(UIManager.getColor("Slider.background"));
							userIDTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							userIDTextField.setForeground(UIManager.getColor("TabbedPane.light"));
							userIDTextField.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
						/*****************************************************
						 *groupIDTextArea
						 ****************************************************/
//						groupdIDLable = new JLabel("GroupID:");
//						topPanel.add(groupdIDLable);
						groupIDTextField = new JTextField(10);
							groupIDTextField.setBackground(UIManager.getColor("InternalFrame.background"));
							groupIDTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							groupIDTextField.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
							groupIDTextField.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
							
						/*****************************************************
						 * userAddBtn
						 ****************************************************/
						userAddBtn = new Button();
							userAddBtn.setLabel("Add User");
							userAddBtn.setBackground(Color.CYAN);
							
							
							/*********************
							 * ActionListener
							 *********************/
							userAddBtn.addActionListener(this);
							
							
//							
//							userAddBtn.addActionListener(new ActionListener(){
//								@Override
//								public void actionPerformed(ActionEvent e) {
//									
//									newUserID = userIDTextField.getText();
//									userIDTextField.setText("");
//									//newUser = new User(newUserID);
//									
//									newUser = new CreateUser(newUserID);
//									newUser.add(newUser);
//									
//									//newGroupUser.add(newUser);//add(newUser);
////									System.out.println(newUserID);
////									user = new User(newUserID);
////									user.add(user);
//									
//									//root.add(new DefaultMutableTreeNode(newUserID));
//									
////									if(newUser.compareUserID(newUserID) == true){
////										
////										diplayMSG();
////										
////											
////										
////									}
////									else {
//////										//add
////
////										user.add(user);
////										System.out.println(newUserID);
////									//	root.add(new DefaultMutableTreeNode(newUserID));
////										//root.add(new  DefaultMutableTreeNode(id));
////										
////										for(User u : user.getUser()){
////											System.out.println(u);
////											
////										}
////									}
//									
//								}
//								
//							});
							
						/*****************************************************
						 * groupAddBtn
						 ****************************************************/		
						groupAddBtn = new Button();
						
							groupAddBtn.setLabel("Add Group");
							groupAddBtn.setBackground(Color.CYAN);
							
							/******************
							 * ActionListener
							 *****************/
							groupAddBtn.addActionListener(this);
							
//							groupAddBtn.addActionListener(new ActionListener(){
//								
//								//String id;
//								@Override
//								public void actionPerformed(ActionEvent e) {
//									
//									newUserID = groupIDTextField .getText();
//									
//									
//									newGroupUser = new GroupUser(newUserID);
//									System.out.println("Group Btn clicked--" + newUserID);
//
//									groupIDTextField.setText("");
//									
//									newGroupUser.print();
//									
//									
//									
//								}
//								
//							});
				
				 leftPanel.add(topPanel);
				 
				midPanel = new JPanel();
				
					midPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					midPanel.setBackground(UIManager.getColor("FormattedTextField.inactiveForeground"));
					/*****************************************************
					 * userViewBtn - Display UserUI
					 ****************************************************/		
					userViewBtn = new Button();
						userViewBtn.setBackground(Color.CYAN);
						userViewBtn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
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
								UserTwitterUI.getUserTwitterInstance().UserTwitter(); 
							}
						});
						topPanel.add(userIDTextField);
				    	topPanel.add(userAddBtn);
				    	topPanel.add(groupIDTextField);
				    	topPanel.add(groupAddBtn);
	
					midPanel.add(userViewBtn);
				leftPanel.add(midPanel);
				
				
				
				bottomPanel = new JPanel(new GridLayout(2,2));

					/*****************************************************
					 * totalUserBtn
					 ****************************************************/	
					totalUserBtn = new Button();
						totalUserBtn.setForeground(SystemColor.controlHighlight);
						totalUserBtn.setLabel("Show User Total");
						totalGroupBtn = new Button();
						totalGroupBtn.setForeground(SystemColor.controlHighlight);
						totalGroupBtn.setLabel("Show Group Total");
					totalMsgBtn = new Button();
						totalMsgBtn.setForeground(UIManager.getColor("RadioButton.select"));
						totalMsgBtn.setLabel("Show Total Messages");
					positiveWordBtn = new Button();
						positiveWordBtn.setForeground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
						positiveWordBtn.setLabel("Show Positive%");
					
					bottomPanel.add(totalUserBtn);
			    	bottomPanel.add(totalGroupBtn);
			    	bottomPanel.add(totalMsgBtn);
			    	bottomPanel.add(positiveWordBtn);
			    leftPanel.add(bottomPanel);
		    	
		mainPanel.add(leftPanel);
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); /* location center */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	protected void diplayMSG() {
				
		JOptionPane.showMessageDialog(frame, this, "UserID exists", 0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ids;
		
		
		if(e.getActionCommand().equals("Add User")){
			
			ids = userIDTextField.getText();
			

			
			checkIFidExist(ids);
			
			
//			root.add(new DefaultMutableTreeNode(ids));
			
			newUser = new CreateUser(ids);
			userIDTextField.setText("");
			newUser.add(newUser);
			newUser.print();
			treeModel.reload(root);		
		}
			
	
		
		if(e.getActionCommand().equals("Add Group")){
			
			ids = groupIDTextField.getText();
		
			
			checkIFidExist(ids);
//			root.add(new DefaultMutableTreeNode(ids));
//			
//			
			newGroupUser = new GroupUser(ids);

			newGroupUser.add(newUser);
			groupIDTextField.setText("");
			newGroupUser.print();
			treeModel.reload(root);	
		}
		
		System.out.println(idsList);
//	
	}

	private void checkIFidExist(String ids) {
		
//		
//		if(!newGroupUser.users.contains(ids))
//		{
//			newUser.add(newUser);
//		}
//		else{
//			System.out.println(ids + " already exists. Please create another one!");
//
//			
//		}
		
		if(!idsList.contains(ids)){
			idsList.add(ids);
			root.add(new DefaultMutableTreeNode(ids));
			
			
			count++;
		}
		else{
		    JOptionPane.showMessageDialog(frame, "UserID:  " + ids + "  already exists.\nPlease try again!");
		}
		
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
//		
//		
		 DefaultMutableTreeNode parentNode = 
				 (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
		 
		root = parentNode;
		
//		System.out.println(e.getPath().getLastPathComponent());
		
		
	}

}


//treeView.addTreeSelectionListener(new TreeSelectionListener() {
//    public void valueChanged(TreeSelectionEvent e) {
//      DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
//          .getPath().getLastPathComponent();
//      System.out.println("You selected " + node);
//    }
//  });



//
//private JTree getTree()
//{
//    String[] birds = {
//        // branches  |<-- child leaf nodes -->|
//        "hawks",   "gray",    "red-tailed", "rough-legged",
//        "falcons", "harrier", "kestrel",    "kite", 
//        "owls",    "barred",  "saw-whet",   "snowy"
//    };
//    DefaultMutableTreeNode root = new DefaultMutableTreeNode("birds");
//    DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[birds.length];
//    for(int j = 0; j < nodes.length; j++)
//        nodes[j] = new DefaultMutableTreeNode(birds[j]);
//    for(int j = 0; j < 9; j += 4)
//    {
//        root.insert(nodes[j], j % 3);
//        for(int k = j + 1; k < j + 4; k++)
//            nodes[j].insert(nodes[k], k - j - 1);
//    }
//    DefaultTreeModel model = new DefaultTreeModel(root);
//    tree = new JTree(model);
//    tree.addTreeSelectionListener(this);
//    return tree;
//}

