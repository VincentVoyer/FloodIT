/**
 * 
 */
package tests;

import org.junit.Assert;
import org.junit.Test;

import core.Box;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class BoxTest {
	
	private String red = "Red";
	private String green = "Green";
	private String yellow = "Yellow";
	
	private Box start = new Box(red);
	private Box b12 = new Box(yellow);
	private Box b21 = new Box(yellow);
	private Box b22 = new Box(green);
	
	@Test
	public void createBox()
	{
		Box b = new Box("Red");
		
		Assert.assertNotNull(b);
	}
	
	@Test
	public void getterBox()
	{
		Box b = new Box(red);
		
		Assert.assertEquals(red, b.getColor());
	}
	
	@Test
	public void floodSystem()
	{
		init();

		start.changeColor(red,red);
		Assert.assertEquals(red, start.getColor());
		
		System.out.println("change red to yellow");
		start.changeColor(yellow,red);
		Assert.assertEquals(yellow, start.getColor());
		
		start.changeColor(green,yellow);
	
		int nbGreenCase = 0;
		if(start.getColor().equals(green))
			nbGreenCase++;
		if(b12.getColor().equals(green))
			nbGreenCase++;
		if(b21.getColor().equals(green))
			nbGreenCase++;
		if(b22.getColor().equals(green))
			nbGreenCase++;
		
		Assert.assertEquals(nbGreenCase, 4);

	}
	
	private void init()
	{
		start.addNeighbour(b12);
		start.addNeighbour(b21);
		
		b21.addNeighbour(start);
		b21.addNeighbour(b22);
		
		b12.addNeighbour(start);
		b12.addNeighbour(b22);
		
		b22.addNeighbour(b12);
		b22.addNeighbour(b21);
	}

}
