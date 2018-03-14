/**
 * 
 */
package ihm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import ihm.controler.UserControl;
import ihm.model.GameModel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Vincent
 * @date 27 janv. 2014
 */
public class MainFrame 
	extends JFrame 
	implements Observer {

	/**
	 * Game panel.
	 */
	private JPanel pan;
	
	/**
	 * Menu bar.
	 */
	private JMenuBar menuBar;
	
	/**
	 * Game controler.
	 */
	private UserControl ctrl;
	
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -8817705407186564L;

	public MainFrame()
	{
		super("Flood It");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		generateView();
	}

	/**
	 * Generate view.
	 */
	private void generateView() {
		
		ctrl = new UserControl();
		ctrl.getGm().addObserver(this);
				
		generateMenu();
		generateGamePanel();
		
		setSize(new Dimension(700,500));
		setVisible(true);
	}

	/**
	 * Generate game panel.
	 */
	private void generateGamePanel() {
		GameModel gm = ctrl.getGm();
		
		pan = new JPanel(new BorderLayout());
		pan.add(new RoundPanel(gm),BorderLayout.NORTH);
		pan.add(new ActionPanel(ctrl),BorderLayout.CENTER);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pan,BorderLayout.WEST);
		getContentPane().add(new GamePanel(gm),BorderLayout.CENTER);

	}
	
	/**
	 * Generate Menu.
	 */
	private void generateMenu() {
		JMenu menu = new JMenu("Game");
		JMenuItem menuItem = new JMenuItem("New");
		
		menuItem.setActionCommand(UserControl.NEW_GAME);
		menuItem.addActionListener(ctrl);
		menu.add(menuItem);
		
		menuBar = new JMenuBar();		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String)
		{
			String action = (String) arg;
			if (action == UserControl.NEW_GAME)
			{
				setVisible(false);
				//GameModel gm = ctrl.getGm();
				//gm.deleteObserver(this);
				remove(pan);
				generateGamePanel();
				
				//pan.revalidate();				
				//pan.repaint();
				//pan.doLayout();				
				setVisible(true);
				
				revalidate();
				ctrl.refresh();
			}
		}
		
	}

}
