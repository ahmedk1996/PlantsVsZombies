/**
 * The Controller is a class used in the MVC pattern which 
 * will call both game and view in order to update them by the actions from the user.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Controller;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import View.View;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;
	private Integer row=0;
	public Controller(Game game, View view) {
		this.game=game;
		this.view=view;
		initalizeComponents();
	}
	public Controller() {
		
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
		view.getEasy().addActionListener(this);
		view.getEasy().setActionCommand("easy");
		view.getMed().addActionListener(this);
		view.getMed().setActionCommand("med");
		view.getHard().addActionListener(this);
		view.getHard().setActionCommand("Hard");
	

	}
	
	public void initalizePlay() {
		view.getPurchase().addActionListener(this);
		view.getPurchase().setActionCommand("Purchase");
		view.getBuyPeaShooter().addActionListener(this);
		view.getBuyPeaShooter().setActionCommand("buyShooterPlant");
		view.getBuySunflower().addActionListener(this);
		view.getBuySunflower().setActionCommand("buySunflower");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("NewGame")){
			
		}else if(e.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Play")) {
			
			view.playPrompt();
			//view.zombieInfo(); remove AFTER !?
			view.getPoints().setText("Points : " + game.getStore().getSunPoints());
			initalizePlay();
			game.setZombieCounter(4); // Easy Mode, once other modes are implemented, spawn zombies based on game mode
			game.start();
			
			
		}
		else if (e.getActionCommand().equals("Help")) {
			view.helpPrompt();
		}
		else if (e.getActionCommand().equals("easy") ||e.getActionCommand().equals("med") ||e.getActionCommand().equals("Hard") ) {
			view.getPlay().setEnabled(true);
			
		}
		else if(e.getActionCommand().equals("buyShooterPlant") || e.getActionCommand().equals("buySunflower") ) {
			view.getPurchase().setEnabled(true);
			
		}
		else if(e.getActionCommand().equals("Purchase")) {
			
		
			boolean isValidNumber = false;
			try {
				 row = Integer.parseInt(JOptionPane.showInputDialog(null, "What row number would you like to place the plant?", "Plant Placement", JOptionPane.QUESTION_MESSAGE));
			    isValidNumber  = true;
			} catch (NumberFormatException e1) {
			    JOptionPane.showMessageDialog(new JPanel(), "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			if(row instanceof Integer) {
				boolean isValidNumber1 = false;
				try {
					int column = Integer.parseInt(JOptionPane.showInputDialog(null, "What column number would you like to place the plant? ", "Plant Placement ", JOptionPane.QUESTION_MESSAGE));
				    isValidNumber1  = true;
				} catch (NumberFormatException e1) {
				    JOptionPane.showMessageDialog(new JPanel(), "Invalid number", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		}
		
		
	
		
	}
	public void addZombie(int randRow, int i) {
		// TODO Auto-generated method stub
		view.setZombieOnBoard(randRow , i);
		
	}

}
