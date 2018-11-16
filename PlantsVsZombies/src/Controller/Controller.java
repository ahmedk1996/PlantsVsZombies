
package Controller;

import java.awt.event.*;
import javax.swing.JButton;


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
/**
 * The Controller is a class used in the MVC pattern which
 * will call both game and view in order to update them by the actions from the user.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public class Controller implements ActionListener {

	private Game game;
	private View view;

	private Layout layout;
	private PlantStore ps;
	private Action action;
	public Turn turn;
	private CoolDown coolDownList;
	private int stageNum;

	
	public int getStageNum() {
		return stageNum;
	}


	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}


	public Controller(Game game, View view, PlantStore ps) {
		
		this.view = view;
		this.game = game;
		this.ps = ps;
		action = new Action();
		layout = new Layout();
		action.setZombieDeadCounter(0);
		turn = new Turn();
		initalizeComponents();

	}

	
	/**
	 * 	Initialize the components by adding the respective actionlistners/actioncommands to each action used.
	 * 
	 * 	@param None
	 * @return None
	 */
	//Initialize the components by adding the respective actionlistners/actioncommands to each action used.
	public void initalizeComponents() {


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

	/**
	 * 	Initialize the play components by adding the respective actionlistners/actioncommands to each action used.
	 * 
	 * 	@param None
	 * @return None
	 */
	
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
		game.setZombieCounter(4); // Easy Mode, once other modes are implemented, spawn zombies based on game mode
		coolDownList = new CoolDown();
	}

	/**
	 * 	Implementing the waves of zombies in the game.
	 * 
	 * 	@param None
	 * 	@return None
	 */
	public boolean waves() {
		if (action.getZombieDeadCounter() == 3 && stageNum ==0){
			stageNum ++;
			action.setZombieDeadCounter(0);
			game.setZombieCounter(4);
			return true;
		}
		return false;
	}

	public void actionButton(JButton b) {

		b.addActionListener(this);
		b.setActionCommand("button");

	}

	/**
	 * 	sets the zombies on the model gameGrid
	 * 
	 * 	@param None
	 * @return None
	 */
	public void setZombies() {
		boolean nextWave = waves();
		if (nextWave == true){
			view.passedStage();
		}
		
		zombieMove(action, layout, ps);
		if (!(game.getZombieCounter() <= 1)) {
			int row = layout.placeSpawnZombieOnGrid(layout.getGameGrid());
			view.setZombieOnBoard(row);
			game.setZombieCounter(game.getZombieCounter() - 1);
		}
		if (view.checkAllZombiesDead() == false && stageNum ==1 && action.getZombieDeadCounter() == 3){
			view.gameWon();
			return;
		}
		
	}

	/**
	 * 	Action Performed based on the action event pressed on the frame
	 * 
	 * 	@param ActionEvent e - Jbutton or radio button or menuItem
	 * @return None
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("NewGame")) {
	
			view.getGroup().clearSelection();
			view.getPlay().setEnabled(false);
		
		} else if (e.getActionCommand().equals("Quit")) {
			//Will look for a better way to exit the program
			System.exit(0);
		} else if (e.getActionCommand().equals("Play")) {
			//Start the game
			game = null;
			ps = null;
			layout = null;
			
			this.layout = new Layout();
			this.ps = new PlantStore();
			this.game = new Game(layout, ps);
		
			view.getPlay().setEnabled(false);
			view.getGroup().clearSelection();
			view.playPrompt();
			initalizePlay();
			view.zombieInfo();
			ps.setSunPoints(150);
			view.getPoints().setText("Points : " + ps.getSunPoints());
			buttonsInit();
			

		} else if (e.getActionCommand().equals("Help")) {
			view.helpPrompt();
		} else if (e.getActionCommand().equals("easy") || e.getActionCommand().equals("med")
				|| e.getActionCommand().equals("Hard")) {
			view.getPlay().setEnabled(true);

		} else if (e.getActionCommand().equals("buyShooterPlant") || e.getActionCommand().equals("buySunflower")) {
			view.getPurchase().setEnabled(true);

		} else if (e.getActionCommand().equals("Purchase")) {

			if (ps.getSunPoints() >= 0) {
				int returnVal = purchasePlant();
				if (returnVal == 0) {
					view.setAllEnabledFalse();
					return;
				}
				view.placePrompt();

			}
			view.setEnabledButtons();
			view.getWaveContinue().setEnabled(false);

		}

		else if (e.getActionCommand().equals("simulate")) {
			setZombies();
			coolDownList.turnOver();
			view.getPoints().setText("Points : " + ps.getSunPoints());
		
			

		} else if (e.getActionCommand().equals("button")) {

			JButton b = (JButton) e.getSource();
			System.out
					.println("clicked column " + b.getClientProperty("column") + ", row " + b.getClientProperty("row"));
			if (view.getGroup().getSelection().getActionCommand().equals("buySunflower")) {
				b.setText("SF");
				view.setEnabledButtons();
				layout.placePlantOnGrid((int) (b.getClientProperty("column")), (int) b.getClientProperty("row"),
						new Sunflower(), layout.getGameGrid());

			} else if (view.getGroup().getSelection().getActionCommand().equals("buyShooterPlant")) {
				b.setText("PS");
				view.setEnabledButtons();
				layout.placePlantOnGrid((int) (b.getClientProperty("column")), (int) b.getClientProperty("row"),
						new ShootingPlant(), layout.getGameGrid());
			}
			view.getWaveContinue().setEnabled(true);
			view.setAllEnabledFalse();
			view.getGroup().clearSelection();
		}

	}

	/**
	 * 	@param ActionEvent e - 	Initializing the buttons on the board
	 * 	@return None
	 */
	private void buttonsInit() {
		for (int i = 0; i < view.getButtonArray().length; i++) {
			for (int j = 0; j < view.getButtonArray()[0].length; j++) {
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

	/**
	 * PurchasePlant runs all the processes of attacking, buying , generating 
	 * Sun points
	 * 	@return int 0, when there are no sun plants, else 1
	 */
	private int purchasePlant() {
		if (ps.getSunPoints() == 0) {
			view.updateStatusText("Not Enough Sun Points.");
			view.setEnabled(false);
			return 0;
		}

		else if (view.getGroup().getSelection().getActionCommand().equals("buyShooterPlant")) {
			Plants sp = new ShootingPlant();
			int updatePoints = ps.validatePurchase(sp, ps.getSunPoints());

			if (updatePoints == -1) {
				view.getStatus().setText("Not Enough Sun Points");
				view.setAllEnabledFalse();
				return 0;
			} else {
				if (coolDownList.validatePurchase(sp)) {
					ps.purchase(sp, ps.getSunPoints());
					coolDownList.purchasePlant(sp);

					view.updatePointsText(String.valueOf(ps.getSunPoints()));
					view.getPurchase().setEnabled(false);
				} else {
					view.getStatus().setText(
							"CoolDown is remaining! Wait for " + coolDownList.getPlantQueue(sp).getRemaining());
					return 0;
				}
			}

		} else if (view.getGroup().getSelection().getActionCommand().equals("buySunflower")) {
			Plants sf = new Sunflower();
			int updatePoints = ps.validatePurchase(sf, ps.getSunPoints());
			if (updatePoints == -1) {
				view.getStatus().setText("Not Enough Sun Points");
				return 0;
			} else {
				if (coolDownList.validatePurchase(sf)) {
					ps.purchase(sf, ps.getSunPoints());
					coolDownList.purchasePlant(sf);
					view.updatePointsText(String.valueOf(ps.getSunPoints()));
					view.getPurchase().setEnabled(false);
				} else {
					view.getStatus().setText(
							"CoolDown is remaining! Wait for " + coolDownList.getPlantQueue(sf).getRemaining());
					return 0;
				}
			}
		}

		return 1;
	}

	public void ZombieDead(int row, int col, int count) {
		System.out.println(count);
	}

	public void zombieMove(Action ac, Layout layout, PlantStore ps) {
		view.updateZombie(ac, layout.getGameGrid(), layout, ps);

	}

}
