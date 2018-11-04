package Controller;
import java.awt.event.*;

import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import View.View;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;

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
		view.getPlay().addActionListener(this);
		view.getPlay().setActionCommand("Play");
		view.getHelp().setActionCommand("Help");
		view.getHelp().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("NewGame")){
			
			
			
		}else if(e.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Play")) {
			view.playPrompt();
		}
		else if (e.getActionCommand().equals("Help")) {
			view.helpPrompt();
		}
		
		
	
		
	}

}
