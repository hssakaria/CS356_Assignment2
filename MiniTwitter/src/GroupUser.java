/****************************************************************
 * Using Composite Design Patter. 
 * GroupUser is a composite of multiple Users
 * GroupUser act as a Parent Node. and Users are the Children
 ****************************************************************/
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class GroupUser implements UserComponent {
	
	private String groupID;
	private ImageIcon image;
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	private GroupUser groupUser; //parentGroup
	
	private List<User> userList;

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public GroupUser getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}
	
	public void setParentGroup(GroupUser groupUser){
		this.groupUser = groupUser;
	}
	
	/*********************************************************
	 * Create a new Group ...................grouUser=parent
	 *********************************************************/
	public void setGroup(String userId, GroupUser groupUser){
		
		userList = new ArrayList<User>();
		setGroupID(userId);
		setParentGroup(groupUser);	
			
	}
	
	public String toString(){
		return  "Group_"+ groupID;
	}
	
	public void addUserToGroup(User user){
		userList.add(user);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public boolean IsUserExists(User user){
		for(User us : userList){
			if(us.equals(user)){
				return true;
			}
		}
		return false;
	}
	

}
