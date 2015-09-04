package Controller;
/****************************************************************
 * Using Composite Design Patter. 
 * User is a leaf - 
 ****************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

import TwitterUI.UserTwitterUI;

/*
 * Leaf Node
 */

public class User  extends Observable implements Visitable, Observer{

	private User user;
	private String userID;
	private String groupID;
	private String userMessage;
	private String message;
	private  List<User> followingsList;
	private List<String> messagesList;
	private List<String> newsFeed;
	private TwitterVisitors twitterVisitors;
	private UserTwitterUI userTwitterUI;
	private AdminVisitor adminVisitor = new AdminVisitor();

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
		this.newsFeed = new ArrayList<String>();
		this.messagesList = new ArrayList<String>();

	}

	public User getUser(){
		return user;
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

		adminVisitor.setTotalMessages(message);

		newsFeed.add(userID + ": " + message);

		System.out.println(" setChanged() gets called");

		setChanged();

		System.out.println("Notified observers ");

		notifyObservers( newsFeed);

	}

	public void addFollowing(User followingUser){

		if(!IsUserExists(followingsList,followingUser)){

			followingsList.add(followingUser);
			this.addObserver(followingUser);

			System.out.println("Observer "+ this.countObservers());

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
		return userID;
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

	public void setUserTwitter(UserTwitterUI userTwitterUI){
		this.userTwitterUI = userTwitterUI;

	}
	public int getTotalMessages(){
		return adminVisitor.getTotalMessages();
	}

	public int getTotalPositiveMessage(){
		return adminVisitor.getTotalPossitiveMessages();
	}
	public double getTotalPositivePercent(){
		return adminVisitor.getTotalPositivePercent();
	}

	public List<String> getNewsFeed() {
		return newsFeed;
	}

	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public UserTwitterUI getUserTwitterUI() {
		return userTwitterUI;
	}

	public void setUserTwitterUI(UserTwitterUI userTwitterUI) {
		this.userTwitterUI = userTwitterUI;
	}

	@Override
	public void update(Observable userTwitter, Object message) {

		if(userTwitter instanceof User){

			System.out.println("followeruser:" + user + "\t" +   "updated by  --> "+message);

			if(message instanceof String) {

				String newMessage = (String)(message);
				((User) userTwitter).getUserTwitterUI().updateFollowers(newMessage);

			} 
		}
	}

}
