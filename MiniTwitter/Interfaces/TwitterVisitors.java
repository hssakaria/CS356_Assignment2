
/*******************************************************************
 * Visitor Pattern
 * TwitterVisitors interface provide different types of concrete
 * elements
 * @author hetu
 *
 ******************************************************************/

public interface TwitterVisitors {
	
	public void userVisitor(User user);
	public void groupVisitor(GroupUser groupUser);

}
