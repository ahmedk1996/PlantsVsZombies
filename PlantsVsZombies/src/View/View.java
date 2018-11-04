/**
 * The 	View is a class which extends JFrame and includes getters 
 * and setters for the different types of buttons and menu objects 
 * used to be called in the Controller class.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.nio.file.Files;

import javax.swing.*;

import Controller.Controller;
import Model.Game;
import Model.Layout;
import Plant.PlantStore;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Controller control;
	private JMenuBar menuBar;
	private JMenu gameMenu;
	private JMenu menu;
	private JMenuItem newGame;
	private JMenuItem quit;
	private JMenuItem undo;
	private JMenuItem redo;
	private JButton gameDiffuclty;
	private JPanel selectButtonsPanel;
	private JLabel levelLabel;
	private ButtonGroup group;
	private JCheckBox easy;
	private JCheckBox med;
	private JCheckBox hard;
	private JButton play;
	private JButton help;
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getHelp() {
		return help;
	}
	public void setHelp(JButton help) {
		this.help = help;
	}
	public JButton getPlay() {
		return play;
	}
	public void setPlay(JButton play) {
		this.play = play;
	}
	public View() {
		initalizeComponents();

	}
	public JMenuItem getNewGame() {
		return newGame;
	}

	public void setNewGame(JMenuItem newGame) {
		this.newGame = newGame;
	}

	public JMenuItem getQuit() {
		return quit;
	}

	public void setQuit(JMenuItem quit) {
		this.quit = quit;
	}

	public JMenuItem getUndo() {
		return undo;
	}

	public void setUndo(JMenuItem undo) {
		this.undo = undo;
	}

	public JMenuItem getRedo() {
		return redo;
	}

	public void setRedo(JMenuItem redo) {
		this.redo = redo;
	}

	public JButton getGameDiffuclty() {
		return gameDiffuclty;
	}

	public void setGameDiffuclty(JButton gameDiffuclty) {
		this.gameDiffuclty = gameDiffuclty;
	}

	public JPanel getSelectButtonsPanel() {
		return selectButtonsPanel;
	}

	public void setSelectButtonsPanel(JPanel selectButtonsPanel) {
		this.selectButtonsPanel = selectButtonsPanel;
	}
	
	private void initalizeComponents() {
		frame = new JFrame ("Plants Vs. Zombies");
		frame.setSize(450, 300);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		gameMenu = new JMenu("Game");
		gameMenu.setEnabled(false);
		selectButtonsPanel = new JPanel();
		frame.add(selectButtonsPanel);
		
		menu = new JMenu("Menu");
		menuBar.add(menu);
		menuBar.add(gameMenu);
		quit = new JMenuItem ("Quit");
		undo = new JMenuItem ("Undo");
		redo = new JMenuItem ("Redo");
		newGame = new JMenuItem ("New Game");
		menu.add(newGame);
		menu.add(quit);
		gameMenu.add(redo);
		gameMenu.add(undo);
		gameDiffuclty =  new JButton ("Select");
		levelLabel = new JLabel("Select Difficulty: ");
		levelLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
	
		levelLabel.setBounds(175,10, 250, 100);
		selectButtonsPanel.add(levelLabel);
		
		easy= new JCheckBox("Easy");
		med = new JCheckBox("Medium");
		hard = new JCheckBox("Hard");
		group = new ButtonGroup();
		selectButtonsPanel.add(easy);
		selectButtonsPanel.add(med);
		selectButtonsPanel.add(hard);
		
		group.add(easy);
		group.add(med);
		group.add(hard);
		
		play = new JButton();
		play.setText("Start");
		help = new JButton();
		help.setText("Help");
		selectButtonsPanel.add(play);
		selectButtonsPanel.add(help);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public JMenu getGameMenu() {
		return gameMenu;
	}
	

	public void playPrompt() {
		
		
	}
	public void helpPrompt() {
		String helpText= "	Help - How to play Plants Vs Zombies.\r\n" + 
				" \r\n" + 
				"--------------------------------------------------------------------\r\n" + 
				"	The goal of this game is to defense from the zombies.\r\n" + 
				"\r\n" + 
				"Each Difficulty contains different numbers and type of zombies. \r\n" + 
				"\r\n" + 
				"Sun-point is the virtual Money to purchase the plants in the store. \r\n" + 
				"PeaShooter Plant - PeaShooter attacks zombie in the same row.\r\n" + 
				"Sun-flower - The user can get 50 Sun-points on each wave. \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Each wave, \r\n" + 
				"One zombie is randomly spawned in the board.\r\n" + 
				"The user purchases the plants according to your own Strategies.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Once the user purchases the plants, \r\n" + 
				"\r\n" + 
				"the user can place the plants on the board by typing row and column.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"			Good Luck!! \r\n" + 
				"\r\n" + 
				"--------------------------------------------------------------------";
		JOptionPane.showMessageDialog(frame, helpText);
		
	}

	

}
