/**
 * 
 */
package core;


import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class GameManager extends Observable implements Observer {
	/**
	 * maxRound.
	 */
	private int maxRound;
	
	/**
	 * currentRound.
	 */
	private int currentRound;
	
	private Board mBoard;
	
	private int nbCaseChanged = 0;
	
	private static GameManager instance = null;
	
	private GameManager()
	{
		maxRound = 25;
		currentRound = 0;
		mBoard = new Board(this);
	}
	
	/**
	 * Can get maxRound.
	 * @return the maxRound.
	 */
	public int getMaxRound() {
		return maxRound;
	}

	/**
	 * Can get currentRound.
	 * @return the currentRound.
	 */
	public int getCurrentRound() {
		return currentRound;
	}

	public void chageColor(String color)
	{

		nbCaseChanged = mBoard.change(color);
		if(nbCaseChanged != 0)
		{
			currentRound ++;
			informer(new Integer(currentRound));
		}
		if(maxRound == currentRound)
			informer("ENDLOSE");
		else if(nbCaseChanged == (getHeight() * getWidth()))
			informer("ENDWIN");
	}
	
	public Map<Point,IBox> getContent()
	{
		return mBoard.getContent();
	}
	
	public int getHeight()
	{
		return mBoard.getHeight();
	}
	
	public int getWidth()
	{
		return mBoard.getWidth();
	}
	
	public static GameManager getInstance()
	{
		if(instance == null)
			instance = new GameManager();
		
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		informer(arg1);
	}
	
	private void informer(Object info)
	{
		setChanged();
		notifyObservers(info);
	}

}
