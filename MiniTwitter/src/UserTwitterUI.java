import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/****************************************************
 * UserTwitterUI contains a singleton design pattern.
 ****************************************************/
public class UserTwitterUI {
	
	private static UserTwitterUI instance = null;

	private static  User user;
	private AdminTwitter admin;
	private User currentUser;

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel0;
	private JPanel panel1;
	private JPanel panel11;
	private JPanel panel2;
	private JPanel panel3a;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5a;
	private JPanel panel5;
	
	private JButton followUserBtn;
	private JButton postTweetBtn;
	
	private JTextField userIDTextField;
	private JTextArea tweetMsgTA;
	
	private JLabel userIDLabel;
	private JLabel userLabel;
	private JLabel tweetMsgLabel;
	private JLabel tweetNewsFeedLabel;
	private JLabel currentFollowingLabel;
	
	private static  String userId;
	private List<User> usersFollowingList;
	private JList<String> followingList; 

	private JList<String> followersList; 
	private DefaultListModel<String> defaultFollowingListModel;
	
	private List<String> messagesList;
	
	
	
	/*****************************************************
	 * Launch the application.
	 * @param userID 
	 *****************************************************/
	public void UserTwitter(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTwitterUI window = new UserTwitterUI(user);
//					UserTwitterUI window = new UserTwitterUI(userId);
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
			instance  = new UserTwitterUI(user);
		}
		return instance;
	}

	/****************************************************
	 * Create the application.
	 ****************************************************/
	public UserTwitterUI(User user){

		initialize(user);
//		this.user = user;
		this.setCurrentUser(user);
//		this.userId = userId;
	}
//	public UserTwitterUI(String userId) {
//		this.setUserId(userId);
//	}

	/****************************************************
	 * Initialize the contents of the frame.
	 ****************************************************/
	@SuppressWarnings("unchecked")
	private void initialize(User user) {
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Color lableColor = Color.red;
		
		

		
		frame = new JFrame(user + " is logged in.");
		frame.setSize(400, 350);
		
			//mainPanel = new JPanel(new GridLayout(4,1));
			mainPanel = new JPanel();
				BoxLayout boxLayout= new BoxLayout(mainPanel, BoxLayout.Y_AXIS); 
				
				mainPanel.setLayout(boxLayout);
				mainPanel.setBackground(Color.DARK_GRAY);
				mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
				
				
				panel0 = new JPanel();
				panel0.setBorder(new LineBorder(Color.GRAY, 2));
					panel0.setOpaque(true);
					panel0.setBackground(Color.darkGray);
					
					userLabel = new JLabel();
					userLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
						userLabel.setForeground(lableColor );
						
						userLabel.setText(user +"");
						
						
					panel0.add(userLabel);
					panel0.setAlignmentY(Component.TOP_ALIGNMENT);
					
				mainPanel.add(panel0);

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
						followUserBtn.setBackground(Color.CYAN);
						followUserBtn.setText("Follow User");
						followUserBtn.setForeground(Color.BLACK);
						followUserBtn.setPreferredSize(new Dimension(120,45));
						
						/*****************************************************************************
						 * Follow User Button ActionListener
						 *****************************************************************************/
						
						followUserBtn.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								admin = new AdminTwitter();
								String	id = userIDTextField.getText();
							
								if(!id.equals("")){
									
									User currentFolloingUser = admin.returnUserOfthisUserID(id);
									user.setUserID(id);
									user.addFollowing(currentFolloingUser);
									
									System.out.println("-->  " + user.getUserID());
									userIDTextField.setText("");

//									user.addFollowing(user);
									addFollowingsToJList();
//									User.getFollowingsList();
									// do something
//									defaultFollowingListModel.clear();
//									for(User u : User.getFollowingsList()){
////								  		
//								  		defaultFollowingListModel.addElement("Hetal");//u.getUserID());
//								  		
////										System.out.println(u.getUserID()  +   " +++");
//
//								  	}
									
//									followingList = new JList<String>(defaultFollowingListModel);
//									
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
			
			
			panel11 = new JPanel(new BorderLayout());
			panel11.setBackground(Color.darkGray);
			panel11.setOpaque(true);

			currentFollowingLabel = new JLabel("",JLabel.LEFT);
			currentFollowingLabel.setBackground(Color.DARK_GRAY);
			currentFollowingLabel.setHorizontalAlignment(SwingConstants.LEFT);
			currentFollowingLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
			currentFollowingLabel.setForeground(lableColor );
			currentFollowingLabel.setText("Current Following Users:");
			
			panel11.add(currentFollowingLabel, BorderLayout.WEST);
			panel11.setAlignmentY(Component.TOP_ALIGNMENT);
		mainPanel.add(panel11, BorderLayout.EAST);
			

			
			/*****************************************************
			 * panel 2 - contains  current followers ListView and added to mainPanel.
			 ****************************************************/
				
				panel2 = new JPanel(new BorderLayout());
				
					panel2.setBackground(Color.darkGray);
					panel2.setOpaque(true);
					panel2.setPreferredSize(new Dimension(400,200));
					panel2.setBorder(border);
				
//					
//					System.out.println( "--2---  " + User.getFollowingsList());

					followingList = null;
				  	defaultFollowingListModel = new DefaultListModel<String>();

					addFollowingsToJList();
					defaultFollowingListModel.clear();

				  	//?????? not able to get current user from the followings List ????
			
				  	followingList = new JList<String>(defaultFollowingListModel);

				  	JScrollPane followersSP = new JScrollPane(followingList);

				  	followingList.setBorder(new LineBorder(new Color(0, 0, 0), 4));
				  	followingList.setFont(new Font("Lucida Grande", Font.BOLD, 14));
				  	followingList.setBackground(Color.DARK_GRAY);
				  	followingList.setForeground(Color.CYAN);
				  	
					panel2.add(followersSP , BorderLayout.CENTER);
					panel2.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel2);
			
			
			
			
			/*****************************************************
			 * panel 3a & 3- contains TweetMsgTA and PostTweetBTN
			 * 			 and added to mainPanel.
			 ****************************************************/
			panel3a = new JPanel(new BorderLayout());
			panel3a.setBackground(Color.darkGray);
			panel3a.setOpaque(true);

				tweetMsgLabel = new JLabel("",JLabel.LEFT);
				tweetMsgLabel.setBackground(Color.DARK_GRAY);
				tweetMsgLabel.setHorizontalAlignment(SwingConstants.LEFT);
				tweetMsgLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
				tweetMsgLabel.setForeground(lableColor );
				tweetMsgLabel.setText("Tweet Message");
				
				panel3a.add(tweetMsgLabel, BorderLayout.WEST);
				panel3a.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel3a, BorderLayout.EAST);
			
				panel3 = new JPanel(new FlowLayout());
					panel3.setBackground(Color.darkGray);
					panel3.setOpaque(true);
				
						tweetMsgTA = new JTextArea();
						tweetMsgTA.setPreferredSize(new Dimension(430, 75));
						tweetMsgTA.setLineWrap(true);
				        tweetMsgTA.setWrapStyleWord(true);
						tweetMsgTA.setBackground(Color.cyan);
						tweetMsgTA.setForeground(Color.BLACK);
						tweetMsgTA.setBorder(new LineBorder(new Color(0, 0, 0), 4));
						
					panel3.add(tweetMsgTA);	
					panel3.setAlignmentY(Component.TOP_ALIGNMENT);
				
			mainPanel.add(panel3);
			/*****************************************************
			 * panel 4 - contains PostTweetBTNand added to mainPanel.
			 ****************************************************/
				panel4 = new JPanel();
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
						
						postTweetBtn.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {

								if(!tweetMsgTA.getText().equals("")){
									
									
									
									
								}
								else{
									JOptionPane.showMessageDialog (frame, "No message to send.", "Message", 
											JOptionPane.INFORMATION_MESSAGE);
									tweetMsgTA.setFocusable(true);
								}
								
								
							}
							
						});
						
					
					panel4.add(postTweetBtn);
					panel4.setAlignmentY(Component.TOP_ALIGNMENT);
				mainPanel.add(panel4, BorderLayout.EAST);
					
			/*****************************************************
			 * panel 5 - contains userIDTA and followerBTN
			 * 			and added to mainPanel.
			 ****************************************************/	
				
				panel5a = new JPanel(new BorderLayout());
				panel5a.setBackground(Color.darkGray);
				panel5a.setOpaque(true);

					tweetNewsFeedLabel = new JLabel("",JLabel.LEFT);
					tweetNewsFeedLabel.setBackground(Color.DARK_GRAY);
					tweetNewsFeedLabel.setHorizontalAlignment(SwingConstants.LEFT);
					tweetNewsFeedLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
					tweetNewsFeedLabel.setForeground(lableColor );
					tweetNewsFeedLabel.setText("News Feeds:");
					
					panel5a.add(tweetNewsFeedLabel, BorderLayout.WEST);
					panel5a.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel5a, BorderLayout.EAST);
				
			
				
				
				panel5 = new JPanel(new BorderLayout());
					panel5.setBackground(Color.darkGray);
					panel5.setOpaque(true);
					panel5.setPreferredSize(new Dimension(400,200));
					panel5.setBorder(border);
			
				  	DefaultListModel<String> newsFeedModel = new DefaultListModel<String>();
				  	 JList<String> newsFeedList = new JList<String>(newsFeedModel);
				  	 newsFeedList.setForeground(Color.CYAN);
				  	 newsFeedList.setBackground(Color.DARK_GRAY);
				  	 newsFeedList.setBorder(new LineBorder(Color.DARK_GRAY, 4));
				  	 JScrollPane newsFeedSP = new JScrollPane( newsFeedList);
//						
//				  	for(int i=0; i<12; i++){
//				  		newsFeedModel.addElement("News " + i);
//				  	}
//				
				panel5.add(newsFeedSP, BorderLayout.CENTER);
				panel5.setAlignmentY(Component.TOP_ALIGNMENT);
			mainPanel.add(panel5);
		
	
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null); /* location center */
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	private  void addFollowingsToJList() {

		usersFollowingList = user.getFollowingsList(); // get the list<User> from User
	  	
		System.out.println("addFolloingsToJlist function2  " + usersFollowingList);
		
//		defaultFollowingListModel.clear();
	  	
	  	for(User u : usersFollowingList){
	  		
	  		defaultFollowingListModel.addElement(u.getUserID());
	  		
			System.out.println("addFolloingsToJlist function3  " + u.getUserID());

	  	}
//	  	return new JList<String>(defaultFollowingListModel);
	  	followingList = new JList<String>(defaultFollowingListModel);

	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}


}
