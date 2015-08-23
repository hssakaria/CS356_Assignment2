/****************************************************************
 * Using Composite Design Patter. 
 * User is a leaf - 
 ****************************************************************/
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;



/*
 * Leaf Node
 */

public class User implements UserComponent{
	
	private User user;
	private String UserID;
	private String groupID;
	
	
//	private List<User> followers;
//	private List<User> followings;
//	private List<String> message;
//	private List<String> newsFeed;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	/***********************************************************
	 * Add user
	 * @param user
	 * @param userID
	 * @param groupID
	 ************************************************************/
	public void addUser(User user, String userID, String groupID){
		
		this.user = user;
		this.setGroupID(groupID);
		this.setUserID(userID);
		
//		this.followers = new ArrayList<User>();
//		this.followings = new ArrayList<User>();
//		this.newsFeed = new ArrayList<String>();
//		this.message = new ArrayList<String>();
//		
		
		
	}
	public String toString(){
		return UserID;
	}
}

