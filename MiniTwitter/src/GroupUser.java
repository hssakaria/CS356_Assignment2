import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupUser implements User{
	
	private String userID;
	List<User> users = new ArrayList<User>();
	
	
	//constructor
//	public User(){
//		
//	}
	public GroupUser(String userID){
		this.userID = userID;
		
		//user = new ArrayList<User>();
	}
	
	public void add(User user){
		users.add(user);
		
	}
	
	public String getUserID(){
		return userID;
	}
	public List<User> getUser(){
		return users;
	}

	public boolean compareUserID(String newUserID){
		if(users.contains(newUserID)){
			return true;
		}
		else 
			return false;
	}
	
	public String toString(){
		return "User: " + userID;
	}

	@Override
	public void print() {
		System.out.println(users);
	
//
//		
//		Iterator<User> userIterator = users.iterator();
//		while(userIterator.hasNext()){
//			User user = userIterator.next();
//			user.print();
//		}
		
	}

}
