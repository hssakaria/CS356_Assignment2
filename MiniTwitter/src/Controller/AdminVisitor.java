package Controller;


public class AdminVisitor implements TwitterVisitors {


	private int totalUsers;
	private int totalGroupUsers;
	private int totalMessages=0;
	private int totalPossitiveMessages = 0;


	@Override
	public void userVisitor(User user) {
		totalUsers++;

	}

	@Override
	public void groupVisitor(GroupUser groupUser) {
		totalGroupUsers++;
	}

	/**********************************************
	 * check if message contains positive words
	 * and count total messages
	 * @param msg
	 ***********************************************/
	public void setTotalMessages(String msg){

		findPositiveMessages(msg);

		totalMessages++;

	}
	/**********************************************
	 * check if message contains positive words
	 * @param msg
	 ***********************************************/
	private void findPositiveMessages(String msg) {

		String[] message =  {msg.toLowerCase()};
		boolean IsmessageIsPositive = false;
		for(int i =0; i<message.length; i++){

			if(message[i].equals("good")
					||message[i].equals("hello")
					||message[i].equals("great")
					||message[i].equals("wonderful")){

				IsmessageIsPositive = true;

			}

			if(IsmessageIsPositive == true){
				calculateTotalPositiveMsg();
			}
		}

	}

	public void calculateTotalPositiveMsg() {

		totalPossitiveMessages++;
	}

	public double getTotalPositivePercent() {
		
		double totalMsg = (double) getTotalMessages();
		double totalPostMsg = (double) getTotalPossitiveMessages();

		return (totalPostMsg/totalMsg)*100;

	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public int getTotalMessages() {
		return totalMessages;
	}

	public int getTotalGroupUsers() {
		return totalGroupUsers;
	}

	public int getTotalPossitiveMessages() {
		return totalPossitiveMessages;
	}

}
