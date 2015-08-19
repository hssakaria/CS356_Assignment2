import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.*;

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
	private JButton followUserBtn;
	private JButton postTweetBtn;
	private JTextArea userIDTA;
	private JTextArea tweetMsgTA;


	/*****************************************************
	 * Launch the application.
	 *****************************************************/
	public void UserTwitter() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTwitterUI window = new UserTwitterUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/****************************************************
	 * Return single Instance of a class "UserTwitterUI"
	 ****************************************************/
	public static UserTwitterUI getUserTwitterInstance(){
		if(instance == null){
			instance  = new UserTwitterUI();
		}
		return instance;
	}

	/****************************************************
	 * Create the application.
	 ****************************************************/
	public UserTwitterUI() {

		initialize();
	}

	/****************************************************
	 * Initialize the contents of the frame.
	 ****************************************************/
	private void initialize() {
		
		
		frame = new JFrame("User UI");
		
			mainPanel = new JPanel(new GridLayout(4,1));
			
			/*****************************************************
			 * panel 1 - contains userIDTA and followerBTN
			 * 			 and added to mainPanel
			 ****************************************************/
				panel1 = new JPanel(new GridLayout(1,2));
					panel1.setBackground(Color.cyan);
					 
						userIDTA = new JTextArea();
						userIDTA.setText("User ID");
						panel1.add(userIDTA);
						
						followUserBtn = new JButton();
						followUserBtn.setText("Follow User");
					panel1.add(followUserBtn);	
				
			mainPanel.add(panel1);
			
			/*****************************************************
			 * panel 2 - contains  current followers ListView
			 * 			 and added to mainPanel.
			 ****************************************************/
				
				panel2 = new JPanel();
					panel2.setBackground(Color.LIGHT_GRAY);
				
					  	DefaultListModel followerModel = new DefaultListModel();
					  	JList followersListView = new JList(followerModel);
					  	JScrollPane followersSP = new JScrollPane(followersListView);
						
					  	for(int i=0; i<12; i++){
					  		followerModel.addElement("List " + i);
					  	}
						
					panel2.add(followersListView);
			
			mainPanel.add(panel2);
				
			/*****************************************************
			 * panel 3 - contains TweetMsgTA and PostTweetBTN
			 * 			 and added to mainPanel.
			 ****************************************************/
				panel3 = new JPanel(new GridLayout(1,2));
					panel3.setBackground(Color.cyan);
						tweetMsgTA = new JTextArea();
						tweetMsgTA.setText("Tweet Message");
						postTweetBtn = new JButton();
						postTweetBtn.setText("Post Tweet");
						
					panel3.add(tweetMsgTA);	
					panel3.add(postTweetBtn);
					
				
			mainPanel.add(panel3);	
			/*****************************************************
			 * panel 4 - contains userIDTA and followerBTN
			 * 			and added to mainPanel.
			 ****************************************************/	
				panel4 = new JPanel();
					panel4.setBackground(Color.LIGHT_GRAY);
					
				  	DefaultListModel newsFeedModel = new DefaultListModel();
				  	 JList newsFeedListView = new JList(newsFeedModel);
				  	 JScrollPane newsFeedSP = new JScrollPane( newsFeedListView);
					
				  	for(int i=0; i<12; i++){
				  		newsFeedModel.addElement("News " + i);
				  	}
				
				panel4.add( newsFeedListView);
			mainPanel.add(panel4);
		
					
		
		
		
		
		
		
		
		
		
		
		
		frame.add(mainPanel);
		frame.setSize(550, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
