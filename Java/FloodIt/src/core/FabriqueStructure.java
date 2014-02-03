/**
 * 
 */
package core;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Vincent
 * @date 28 janv. 2014
 */
public class FabriqueStructure {
	
	private static Random rand = new Random();
	
	public static Map<Point,IBox> create(int height,int width){
		Map<Point,IBox> struct = new HashMap<Point, IBox>();
		
		for(int i = 0; i < width ; i++ )
		{
			for(int j = 0; j < height ; j ++)
			{
				struct.put(new Point(i,j),createBox());
			}
		}
		initNeighbour(struct,width,height);
		return struct;
	}
	
	private static Box createBox()
	{
		Box b = new Box(randColor());
		return b;
	}
	
	private static String randColor()
	{
		List<String> colors = Colors.getInstance().getColors();
		
		int num = rand.nextInt() % 6;
		
		if(num <0)
			num *= -1;
		
		return colors.get(num);
		
	}
	
	private static void initNeighbour(Map<Point,IBox> struct,int width,int height)
	{
		width -= 1;
		height -= 1;
		for(int i = 0; i <= width ; i++ )
		{
			for(int j = 0; j <= height ; j ++)
			{
				IBox b = struct.get(new Point(i,j));
				if(i == 0 && j == 0)
				{
					addNeighbour( i+1, j, b, struct);
					addNeighbour(i, j+1, b, struct);
				}
				else if(i == width-1 && j == height - 1)
				{
					addNeighbour( i-1, j, b, struct);
					addNeighbour( i, j-1, b, struct);
				}
				else if(i == 0 && j == height - 1)
				{
					addNeighbour(i+1, j, b, struct);
					addNeighbour(i, j-1, b, struct);
				}
				else if(i == width-1 && j == 0)
				{
					addNeighbour(i-1, j, b, struct);
					addNeighbour(i, j+1, b, struct);
				}
				else if(i == 0 && (j > 0 && j < height - 1))
				{
					addNeighbour(i+1, j, b, struct);
					addNeighbour(i, j-1, b, struct);
					addNeighbour(i, j+1, b, struct);
				}
				else if(i == width-1 && (j > 0 && j < height - 1))
				{
					addNeighbour(i, j-1, b, struct);
					addNeighbour( i-1, j, b, struct);
					addNeighbour( i, j+1, b, struct);
				}
				else if(j == 0 && (i > 0 && i < width - 1))
				{
					addNeighbour(i-1, j, b, struct);
					addNeighbour(i+1, j, b, struct);
					addNeighbour(i, j+1, b, struct);
				}
				else if(j == height - 1 && (i > 0 && i < width - 1))
				{
					addNeighbour( i-1, j, b, struct);
					addNeighbour( i+1, j, b, struct);
					addNeighbour( i, j-1, b, struct);
				}
				else
				{
					addNeighbour( i-1, j, b, struct);
					addNeighbour( i+1, j, b, struct);
					addNeighbour( i, j-1, b, struct);
					addNeighbour( i, j+1, b, struct);
				}
			}
		}
	}
	
	private static void addNeighbour(int i, int j,IBox b,Map<Point,IBox> struct)
	{
		Box box = (Box)b;
		box.addNeighbour(struct.get(new Point(i,j)));
	}
}
