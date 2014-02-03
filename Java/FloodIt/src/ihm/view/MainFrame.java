/**
 * 
 */
package ihm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import ihm.controler.UserControl;
import ihm.model.GameModel;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class MainFrame extends JFrame {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -8817705407186564L;

	public MainFrame()
	{
		super("Flood It");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GameModel gm = new GameModel();
		UserControl ctrl = new UserControl(gm);
		JPanel pan = new JPanel(new BorderLayout());
		pan.add(new RoundPanel(gm),BorderLayout.NORTH);
		pan.add(new ActionPanel(ctrl),BorderLayout.CENTER);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pan,BorderLayout.WEST);
		getContentPane().add(new GamePanel(gm),BorderLayout.CENTER);
		
		setSize(new Dimension(700,500));
		setVisible(true);
	}

}
