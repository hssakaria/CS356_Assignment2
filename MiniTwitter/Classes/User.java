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

public class User extends AdminVisitor implements Visitable,Observable, Observer{

	private User user;
	private String UserID;
	private String groupID;

	private List<User> registeredUsers;
	private List<User> followersList;
	private  List<User> followingsList;
	private List<String> messagesList;
	private List<String> newsFeed;
	private TwitterVisitors twitterVisitors;
	private AdminVisitor adminVisitor = new AdminVisitor();
	private Observer o;
	private List<Observer> followers;

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
	 * @param listOfUsers 
	 ************************************************************/
	public void addUser(User user, String userID, String groupID){

		this.user = user;
		this.setGroupID(groupID);
		this.setUserID(userID);
		this.followingsList = new ArrayList<User>();
		this.registeredUsers = new ArrayList<User>();
		this.newsFeed = new ArrayList<String>();
		this.messagesList = new ArrayList<String>();
		this.addObserver(user);


	}

	public User getUser(){
		return user;
	}
	/*********************************************
	 * Observer Pattern
	 * Whenever NewsFeed list gets updated, it will
	 * notifiyObserver to inform all the Register
	 * Observer about the change
	 * @param newsFeed
	 ********************************************/


	public void setNewsFeed(List<String> newsFeed) {
		this.newsFeed = newsFeed;

		notifyObserver();

		System.out.println("User Notified");
	}


	/********************************************
	 * Visitor Pattern
	 * Observer Pattern
	 * 
	 * When you message gets posted, Notify
	 * all the registeredUser
	 * @param message
	 ********************************************/
	public void addMessage(String message){

		messagesList.add(message);
		adminVisitor.setTotalMessages(message);
		newsFeed.add("* "+ user.getUserID() + ":  " + message);
		setNewsFeed(newsFeed);

		System.out.println("newsfeed:   " + newsFeed);


	}

	public void addFollowing(User followingUser){

		if(!IsUserExists(followingsList,followingUser)){
			followingsList.add(followingUser);
			followingUser.addObserver(followingUser); 


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
		this.twitterVisitors = twitterVisitors;
		twitterVisitors.userVisitor(user);

	}

	/***************************************************************
	 * For Observer Pattern
	 * Add user to the Observer.
	 **************************************************************/

	@Override
	public void notifyObserver() {
		// Iterate list of all following users(Observers)
		// and call their update method.
		for(User u : registeredUsers ){
			u.update();
		}

	}

	public int getTotalMessages(){
		return adminVisitor.getTotalMessages();
	}

	public double getTotalPositiveMessage(){
		return adminVisitor.getTotalPositivePercent();
	}

	public List<String> getNewsFeed() {
		return newsFeed;
	}


	/**********************************************
	 * Add user to the ObserverList.
	 **********************************************/

	@Override
	public void addObserver(User user) {
		registeredUsers.add(user);

	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


}

