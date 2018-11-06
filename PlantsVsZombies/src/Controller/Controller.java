/**
 * The Controller is a class used in the MVC pattern which 
 * will call both game and view in order to update them by the actions from the user.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Controller;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import Plant.Plants;
import Plant.ShootingPlant;
import Plant.Sunflower;
import View.View;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;
	private Integer row=0;
	private Layout layout;
	private PlantStore ps;
	public Controller(Game game, View view) {
		this.game=game;
		this.view=view;
		layout = new Layout();
		ps = new PlantStore();
		initalizeComponents();
	}
	public Controller() {
		
	}

	public void initalizeComponents() {
		
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
		view.getWaveContinue().addActionListener(this);
		view.getWaveContinue().setActionCommand("simulate");
		
	}

	public void actionButton(JButton b) {
		// TODO Auto-generated method stub
		b.addActionListener(this);
	}
	public void setZombies() {
		game.setZombieCounter(4); // Easy Mode, once other modes are implemented, spawn zombies based on game mode
		if(!(game.getZombieCounter() <=1)) {
			int row = layout.placeSpawnZombieOnGrid();
			view.setZombieOnBoard(row);
		}
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
			
			purchasePlant();
			view.getCoordinates();
			view.setPlantOnBoard();
			
			
		}

		
		else if (e.getActionCommand().equals("simulate")) {
			setZombies();		
		}
	
		


	}
	private void purchasePlant() {
		if (ps.getSunPoints() ==0) {
			view.updateStatusText("Not Enough Sun Points.");
		}
		if (view.getGroup().getSelection().getActionCommand().equals("buyShooterPlant")) {
			Plants sp = new ShootingPlant(); 
			int updatePoints = ps.validatePurchase(sp, ps.getSunPoints());
			if (updatePoints == -1) {
				view.updatePointsText("Not Enough Sun Points");
				return;
			}
			
			view.updatePointsText(String.valueOf(updatePoints));
		}
		else if (view.getGroup().getSelection().getActionCommand().equals("buySunflower")) {
			Plants sf = new Sunflower(); 
			int updatePoints = ps.validatePurchase(sf, ps.getSunPoints());
			if (updatePoints == -1) {
				view.updatePointsText("Not Enough Sun Points");
				return;
			}
			view.updatePointsText(String.valueOf(updatePoints));
		}
		
	}
}
	
