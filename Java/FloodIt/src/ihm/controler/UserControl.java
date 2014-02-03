/**
 * 
 */
package ihm.controler;

import ihm.model.GameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class UserControl implements ActionListener {

	private GameModel gm;
	
	public UserControl(GameModel gm)
	{
		this.gm = gm;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() instanceof AbstractButton)
		{
			AbstractButton button = (AbstractButton)arg0.getSource();
			gm.chageColor(button.getActionCommand());
		}

	}

}
