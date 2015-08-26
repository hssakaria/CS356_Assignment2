import java.util.ArrayList;

public class UserController {
	
	public UserController(){}
	
	public User getThisObject(String id, ArrayList<User> listOfAllUsers) {

		User thisNode = null;
		System.out.println("get-->  "+ listOfAllUsers);
		System.out.println("get--->  "+ id);

		for(int i =0; i<listOfAllUsers.size(); i++){

			thisNode = listOfAllUsers.get(i);
			if(thisNode.getUserID().equals(id)){
				return thisNode;
			}
		}

		return thisNode;

	}
	

}
