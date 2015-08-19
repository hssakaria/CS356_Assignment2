import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class AdminTwitter {
	

	private JFrame frame;
	private JPanel panel;
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
		
		
		treeView = new JTree();
		userIDTextArea = new JTextArea("UserId", 1,10);
		userIDTextArea.setBackground(UIManager.getColor("Slider.background"));
		userIDTextArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		userIDTextArea.setForeground(UIManager.getColor("TabbedPane.light"));
		groupIDTextArea = new JTextArea("GroupID",5,20);
		groupIDTextArea.setBackground(UIManager.getColor("InternalFrame.background"));
		groupIDTextArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		groupIDTextArea.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		userAddBtn = new Button();
			userAddBtn.setForeground(UIManager.getColor("RadioButton.light"));
			userAddBtn.setLabel("Add User");
			
		groupAddBtn = new Button();
			groupAddBtn.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
			groupAddBtn.setLabel("Add Group");
		
			
		userViewBtn = new Button();
			userViewBtn.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
			userViewBtn.setBackground(UIManager.getColor("FormattedTextField.inactiveForeground"));
			userViewBtn.setLabel("Open User View");
			
			userViewBtn.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					UserTwitterUI.getUserTwitterInstance().UserTwitter(); 

				}
				

			});
			
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
		
		
		frame = new JFrame("Mini Twitter by Hetal Sakaria");
	
		frame.setSize(650, 350);
		
		/*JPanel*/
		
		panel = new JPanel(new GridLayout(1,2));
		    rightPanel = new JPanel();
			leftPanel = new JPanel(new GridLayout(3,1));
				topPanel = new JPanel(new GridLayout(2,2));
				midPanel = new JPanel();
				midPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				midPanel.setBackground(UIManager.getColor("FormattedTextField.inactiveForeground"));
				bottomPanel = new JPanel(new GridLayout(2,2));
			
		    leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,10));
		    leftPanel.add(topPanel);
		    	topPanel.add(userIDTextArea);
		    	topPanel.add(userAddBtn);
		    	topPanel.add(groupIDTextArea);
		    	topPanel.add(groupAddBtn);
		    leftPanel.add(midPanel);
		    	midPanel.add(userViewBtn);
		    leftPanel.add(bottomPanel);
		    	bottomPanel.add(totalUserBtn);
		    	bottomPanel.add(totalGroupBtn);
		    	bottomPanel.add(totalMsgBtn);
		    	bottomPanel.add(positiveWordBtn);
		    
	//	   topPanel.setBorder(BorderFactory.createLineBorder(Color.gray,5));
	//	   midPanel.setBorder(BorderFactory.createLineBorder(Color.gray,5));
	//	   bottomPanel.setBorder(BorderFactory.createLineBorder(Color.gray,2));
	//	   
			rightPanel.add(treeView);
		    rightPanel.setBorder(BorderFactory.createLineBorder(Color.gray,10));

		
		panel.add(rightPanel);
		panel.add(leftPanel);
		//frame.add(rightPanel);
		//frame.add(pane);
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null); /* location center */
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
