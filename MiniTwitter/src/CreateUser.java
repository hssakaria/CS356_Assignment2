
public class CreateUser implements User {


	private String newUserID;
	


	public CreateUser(String newUserID) {
		this.newUserID = newUserID;
		}

	@Override
	public String getUserID() {
		return newUserID;
	}

	@Override
	public void add(User user) {}

	@Override
	public void print() {
		System.out.println("UserID: " + newUserID);		
	}

}
