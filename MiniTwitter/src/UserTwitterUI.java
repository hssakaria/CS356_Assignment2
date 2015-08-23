import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/****************************************************
 * UserTwitterUI contains a singleton design pattern.
 ****************************************************/
public class UserTwitterUI {
	
	private static UserTwitterUI instance = null;

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JButton followUserBtn;
	private JButton postTweetBtn;
	private JTextField userIDTextField;
	private JTextArea tweetMsgTA;
	private JLabel userIDLabel;
	private JLabel TweetMsgLabel;

	private static  String userId;
	/*****************************************************
	 * Launch the application.
	 * @param userID 
	 *****************************************************/
	public void UserTwitter(String userId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTwitterUI window = new UserTwitterUI(userId);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/****************************************************
	 * Return single Instance of a class "UserTwitterUI"
	 * @param userId 
	 ****************************************************/
	public static UserTwitterUI getUserTwitterInstance(){
		if(instance == null){
			instance  = new UserTwitterUI(userId);
		}
		return instance;
	}

	/****************************************************
	 * Create the application.
	 ****************************************************/
	public UserTwitterUI(String userId){

		initialize(userId);
		this.userId = userId;
	}
//	public UserTwitterUI(String userId) {
//		this.setUserId(userId);
//	}

	/****************************************************
	 * Initialize the contents of the frame.
	 ****************************************************/
	private void initialize(String userId) {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		
		frame = new JFrame("UserId   " + userId);
		frame.setSize(400, 450);
		
			//mainPanel = new JPanel(new GridLayout(4,1));
			mainPanel = new JPanel();
				BoxLayout boxLayout= new BoxLayout(mainPanel, BoxLayout.Y_AXIS); 
				mainPanel.setLayout(boxLayout);
				mainPanel.setBackground(Color.CYAN);
				mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
			

			/*****************************************************
			 * panel 1 - contains userIDTA and followerBTN
			 * 			 and added to mainPanel
			 ****************************************************/
				panel1 = new JPanel(new FlowLayout());
					panel1.setOpaque(true);
					panel1.setBackground(Color.darkGray);
					
						userIDLabel = new JLabel();
						userIDLabel.setText("UserID:" );
						userIDLabel.setForeground(Color.cyan);
						userIDTextField = new JTextField(15);
						
						userIDTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
						userIDTextField.setForeground(Color.darkGray);
						userIDTextField.setBorder(BorderFactory.createCompoundBorder(border, 
					            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
						userIDTextField.setFocusable(true);
						
						followUserBtn = new JButton();
						followUserBtn.setText("Follow User");
						followUserBtn.setForeground(Color.BLACK);
						followUserBtn.setPreferredSize(new Dimension(120,45));
						
						/*****************************************************************************
						 * Follow User Button ActionListener
						 *****************************************************************************/
						
						followUserBtn.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {

								String	id = userIDTextField.getText();
								if(!id.equals("")){
									
									
									
									// do something
									
									
									
									
									userIDTextField.setText("");
								}
								else{
									
									JOptionPane.showMessageDialog(frame, "Please enter UseID.",	
											"Warning", JOptionPane.WARNING_MESSAGE);
								}
								
								
							}
							
						});
						
						
					panel1.add(userIDLabel);	
					panel1.add(userIDTextField);	
					panel1.add(followUserBtn);	
					panel1.setAlignmentY(Component.TOP_ALIGNMENT);
				
			mainPanel.add(panel1);
			
			/*****************************************************
			 * panel 2 - contains  current followers ListView and added to mainPanel.
			 ****************************************************/
				
				panel2 = new JPanel(new BorderLayout());
				
					panel2.setBackground(Color.darkGray);
					panel2.setOpaque(true);
					panel2.setPreferredSize(new Dimension(400,200));
					panel2.setBorder(border);
					
					  	DefaultListModel followerModel = new DefaultListModel();
					  	JList followersListView = new JList(followerModel);
					  	followersListView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					  	followersListView.setLayoutOrientation(JList.VERTICAL_WRAP);
					  	followersListView.setBackground(Color.DARK_GRAY);
					  	JScrollPane followersSP = new JScrollPane(followersListView);
						
					  	for(int i=0; i<6; i++){
					  		followerModel.addElement("List " + i);
					  	}
					panel2.add(followersSP , BorderLayout.CENTER);
					panel2.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel2);
			
			/*****************************************************
			 * panel 3 - contains TweetMsgTA and PostTweetBTN
			 * 			 and added to mainPanel.
			 ****************************************************/
				panel3 = new JPanel(new FlowLayout());
					panel3.setBackground(Color.darkGray);
					panel3.setOpaque(true);
				
						tweetMsgTA = new JTextArea();
						tweetMsgTA.setPreferredSize(new Dimension(430, 75));
						tweetMsgTA.setLineWrap(true);
				        tweetMsgTA.setWrapStyleWord(true);
						tweetMsgTA.setText("Tweet Message");
						tweetMsgTA.setBackground(Color.cyan);
						tweetMsgTA.setForeground(Color.BLACK);
						tweetMsgTA.setBorder(new LineBorder(new Color(0, 0, 0)));
						
					panel3.add(tweetMsgTA);	
					panel3.setAlignmentY(Component.TOP_ALIGNMENT);
				
			mainPanel.add(panel3);
			/*****************************************************
			 * panel 4 - contains PostTweetBTNand added to mainPanel.
			 ****************************************************/
				panel4 = new JPanel(new BorderLayout());
					panel4.setBackground(Color.darkGray);
					panel4.setOpaque(true);
						postTweetBtn = new JButton();
						postTweetBtn.setMnemonic('P');
						postTweetBtn.setIcon(null);
						postTweetBtn.setFont(new Font("Gill Sans", Font.BOLD, 13));
						postTweetBtn.setText("Post Tweet");
						postTweetBtn.setForeground(Color.DARK_GRAY);
						postTweetBtn.setBackground(Color.CYAN);
						postTweetBtn.setPreferredSize(new Dimension(100,45));
						
					
					panel4.add(postTweetBtn, BorderLayout.EAST);
					panel4.setAlignmentY(Component.TOP_ALIGNMENT);
				mainPanel.add(panel4, BorderLayout.EAST);
					
			/*****************************************************
			 * panel 5 - contains userIDTA and followerBTN
			 * 			and added to mainPanel.
			 ****************************************************/	
				panel5 = new JPanel(new BorderLayout());
					panel5.setBackground(Color.darkGray);
					panel5.setOpaque(true);
					panel5.setPreferredSize(new Dimension(400,200));
					panel5.setBorder(border);
			
				  	DefaultListModel newsFeedModel = new DefaultListModel();
				  	 JList newsFeedListView = new JList(newsFeedModel);
				  	 newsFeedListView.setForeground(Color.CYAN);
				  	 newsFeedListView.setBackground(Color.DARK_GRAY);
				  	 newsFeedListView.setBorder(null);
				  	 JScrollPane newsFeedSP = new JScrollPane( newsFeedListView);
					
				  	for(int i=0; i<12; i++){
				  		newsFeedModel.addElement("News " + i);
				  	}
				
				panel5.add(newsFeedSP, BorderLayout.CENTER);
				panel5.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel5);
		
					
		
		
		
		
		
		
	
		
		
		
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null); /* location center */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	/*****************************
	 * Accessor methods for UserID
	 * @return
	 ******************************/
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
