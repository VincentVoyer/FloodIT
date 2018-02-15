/**
 * 
 */
package ihm.model;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import core.GameManager;
import core.IBox;
import core.Point;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class GameModel extends Observable implements Observer {
	
	private GameManager gameManager;
	
	public GameModel()
	{
		gameManager =GameManager.getInstance();
		gameManager.addObserver(this);
	}
	
	 /** Can get maxRound.
	 * @return the maxRound.
	 */
	public int getMaxRound() {
		return gameManager.getMaxRound();
	}

	/**
	 * Can get currentRound.
	 * @return the currentRound.
	 */
	public int getCurrentRound() {
		return gameManager.getCurrentRound();
	}

	public void changeColor(String color)
	{
		gameManager.changeColor(color);
	}
	
	public Map<Point,IBox> getContent()
	{
		return gameManager.getContent();
	}
	
	public int getHeight()
	{
		return gameManager.getHeight();
	}
	
	public int getWidth()
	{
		return gameManager.getWidth();
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		informer(arg);
	}
	
	private void informer(Object info)
	{
		setChanged();
		notifyObservers(info);
	}

}
