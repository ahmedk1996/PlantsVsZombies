package View;

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
	
	private Controller control;
	private Game game;
	private Layout layout;
	private PlantStore plantStore;
	private JMenuBar menuBar;
	private JMenu gameMenu;
	private JMenu menu;
	private JMenuItem newGame;
	private JMenuItem quit;
	private JMenuItem undo;
	private JMenuItem redo;
	
	
	public View() {
		
		plantStore = new PlantStore();
		layout = new Layout();
		game = new Game(layout, plantStore);
		control = new Controller(game,this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);

		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		gameMenu = new JMenu("Game");
		menu = new JMenu("Menu");
		
		menuBar.add(menu);
		menuBar.add(gameMenu);
		
		newGame = new JMenuItem ("newGame");
		newGame.addActionListener(control);
		
		quit = new JMenuItem ("quit");
		quit.addActionListener(control);
		
		undo = new JMenuItem ("undo");
		undo.addActionListener(control);
		
		redo = new JMenuItem ("redo");
		redo.addActionListener(control);
		
		menu.add(newGame);
		menu.add(quit);
		gameMenu.add(redo);
		gameMenu.add(undo);


		
		
	
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args)
	{
		new View();
	}

	

}
