/**
 * 
 */
package ihm.view;

import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ihm.controler.UserControl;
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

	private GameModel gm;
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1227808185588690907L;

	public GamePanel(GameModel gm)
	{
		setGm(gm);
		initPanel();
	}
	
	public GameModel getGm() 
	{
		return gm;
	}

	private void setGm(GameModel gm) 
	{
		this.gm = gm;
		gm.addObserver(this);
	}

	private void initPanel() {
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
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
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
			else if (arg1.equals(UserControl.NEW_GAME))
			{
				gm.deleteObserver(this);
				removeAll();
				initPanel();
			}
			else
			{
				JOptionPane.showMessageDialog(this,arg1);
			}
		}
		
	}

}
