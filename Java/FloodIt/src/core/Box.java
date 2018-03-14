/**
 * 
 */
package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class Box extends Observable implements IBox {
	private static Object locker = new Object();
	private static int ID = 0;
	
	private int myId;
	
	/** Box Color.*/
	private String color;
	
	/**
	 * neighbours of box.
	 */
	private List<IBox> neighbours;
	
	/**
	 * Create instance of Box.java.
	 * @param color
	 */
	public Box(String color) {
		super();
		setColor(color);
		neighbours = new ArrayList<>();
		synchronized (locker) {
			myId = ID;
			ID++;
		}
	}


	/**
	 * Can get color.
	 * @return the color.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * modify color.
	 * @param color the color to set
	 */
	private void setColor(String color) {
		if(color != null)
		{
			this.color = color;
			informer(this);
		}
	}
	
	/**
	 * Add box's neighbour.
	 * @param neighbour new neighbour.
	 */
	public void addNeighbour(IBox neighbour)
	{
		if(neighbour != null)
			neighbours.add(neighbour);
	}
	
	/**
	 * Change box's color.
	 * @param newColor new color of box.
	 * @param oldColor old color of box.
	 */
	public int changeColor(String newColor, String oldColor)
	{
		int nbCaseChanged = 0;
		if(newColor != null && oldColor != null)
		{			
			if(!color.equals(newColor) && color.equals(oldColor))
			{
				nbCaseChanged++;
				setColor(newColor);
				for(IBox neighbour : neighbours)
				{
					Box b = (Box)neighbour;
					nbCaseChanged += b.changeColor(newColor,oldColor);
				}
			}
		}
		
		return nbCaseChanged;
	}
	
	/**
	 * refresh color.
	 */
	public void refresh() {
		informer(this);
	}
	
	/**
	 * @param color to compare.
	 * @return 1 if current color equals color give in parameter.
	 */
	public int getBoxPaintIn(String color){
		if (getColor().equals(color)) 
		{
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * Inform observers.
	 * @param info
	 */
	private void informer(Object info)
	{
		setChanged();
		notifyObservers(info);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		if (myId != other.myId)
			return false;
		return true;
	}
}
