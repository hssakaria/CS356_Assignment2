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
	
	
	private List<User> followersList;
	
	private static  List<User> followingsList;
	private List<String> messagesList;
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
	
	public List<User> getFollowersList() {
		return followersList;
	}
	public void setFollowers(List<User> followersList) {
		this.followersList = followersList;
	}
	public static List<User> getFollowingsList() {
		return followingsList;
	}
	public void setFollowings(List<User> followingsList) {
		User.followingsList = followingsList;
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
		
//		this.followersList = new ArrayList<User>();
		User.followingsList = new ArrayList<User>();
//		this.newsFeed = new ArrayList<String>();
		this.messagesList = new ArrayList<String>();

		
		
	}
	public void addMessage(String message){
		messagesList.add(message);
	}
	public void addFollowing(User followingUser){
		
		if(!IsUserExists(followingsList,followingUser)){
			followingsList.add(followingUser);
		}
		
		
		
}
	
	public void addFollowers(User userFollowers){
		
		if(!IsUserExists(followersList, userFollowers)){
		
			followersList.add(userFollowers);
		}
		
	}
	
/******************************************************************
 * Check if User exists either in followers list or following list
 * @param followers
 * @param user
 * @return
 ******************************************************************/
	private boolean IsUserExists(List<User> userFollower, User user) {
		for(User u : userFollower){
			if(u.equals(userFollower))
				return true;
		}
		return false;
	}
	public String toString(){
		return UserID;
	}
	
}

