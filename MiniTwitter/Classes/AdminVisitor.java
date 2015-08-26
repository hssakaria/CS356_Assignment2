
public class AdminVisitor implements TwitterVisitors {
	
	
	private int totalUsers = 0;
	private int totalGroupUsers =0;
	private int totalMessages =0;
	
	

	@Override
	public void userVisitor(User user) {
		totalUsers++;
		
	}

	@Override
	public void groupVisitor(GroupUser groupUser) {
		totalGroupUsers++;
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
