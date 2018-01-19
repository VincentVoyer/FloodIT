/**
 * 
 */
package ihm.view;

import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ihm.model.GameModel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.IBox;
import core.Point;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class GamePanel extends JPanel implements Observer {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1227808185588690907L;

	public GamePanel(GameModel gm)
	{
		setLayout(new GridLayout(14,14));
		Map<Point,IBox> content =  gm.getContent();
		int width = gm.getHeight() - 1;
		int height = gm.getWidth() - 1;
		
		for(int i = 0; i <= width; i++)
		{
			for(int j = 0; j <= height ; j ++)
			{
				add(new BoxPanel(gm, content.get(new Point(i,j))));
			}
		}
		
		gm.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Add renew game
		if(arg1 instanceof String)
		{
			if(arg1.equals("ENDWIN"))
			{
				JOptionPane.showMessageDialog(this,"Fin de la partie !\n Vous avez gagner !");
			}
			else if(arg1.equals("ENDLOSE"))
			{
				JOptionPane.showMessageDialog(this,"Fin de la partie !\n Vous avez perdu TTxTT !");
			}
			else
				JOptionPane.showMessageDialog(this,arg1);
		}
		
	}

}
