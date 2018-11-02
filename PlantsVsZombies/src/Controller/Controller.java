package Controller;
import java.awt.event.*;

import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import View.View;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;
	private Layout layout;
	private PlantStore store;
	
	public Controller(Game game, View view) {
		this.game=game;
		this.view=view;
		initalizeComponents();
	}

	private void initalizeComponents() {
		
		view.getNewGame().addActionListener(this);
		view.getNewGame().setActionCommand("NewGame");
		view.getQuit().addActionListener(this);
		view.getQuit().setActionCommand("Quit");
		view.getUndo().addActionListener(this);
		view.getUndo().setActionCommand("Undo");
		view.getRedo().addActionListener(this);
		view.getRedo().setActionCommand("Redo");
		view.getGameDiffuclty().addActionListener(this);
		view.getGameDiffuclty().setActionCommand("Diff");
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals("NewGame")){
			
			 layout = new Layout();
			 
			 store = new PlantStore();
			 // We will test wave by after using beginWave = new wave(1);
		     game = new Game(layout, store);
			 game.promptStart();
			
		}else if(e.getSource().equals("Quit")) {
			System.exit(0);
		}
		
		
	
		
	}

}
