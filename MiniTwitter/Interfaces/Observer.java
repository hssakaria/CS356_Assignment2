/***********************************************************
 * Observer Pattern
 * update to be called by Observable interface
 * 
 * When "Post Twitte" button gets clicked, it will
 * post the message to all the followoings users
 * by calling notifyObserver();
 * @author hetu
 *
 *********************************************************/
public interface Observer {
	
	public void update();

}
