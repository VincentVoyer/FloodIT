/**
 * 
 */
package ihm.view;

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
	
	public BoxPanel(GameModel gm, IBox b)
	{
		gm.addObserver(this);
		myBox = b;
		changeColor(b);
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
	}

	
	private void changeColor(IBox box)
	{
		setBackground(Colors.getInstance().getColor(box.getColor()));
		revalidate();
	}
}
