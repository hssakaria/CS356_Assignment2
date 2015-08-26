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

public class User extends AdminVisitor implements Visitable, Observable,UserComponent{

	private User user;
	private String UserID;
	private String groupID;

	private List<User> usersList;
	private List<User> followersList;
	private  List<User> followingsList;
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
	public List<User> getFollowingsList() {
		return followingsList;
	}
	public void setFollowings(List<User> followingsList) {
		this.followingsList = followingsList;
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
		this.followingsList = new ArrayList<User>();
		//		this.newsFeed = new ArrayList<String>();
		this.messagesList = new ArrayList<String>();



	}

	public void addMessage(String message){
		messagesList.add(message);
	}

	public void addFollowing(User followingUser){

		followingsList.add(followingUser);

//		if(!IsUserExists(followingsList,followingUser)){
//			followingsList.add(followingUser);
//		}

	}

	public void addFollowers(User userFollowers){

		System.out.println("addFollowers " + userFollowers);
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
	private boolean IsUserExists(List<User> userFollowers, User user) {
		for(User u : userFollowers){
			if(u.equals(userFollowers))
				return true;
		}
		return false;
	}

	
	public String toString(){
		return UserID;
	}
	
	
	/***************************************************************
	 * For Visitor Pattern
	 * Concrete implementation of our Visitable interface
	 **************************************************************/

	@Override
	public void accept(TwitterVisitors twitterVisitors) {
		twitterVisitors.userVisitor(this);
		
	}
	
	/***************************************************************
	 * For Observer Pattern
	 * Add user to the Observer.
	 **************************************************************/

	@Override
	public void addObserver(User user) {
		followingsList.add(user);		
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

}

