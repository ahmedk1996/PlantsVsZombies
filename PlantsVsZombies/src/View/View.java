/*package View;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

import Controller.Controller;
import Model.Game;
import Model.Layout;
import Plant.PlantStore;

public class View extends JFrame{
	
	*//**
	 * 
	 *//*
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
	private JRadioButton easyButton;
	private JRadioButton mediumButton;
	private JRadioButton hardButton;
	private ButtonGroup group;
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
		frame.setSize(500, 500);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		gameMenu = new JMenu("Game");
		gameMenu.setEnabled(false);
		selectButtonsPanel = new JPanel();
		frame.add(selectButtonsPanel);
		selectButtonsPanel.setLayout(null);
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
		levelLabel.setFont(new Font("Comic Sans", Font.BOLD, 14));
		levelLabel.setBounds(175,10, 250, 100);
		selectButtonsPanel.add(levelLabel);


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public JMenu getGameMenu() {
		return gameMenu;
	}
	
	public static void main(String[] args)
	{
		new View();
	}

	

}
*/