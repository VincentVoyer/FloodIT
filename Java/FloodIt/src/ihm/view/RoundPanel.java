/**
 * 
 */
package ihm.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import ihm.controler.UserControl;
import ihm.model.GameModel;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Vincent
 * @date 3 févr. 2014
 */
public class RoundPanel extends JPanel implements Observer{
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -710797949855679352L;
	private JLabel currentRound;
	private GameModel gm;
	
	public RoundPanel(GameModel gm)
	{
		this.gm = gm;
		gm.addObserver(this);
		initPanel();
	}

	private void initPanel() {
		setCurrentRound(gm.getCurrentRound());
		add(new JLabel("Round : "));
		add(currentRound);
		add(new JLabel(" / " + gm.getMaxRound()));
		setBackground(Color.WHITE);
	}

	private void setCurrentRound(int currentRound2) {
		if(currentRound == null)
			currentRound = new JLabel();
		
		StringBuilder sb = new StringBuilder();
		sb.append(currentRound2);
		currentRound.setText(sb.toString());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Integer)
		{
			setCurrentRound(gm.getCurrentRound());
			revalidate();
		}	
		else if (arg instanceof String)
		{
			String action = (String) arg;
			if (action.equals(UserControl.NEW_GAME))
			{
				gm.deleteObserver(this);
				removeAll();
				initPanel();
			}
		}
			
	}
}
