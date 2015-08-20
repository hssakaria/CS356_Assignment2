import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AdminTwitter{

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel topPanel;
	private JPanel midPanel;
	private JPanel bottomPanel;

	private JTree treeView;
	private JTextArea userIDTextArea;
	private JTextArea groupIDTextArea;
	private Button userAddBtn;
	private Button groupAddBtn;
	private Button userViewBtn;
	private Button totalUserBtn;
	private Button totalGroupBtn;
	private Button totalMsgBtn;
	private Button positiveWordBtn;
	

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
		frame.setSize(650, 350);
	
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		/*****************************************************
		 * mainPanel- contains two sub panels (rightPanel and
		 * 				leftPanel)
		 ****************************************************/
		mainPanel = new JPanel(new GridLayout(1,2));
		
			/*****************************************************
			 * rightPanel- contains treeView and added to mainPanel
			 ****************************************************/
			 rightPanel = new JPanel();
			 DefaultMutableTreeNode root = new DefaultMutableTreeNode("CS356");
			 DefaultTreeModel model =new DefaultTreeModel(root);
			 //root.add(model);
				treeView = new JTree(model);
//			 treeView = new JTree();
			 	rightPanel.add(treeView);
			    //rightPanel.add(new JScrollPane(treeView));
			    rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray,10));
	
			mainPanel.add(rightPanel);
			
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
//					
//						/*****************************************************
//						 *userIDTextArea
//						 ****************************************************/
						userIDTextArea = new JTextArea("UserId", 1,10);
							userIDTextArea.setBackground(UIManager.getColor("Slider.background"));
							userIDTextArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							userIDTextArea.setForeground(UIManager.getColor("TabbedPane.light"));
							userIDTextArea.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
						/*****************************************************
						 *groupIDTextArea
						 ****************************************************/
						groupIDTextArea = new JTextArea("GroupID",5,20);
							groupIDTextArea.setBackground(UIManager.getColor("InternalFrame.background"));
							groupIDTextArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
							groupIDTextArea.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
							groupIDTextArea.setBorder(BorderFactory.createCompoundBorder(border, 
						            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
							
						/*****************************************************
//						 * userAddBtn
//						 ****************************************************/
						userAddBtn = new Button();
							userAddBtn.setLabel("Add User");
							userAddBtn.setBackground(Color.CYAN);
							//userAddBtn.addActionListener(this);
//							
//						/*****************************************************
//						 * groupAddBtn
//						 ****************************************************/		
						groupAddBtn = new Button();
							groupAddBtn.setLabel("Add Group");
							groupAddBtn.setBackground(Color.CYAN);
				
				 leftPanel.add(topPanel);

//				 
//				 
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
						topPanel.add(userIDTextArea);
				    	topPanel.add(userAddBtn);
				    	topPanel.add(groupIDTextArea);
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
		
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); /* location center */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/*****************************************************
	 * actionPerformed implements all the action listioners
	 ****************************************************/
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//	}

}
