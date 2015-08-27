import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AdminVisitor implements TwitterVisitors {


	private int totalUsers;
	private int totalGroupUsers;

	private int totalMessages=0;
	private String[] positivewords = {"hello","great","good","wonderful","joy", "Marvelous","Trust","Well"}; 
	private double totalPossitiveMessages;
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
	 * @param msg
	 ***********************************************/
	public void setTotalMessages(String msg){

		
	
		String[] message = new String[] {msg.toLowerCase()};
		boolean IsmessageIsPositive = false;
		for(String ms: message){
			for(String words : positivewords){

				if(ms.equals(words)){
					IsmessageIsPositive = true;
				}
			}
		}

		if(IsmessageIsPositive){
			calculateTotalPositiveMsg();
		}
		totalMessages++;

	}
	public void calculateTotalPositiveMsg() {

		totalPossitiveMessages++;

	}
	
	public double getTotalPositivePercent(){
		
		if(totalMessages != 0){
			
			return totalPossitiveMessages/totalMessages*100;
		}
		
		return 0.0;
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



}
