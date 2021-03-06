/**
 * 
 */
package ihm.view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import ihm.model.GameModel;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Vincent
 * @date 3 f�vr. 2014
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
		setCurrentRound(gm.getCurrentRound());
		gm.addObserver(this);
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
		
	}
}
