/**
 * 
 */
package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Vincent
 * @date 28 janv. 2014
 */
public class Colors {
	private Map<String,Color> colors;
	
	private static Colors instance = null;
	
	private Colors()
	{
		colors = new ConcurrentHashMap<>();
		
		colors.put("Red", Color.RED);
		colors.put("Yellow", Color.YELLOW);
		colors.put("Green", Color.GREEN);
		colors.put("Gray", Color.GRAY);
		colors.put("Pink", Color.PINK);
		colors.put("Magenta", Color.MAGENTA);
	}
	
	public synchronized static Colors getInstance()
	{
		if(instance ==null)
			instance = new Colors();
		
		return instance;
	}
	
	public List<String> getColors()
	{
		return new ArrayList<String>(colors.keySet());
	}
	
	public Color getColor(String colorKey)
	{
		if(colors.containsKey(colorKey))
			return colors.get(colorKey);
		
		return null;
	}
}
