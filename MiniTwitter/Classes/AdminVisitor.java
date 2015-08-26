
public class AdminVisitor implements TwitterVisitors {
	
	
	private int totalUsers;
	private int totalGroupUsers;
	
	private int totalMessages;
	private String[] positivewords = {"great","good","wonderful","joy", "Marvelous","Trust","Well"}; 
	private double positiveMsg;
	

	@Override
	public void userVisitor(User user) {
		totalUsers++;
		
	}

	@Override
	public void groupVisitor(GroupUser groupUser) {
		totalGroupUsers++;
	}

	public void setTotalMessages(String msg){
		
		
		
		
		
		
		
		
		
		
		totalMessages++;
		
	}
	public int getTotalUsers() {
		return totalUsers;
	}

	public int getTotalGroupUsers() {
		return totalGroupUsers;
	}

	public int getTotalMessages() {
		return totalMessages;
	}


}
