
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import Model.Action;
import Model.Layout;
import Plant.PlantStore;
import Plant.Plants;
import Zombie.Zombies;
/**
 *  The View is a class which extends JFrame and includes getters 
 * and setters for the different types of buttons and menu objects 
 * used to be called in the Controller class.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public class View extends JFrame {



	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuBar playMenuBar;
	private JMenu gameMenu;
	private JMenu menu;
	private JMenu playMenu;
	private JMenuItem quit,undo,redo,save,load;
	private JButton gameDiffuclty;
	private JPanel selectButtonsPanel;
	private JLabel levelLabel;
	private ButtonGroup group;
	private JCheckBox easy,med,hard;
	private JButton play,help;
	private JFrame gameFrame;
	private JLabel points;
	private JButton purchase;

	private List<JButton> button;
	private JButton[][] buttonArray;

	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	private JLabel status;

	private JRadioButton buyShooterPlant;
	private JLabel menu1,msg,sunFlower,sunFlowerCost,Shooter,peaShooter,potatoMine,potatoMineCost,chomper,chomperCost;
	private JPanel store;
	private JPanel board;
	private JSplitPane splitPane;
	private JButton waveContinue;
	private JRadioButton buySunflower,buyPotatoMine,buyChomper;
	
	
	/**
	 *  Intializes all the contents of the View GUI Frame
	 * 	@param None
	 * 	@return None
	 */
	private void initalizeComponents() {
		frame = new JFrame("Plants Vs. Zombies");
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
		quit = new JMenuItem("Quit");

		menu.add(quit);
		gameDiffuclty = new JButton("Select");
		levelLabel = new JLabel("Select Difficulty: ");
		levelLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));

		levelLabel.setBounds(175, 10, 250, 100);
		selectButtonsPanel.add(levelLabel);

		easy = new JCheckBox("Easy");
		med = new JCheckBox("Medium");
		hard = new JCheckBox("Hard");
		group = new ButtonGroup();
		selectButtonsPanel.add(easy);
		selectButtonsPanel.add(med);
		selectButtonsPanel.add(hard);
		//med.setEnabled(false);
		//hard.setEnabled(false);
		group.add(easy);
		group.add(med);
		group.add(hard);

		play = new JButton();
		play.setEnabled(false);
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

	public void playPrompt() throws IOException {

		initalizePlay();

	}

	/**
	 *  Intializes all the contents of the play GUI Frame
	 * 	@param None
	 * 	@return None
	 */
	public void initalizePlay() throws IOException {

		play.setEnabled(false);
		gameFrame = new JFrame();
		gameFrame.setSize(750, 750);
		gameFrame.setTitle("Game In Progress");
		playMenuBar = new JMenuBar();
		playMenu = new JMenu("Play");
		playMenuBar.add(playMenu);
		
		undo = new JMenuItem("undo");
		redo = new JMenuItem("redo");
		save = new JMenuItem("save");
		load = new JMenuItem("load");
		
		
		//Save and Load is not implemented yet but for later Milestone, It's good to have it for extension.
		save.setEnabled(false);
		load.setEnabled(false);
		
		playMenu.add(undo);
		playMenu.add(redo);
		playMenu.add(save);
		playMenu.add(load);
		
		store = new JPanel();
		board = new JPanel();
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true,store, board);
		splitPane.setDividerLocation(350);
		splitPane.setOneTouchExpandable(true);
		gameFrame.getContentPane().add(splitPane);
		board.setLayout(new GridLayout(5, 7));
		button = new ArrayList<JButton>();
		buttonArray = new JButton[5][7];
		gameFrame.setVisible(true);
		store.setLayout(new GridLayout(6, 2));

		menu1 = new JLabel("Welcome to the PVZ Store");
		store.add(menu1);
		points = new JLabel();
		store.add(points);
		msg = new JLabel("");
		store.add(msg);
		sunFlower = new JLabel("Purchase SunFlower Plant");
		store.add(sunFlower);
		sunFlowerCost = new JLabel("50 Sun Points");
		store.add(sunFlowerCost);
		buySunflower = new JRadioButton();
		store.add(buySunflower);
		Shooter = new JLabel("Purchase Shooter Plant");
		store.add(Shooter);
		peaShooter = new JLabel("100 Sun Points");
		store.add(peaShooter);
		
		buyShooterPlant = new JRadioButton();
		store.add(buyShooterPlant);
		
		//text for the potato mine buying options
		potatoMine = new JLabel("Purchase Potato Mine"); 
		store.add(potatoMine);
		potatoMineCost = new JLabel ("50 Sun Points");
		store.add(potatoMineCost);
		buyPotatoMine = new JRadioButton();
		store.add(buyPotatoMine);
		
		//text for the Chomper buying options
		chomper = new JLabel("Purchase Chomper"); 
		store.add(chomper);
		chomperCost = new JLabel ("150 Sun Points");
		store.add(chomperCost);
		buyChomper = new JRadioButton();
		store.add(buyChomper);
		
		
		purchase = new JButton("Purchase");
		store.add(purchase);
		purchase.setEnabled(false);
		waveContinue = new JButton("Simulate Wave");
		store.add(waveContinue);
		status = new JLabel("Happy Spending!");
		store.add(status);
		status.setForeground(Color.RED);
		group.add(buyShooterPlant);
		group.add(buySunflower);
		group.add(buyPotatoMine);
		group.add(buyChomper);
		gameFrame.setJMenuBar(playMenuBar);

	}
	public void importView() {
		
	}
	

	public JFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public List<JButton> getButton() {
		return button;
	}

	public void setButton(List<JButton> button) {
		this.button = button;
	}

	public JPanel getBoard() {
		return board;
	}

	public void setBoard(JPanel board) {
		this.board = board;
	}

	public void helpPrompt() {
		String helpText = "	Help - How to play Plants Vs Zombies.\r\n" + " \r\n"
				+ "--------------------------------------------------------------------\r\n"
				+ "	The goal of this game is to defense from the zombies.\r\n" + "\r\n"
				+ "Each Difficulty contains different numbers and type of zombies. \r\n" + "\r\n"
				+ "Sun-point is the virtual Money to purchase the plants in the store. \r\n"
				+ "PeaShooter Plant - PeaShooter attacks zombie in the same row.\r\n"
				+ "Sun-flower - The user can get 50 Sun-points on each wave. \r\n" + "\r\n" + "\r\n" + "Each wave, \r\n"
				+ "One zombie is randomly spawned in the board.\r\n"
				+ "The user purchases the plants according to your own Strategies.\r\n" + "\r\n" + "\r\n" + "\r\n"
				+ "\r\n" + "Once the user purchases the plants, \r\n" + "\r\n"
				+ "the user can place the plants on the board by typing row and column.\r\n" + "\r\n" + "\r\n" + "\r\n"
				+ "			Good Luck!! \r\n" + "\r\n"
				+ "--------------------------------------------------------------------";
		JOptionPane.showMessageDialog(frame, helpText);

	}

	public void level1ZombieInfo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(gameFrame, "Walking Zombies will spawn!", "Spawners", JOptionPane.WARNING_MESSAGE,
				null);
	}
	
	public void level2ZombieInfo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(gameFrame, "Walking Zombies and Sprint Zombies will spawn!", "Spawners", JOptionPane.WARNING_MESSAGE,
				null);
	}
	
	public void level3ZombieInfo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(gameFrame, "Walking, Sprint and Rugby Zombies will spawn!", "Spawners", JOptionPane.WARNING_MESSAGE,
				null);
	}


	public void passedStage() {
	
		JOptionPane.showMessageDialog(gameFrame, "Wave Cleared! Incoming Wave...", "Wave Completed",
				JOptionPane.WARNING_MESSAGE);

	}

	/**
	 *  Set all buttons on the grid to false/true based on the plant or zombie on the grid
	 * 	@param None
	 * 	@return None
	 */
	
	public void setEnabledButtons() {
		for (int i = 0; i < buttonArray.length; i++) {
			for (int j = 0; j < buttonArray[0].length; j++) {
				if (buttonArray[i][j].getText().length() == 2) {
					buttonArray[i][j].setEnabled(false);
				} else {
					buttonArray[i][j].setEnabled(true);
				}

			}
		}
	}

	/**
	 * 	Set the text and enabled false of the random zombie spawned
	 * 	@param None
	 * 	@return None
	 */
	public void setZombieOnBoard(int randRow,Zombies zombie) {
		// TODO Auto-generated method stub
		buttonArray[randRow][6].setText(zombie.getStringtype());
		buttonArray[randRow][6].setEnabled(false);
	}
	public void setWalkingZombieOnBoard(int randRow) {
		// TODO Auto-generated method stub
		buttonArray[randRow][6].setText("Z");
		buttonArray[randRow][6].setEnabled(false);
	}
	/**
	 * 	Set the text and enabled false of the random zombie spawned
	 * 	@param None
	 * 	@return None
	 */
	public void setRugbyZombieOnBoard(int randRow) {
		// TODO Auto-generated method stub
		buttonArray[randRow][6].setText("RZ");
		buttonArray[randRow][6].setEnabled(false);
	}
	/**
	 * 	Set the text and enabled false of the random zombie spawned
	 * 	@param None
	 * 	@return None
	 */
	public void setSprintZombieOnBoard(int randRow) {
		// TODO Auto-generated method stub
		buttonArray[randRow][6].setText("SZ");
		buttonArray[randRow][6].setEnabled(false);
	}
	/**
	 * 	set the text of the JButton passed from the controller when clicked
	 * 	@param None
	 * 	@return None
	 */
	public void updateStatusText(String text) {
		// TODO Auto-generated method stub
		status.setText(text);
	}

	/**
	 * 	Update the Points Text JLabel
	 * 	@param updatePoints:String
	 * 	@return None
	 */
	public void updatePointsText(String updatePoints) {
		points.setText(String.valueOf(updatePoints) + " Points");

	}

	/**
	 * 	JOptionPane displayed on the gui frame to deploy plant
	 * 	@param None
	 * 	@return None
	 */
	public void placePrompt() {
		JOptionPane.showMessageDialog(gameFrame, "Deploy your Plant in the garden", "Deploy",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * 	Once the simulate button has been pressed, this is the series of actions, the JButton grid 
	 * Array updates
	 * 	@param Action ac 
	 * 	@param gameGrid instance of the model gameGrid passed
	 * 	@param layout Layout 
	 *  @param ps PlantStore
	 * 	@return None
	 */
	public void updateZombie(Action ac, Object[][] gameGrid, Layout layout, PlantStore ps) {
		ac.plantShoot(gameGrid, layout, buttonArray, ps);
		int returnval = ac.behaveZombie(gameGrid, layout);
		if (returnval == -1) {
			return;
		}
		iterateGameGrd(gameGrid, buttonArray);
		moveZombieTextUpOne();
		checkAllZombiesDead();	
	}
	/**
	 * 	Checks if all zombies are dead, reading the text of the 
	 * 	@return boolean, true if Zombies are on grid. False, if no zombies are on board.
	 */
	public boolean checkAllZombiesDead() {
		for (int i = 0; i < buttonArray.length; i++) {
			for (int j = 0; j < buttonArray[0].length; j++) {
				if (buttonArray[i][j].getText().contains("Z")) {
					return true;
				}
				else {
					return false;
				}

			}
			
		}
		return false;
	}

	/**
	 * 	If the instance is a plant on the grid, set the cell to null, and empty text
	 * 	@param gameGrid
	 * 	@param buttonArray2
	 * 	@return none
	 */
	public void iterateGameGrd(Object[][] gameGrid, JButton[][] buttonArray) {
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[0].length; j++) {
				if (gameGrid[i][j] instanceof Plants) {
					if (((Plants) gameGrid[i][j]).getHealth() == 0) {
						gameGrid[i][j] = null;
						buttonArray[i][j].setText("");
					}
				}
			}
		}
	}
	/**
	 * 	Checks if the zombie has reached the end of the grid, places the zombie text up one
	 * 	when there are no objects in front
	 * 	
	 * 	@return none
	 */
	public void moveZombieTextUpOne() {
		for (int i = 0; i < buttonArray.length; i++) {
			for (int j = 0; j < buttonArray[0].length; j++) {
				if (buttonArray[i][j].getText().contains("Z")) {
					if (buttonArray[i][0].getText().contains("Z")) {
						JOptionPane.showMessageDialog(gameFrame, "GAME OVER! YOU HAVE FAILED TO PROTECT YOUR GARDEN.",
								"Better Luck Next Time!", JOptionPane.WARNING_MESSAGE);
						waveContinue.setEnabled(false);
						return;
					}
				
					if (!(buttonArray[i][j-1].getText().equals(""))) {
						continue;
					} else {
						String text = buttonArray[i][j].getText();
						if (text == "SZ") {
							if (!(buttonArray[i][j-2].getText().equals(""))){
								continue;
							}
							buttonArray[i][j - 2].setText(text);
							buttonArray[i][j].setText("");
						}
						else {
							buttonArray[i][j - 1].setText(text);
							buttonArray[i][j].setText("");
						}
					
					}
				
				}
			}
		}
	}
	/**
	 * 	
	 * 	sets all JButton arrays as false
	 * 	
	 * 	@return none
	 */
	public void setAllEnabledFalse() {
		for (int i = 0;	 i < buttonArray.length; i++) {
			for (int j = 0; j < buttonArray[0].length; j++) {
				buttonArray[i][j].setEnabled(false);

			}
		}
	}
	
	/**
	 * 	Prompts user they have won the game
	 * 	
	 * 	@return none
	 */
	
	public void gameWon() {
		JOptionPane.showMessageDialog(gameFrame, "Congratulations. You beat the Zombies!", "Winner!",
				JOptionPane.INFORMATION_MESSAGE);
		int result = JOptionPane.showConfirmDialog(gameFrame, "Would you like to quit the game?" , "Quit" , JOptionPane.OK_CANCEL_OPTION);
		if (result == 0){
			System.exit(0);
		}
			

	}
	public JButton[][] getButtonArray() {
		return buttonArray;
	}

	public void setButtonArray(JButton[][] buttonArray) {
		this.buttonArray = buttonArray;
	}

	public JRadioButton getBuyShooterPlant() {
		return buyShooterPlant;
	}

	public void setBuyShooterPlant(JRadioButton buyShooterPlant) {
		this.buyShooterPlant = buyShooterPlant;
	}

	public void setBuySunflower(JRadioButton buySunflower) {
		this.buySunflower = buySunflower;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JButton getPurchase() {
		return purchase;
	}

	public void setPurchase(JButton purchase) {
		this.purchase = purchase;
	}

	public JButton getWaveContinue() {
		return waveContinue;
	}

	public void setWaveContinue(JButton waveContinue) {
		this.waveContinue = waveContinue;
	}

	public JLabel getPoints() {
		return points;
	}

	public void setPoints(JLabel points) {
		this.points = points;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JCheckBox getEasy() {
		return easy;
	}

	public void setEasy(JCheckBox easy) {
		this.easy = easy;
	}

	public JCheckBox getMed() {
		return med;
	}

	public void setMed(JCheckBox med) {
		this.med = med;
	}

	public JCheckBox getHard() {
		return hard;
	}

	public void setHard(JCheckBox hard) {
		this.hard = hard;
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


	public JRadioButton getBuyPeaShooter() {
		return buyShooterPlant;
	}
	
	public JRadioButton getBuyPotatoMine() {
		return buyPotatoMine;
	}
	
	public void setBuyPotatoMine(JRadioButton potatoMine) {
		this.buyPotatoMine = potatoMine;
	}
	
	public JRadioButton getBuyChomper() {
		return buyChomper;
	}
	
	public void setBuyChomper(JRadioButton chomper) {
		this.buyChomper = chomper;
	}

	public JRadioButton getBuySunflower() {
		return buySunflower;
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
	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem getLoad() {
		return load;
	}
	
	

}
