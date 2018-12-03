package View;

import javax.swing.*;
import java.awt.event.*;

/**
 *  The Intro is a class which just acts as a layer which allows the user to understand what the
 *  game is about. 
 * 
 * 
 * @author Group 1
 * @since November 22,2018

 */

public class Intro{

	/**
	 *  Sets the correct pictures and files on the buttons to show for a pleasent view
	 * 
	 * @param String args [] - arguments passed when the main method is launched
	 * @return None
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame("Popup Menu Demo");

		// build poup menu
		final JPopupMenu popup = new JPopupMenu();
		// New project menu item
		JMenuItem menuItem = new JMenuItem("New Project...",
				new ImageIcon("images/newproject.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.getAccessibleContext().setAccessibleDescription(
				"New Project");
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "New Project clicked!");
			}
		});
		popup.add(menuItem);
		// New File menu item
		menuItem = new JMenuItem("New File...");
		menuItem.setMnemonic(KeyEvent.VK_F);
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "New File clicked!");
			}
		});
		popup.add(menuItem);

		// add mouse listener
		frame.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(),
							e.getX(), e.getY());
				}
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);

	}
}