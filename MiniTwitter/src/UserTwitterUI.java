import java.awt.EventQueue;

import javax.swing.JFrame;

public class UserTwitterUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public UserTwitterUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setSize(650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
