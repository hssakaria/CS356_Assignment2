/*****************************
 * Observer Pattern
 * Observer interface maintains a list of Observers
 * @author hetu
 *
 */
public interface Observable {
	
	public void addObserver(Observer o);
	public void notifyObserver();
	
	
}
