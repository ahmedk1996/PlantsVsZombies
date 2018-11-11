/**
 * The Controller is a class used in the MVC pattern which 
 * will call both game and view in order to update them by the actions from the user.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Controller;
import java.awt.event.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Action;
import Model.CoolDown;
import Model.Game;
import Model.Layout;
import Model.Turn;
import Plant.PlantStore;
import Plant.Plants;
import Plant.ShootingPlant;
import Plant.Sunflower;
import View.View;

public class Controller implements ActionListener {
	
	private Game game;
	private View view;

	private Layout layout;
	private PlantStore ps;
	private Action action;
	public Turn turn;
	private View v;
	private CoolDown coolDownList;
	private int stageNum=0;
	public Controller(Game game, View view, PlantStore ps) {
		this.game=game;
		this.view=view;

		this.ps = ps;
		action = new Action();
		layout = new Layout();
		turn = new Turn();
		initalizeComponents();
		
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
		view.getWaveContinue().setEnabled(true);
		game.setZombieCounter(5); // Easy Mode, once other modes are implemented, spawn zombies based on game mode
		coolDownList = new CoolDown();
	}
	public void actionButton(JButton b) {
	
		b.addActionListener(this);
		b.setActionCommand("button");
		
	}
	public void setZombies() {
		zombieMove(action , layout, ps);
		if(!(game.getZombieCounter() <=1)) {
			int row = layout.placeSpawnZombieOnGrid(layout.getGameGrid());
			view.setZombieOnBoard(row);
			game.setZombieCounter(game.getZombieCounter()-1);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("NewGame")){
			view.getGameFrame().dispose();
			
		}else if(e.getActionCommand().equals("Quit")) {
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Play")) {
		
			view.playPrompt();
			initalizePlay();
			view.zombieInfo(); 
			view.getPoints().setText("Points : " + ps.getSunPoints());
			buttonsInit();
			
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
		
			if(ps.getSunPoints()>=0) {
				int returnVal = purchasePlant();
				if (returnVal ==0) {
					view.setEnabledButtons();
					return;
				}
				view.placePrompt();
				
			}
			view.setEnabledButtons();	
			
		}
		
		else if (e.getActionCommand().equals("simulate")) {
			setZombies();	
			coolDownList.turnOver();
			view.getPoints().setText("Points : " + ps.getSunPoints());
			
			if(game.getZombieCounter() == 0 && stageNum<=1) {
				view.passedStage();
				game.setZombieCounter(4);
				stageNum++;
			}
			view.setEnabledButtons();
		

		}
		else if (e.getActionCommand().equals("button")) {
			
			JButton b = (JButton) e.getSource();
			System.out.println("clicked column " + b.getClientProperty("column")+ ", row " + b.getClientProperty("row"));
			if (view.getGroup().getSelection().getActionCommand().equals("buySunflower")) {
				b.setText("SF");
				view.setEnabledButtons();	
				layout.placePlantOnGrid((int)(b.getClientProperty("column")), (int)b.getClientProperty("row"), new Sunflower() , layout.getGameGrid());
				
			}
			else if (view.getGroup().getSelection().getActionCommand().equals("buyShooterPlant")) {
				b.setText("PS");
				view.setEnabledButtons();	
				layout.placePlantOnGrid((int)(b.getClientProperty("column")), (int)b.getClientProperty("row"), new ShootingPlant() , layout.getGameGrid());
			}
			view.getWaveContinue().setEnabled(true);
			b.setEnabled(false);
			view.getGroup().clearSelection();
		}
				  
	}
	private void buttonsInit() {
		 for (int i =0; i< view.getButtonArray().length ; i++) {
		     for (int j =0; j< view.getButtonArray()[0].length ; j++) {
		    	 	JButton b = new JButton();
		    	 	view.getButtonArray()[i][j] = b;
		    	 	view.getButtonArray()[i][j].putClientProperty("column", i);
		    	 	view.getButtonArray()[i][j].putClientProperty("row", j);
		    		b.addActionListener(this);
		     		view.getBoard().add(b);
		     		b.setActionCommand("button");
		     		view.getButton().add(b);
		     		b.setEnabled(false);
		     }
	     }
	}
	private int purchasePlant() {
		if (ps.getSunPoints()==0) {
			view.updateStatusText("Not Enough Sun Points.");
			view.setEnabled(false);
			return 0 ;
		}
		
		else if (view.getGroup().getSelection().getActionCommand().equals("buyShooterPlant")) {
			Plants sp = new ShootingPlant(); 
			int updatePoints = ps.validatePurchase(sp, ps.getSunPoints());
		
			if (updatePoints == -1) {
				view.getStatus().setText("Not Enough Sun Points");
				return 0;
			}else {
				if(coolDownList.validatePurchase(sp)) {
					ps.purchase(sp, ps.getSunPoints());
					coolDownList.purchasePlant(sp);
					
					view.updatePointsText(String.valueOf(ps.getSunPoints()));
					view.getPurchase().setEnabled(false);
				}else {
					view.getStatus().setText("CoolDown is remaining! Wait for " + coolDownList.getPlantQueue(sp).getRemaining());
					return 0;
				}
			}
			//view.updatePointsText(String.valueOf(updatePoints));
		}
		else if (view.getGroup().getSelection().getActionCommand().equals("buySunflower")) {
			Plants sf = new Sunflower(); 
			int updatePoints = ps.validatePurchase(sf, ps.getSunPoints());
			if (updatePoints == -1) {
				view.getStatus().setText("Not Enough Sun Points");
				return 0;
			}else {
				if(coolDownList.validatePurchase(sf)) {
					ps.purchase(sf, ps.getSunPoints());
					coolDownList.purchasePlant(sf);
					view.updatePointsText(String.valueOf(ps.getSunPoints()));
					view.getPurchase().setEnabled(false);
				}else {
					view.getStatus().setText("CoolDown is remaining! Wait for " + coolDownList.getPlantQueue(sf).getRemaining());
					return 0;
				}
			}
		}
		
		return 1;
	}
	
	public  void ZombieDead(int row, int col , int count){
		System.out.println(count);
	}
	
	public void zombieMove(Action ac , Layout layout, PlantStore ps) {
		view.updateZombie(ac , layout.getGameGrid(), layout , ps);
		
	}

}
	
