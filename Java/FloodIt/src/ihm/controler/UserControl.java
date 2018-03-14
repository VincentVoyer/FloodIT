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

	public static final String NEW_GAME = "NEW_GAME";
	
	/**
	 * Game model.
	 */
	private GameModel gm;
	
	/**
	 * Construct controler from game model.
	 * @param gm
	 */
	public UserControl(GameModel gm)
	{
		setGm(gm);
	}
	
	/**
	 * Default controler.
	 */
	public UserControl()
	{
		setGm(new GameModel());
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource() instanceof AbstractButton)
		{
			AbstractButton button = (AbstractButton)arg0.getSource();
			if (button.getActionCommand() == NEW_GAME)
				reload();
			else
				changeColor(button);			
		}
		
	}
	
	/**
	 * Reload game.
	 */
	private void reload() {
		gm.reload();
	}
	
	/**
	 * Apply new selected color.
	 * @param button which select new color.
	 */
	private void changeColor(AbstractButton button) {
		gm.changeColor(button.getActionCommand());
	}

	/**
	 * @return Game model.
	 */
	public GameModel getGm() {
		return gm;
	}

	/**
	 * @param gm Game model to set.
	 */
	private void setGm(GameModel gm) {
		if (gm == null)
		{
			throw new NullPointerException("Game model should be define to initialize Game controler.");
		}
		
		this.gm = gm;
	}

	public void refresh() {
		gm.refresh();
	}

}
