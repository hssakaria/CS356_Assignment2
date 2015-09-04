package Controller;
import java.util.ArrayList;

//import User;

public class UserController {
	
	public UserController(){}
	
	public User getThisObject2(String id, ArrayList<User> listOfAllUsers) {

		User thisNode = null;

		for(int i =0; i<listOfAllUsers.size(); i++){

			thisNode = listOfAllUsers.get(i);
			if(thisNode.getUserID().equals(id)){
				return thisNode;
			}
		}

		return thisNode;

	}

	public User getThisObject(String id, ArrayList<User> listOfAllUsers) {
		
		User thisNode = null;

		for(int i =0; i<listOfAllUsers.size(); i++){

			thisNode = listOfAllUsers.get(i);
			if(thisNode.getUserID().equals(id)){
				return thisNode;
			}
		}

		return thisNode;

	}
	

}
