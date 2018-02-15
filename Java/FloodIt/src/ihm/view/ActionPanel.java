/**
 * 
 */
package ihm.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ihm.controler.UserControl;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.Colors;

/**
 * @author Vincent
 * @date 28 janv. 2014
 */
public class ActionPanel extends JPanel implements Observer{
	
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -4611258048700578062L;

	private List<JButton> buttons = new ArrayList<>();
	
	private UserControl ctrl;
	
	public ActionPanel(UserControl ctrl)
	{
		setCtrl(ctrl);
		initPanel();
	}
	
	public UserControl getCtrl() {
		return ctrl;
	}

	private void setCtrl(UserControl ctrl) {
		this.ctrl = ctrl;
		ctrl.getGm().addObserver(this);
	}

	private void initPanel() {
		setLayout(new GridLayout(2,3));
		for(String color : Colors.getInstance().getColors())
		{
			JButton btn = createButton(color, color, ctrl);
			add(btn);
			buttons.add(btn);
		}
	}
	
	private JButton createButton(String nom, String actionCommand, ActionListener action)
	{
		JButton button = new JButton(nom);
		button.setActionCommand(actionCommand);
		button.addActionListener(action);
		button.setBackground(Colors.getInstance().getColor(nom));
		return button;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof String)
		{
			String action = (String) arg;
			
			if (action.contains("END"))
			{
				for(JButton btn : buttons)
					btn.setEnabled(false);
			}
			else if (action.equals(UserControl.NEW_GAME))
			{
				removeAll();
				initPanel();
			}
		}
		
	}
}
