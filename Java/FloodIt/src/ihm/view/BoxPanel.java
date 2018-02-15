/**
 * 
 */
package ihm.view;

import ihm.controler.UserControl;
import ihm.model.GameModel;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import core.Colors;
import core.IBox;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class BoxPanel extends JPanel implements Observer {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 3465767961686294994L;

	private IBox myBox;
	
	private GameModel gm;
	
	public BoxPanel(GameModel gm, IBox b)
	{
		setGm(gm);
		setMyBox(b);
		
		initPanel();
	}

	private void initPanel() {
		changeColor(myBox);
	}

	public IBox getMyBox() {
		return myBox;
	}

	private void setMyBox(IBox myBox) {
		this.myBox = myBox;
	}

	public GameModel getGm() {
		return gm;
	}

	private void setGm(GameModel gm) {
		this.gm = gm;
		gm.addObserver(this);	
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		if(arg instanceof IBox && arg.equals(myBox))
		{
			IBox box = (IBox)arg;
			changeColor(box);
		}
		else if (arg instanceof String)
		{
			String action = (String) arg;
			if (action.equals(UserControl.NEW_GAME))
			{				
				removeAll();
				initPanel();
			}
		}
	}

	
	private void changeColor(IBox box)
	{
		setBackground(Colors.getInstance().getColor(box.getColor()));
		revalidate();
	}
}
