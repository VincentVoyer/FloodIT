/**
 * 
 */
package core;

import java.util.Map;
import java.util.Observer;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class Board {

	@SuppressWarnings("unused")
	private Colors c = Colors.getInstance();
	
	/**
	 * start.
	 */
	private Box start;
	
	/**
	 * content.
	 */
	private Map<Point,IBox> content;
	
	/**
	 * height.
	 */
	private int height;
	
	/**
	 * width.
	 */
	private int width;
		
	public Board(Observer obs)
	{
		this(14,14,obs);
	}
	
	public Board(int height,int width, Observer obs)
	{
		Map<Point,IBox> struct = FabriqueStructure.create(height,width);
		for(IBox current : struct.values())
		{
			Box c = (Box)current;
			c.addObserver(obs);
		}
			
		
		setHeight(height);
		setWidth(width);
		setStart(struct.get(new Point(0,0)));
		setContent(struct);
	}


	/**
	 * Can get height.
	 * @return the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Can get width.
	 * @return the width.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return board's content.
	 */
	public Map<Point,IBox> getContent()
	{
		return content;
	}
	/**
	 * modify start.
	 * @param start the start to set
	 */
	private void setStart(IBox start) {
		this.start = (Box)start;
	}

	/**
	 * modify content.
	 * @param content the content to set
	 */
	private void setContent(Map<Point,IBox> content) {
		this.content = content;
	}

	/**
	 * modify height.
	 * @param height the height to set
	 */
	private void setHeight(int height) {
		this.height = height;
	}

	/**
	 * modify width.
	 * @param width the width to set
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Change color.
	 * @param newColor new Color.
	 */
	public int change(String newColor)
	{
		String oldColor = start.getColor();
		return start.changeColor(newColor, oldColor);
	}
	
	public void refresh()
	{
		for(IBox current : content.values())
		{
			Box c = (Box)current;
			c.refresh();
		}
	}
	
	public void unsubscribe(Observer obs)
	{
		for(IBox current : content.values())
		{
			Box c = (Box)current;
			c.deleteObserver(obs);
		}
	}
	
	public int getBoxPainted(){
		int total = 0;
		
		for (Point p : content.keySet())
		{
			Box b = (Box) content.get(p);
			total += b.getBoxPaintIn(start.getColor());
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
}
