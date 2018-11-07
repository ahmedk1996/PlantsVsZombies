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
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Controller.Controller;
import Model.Action;
import Model.Layout;
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
	private JFrame gameFrame;
	private Controller controller;
	private JLabel points;
	private JButton purchase; 
	private Layout layout;
	private List<JButton> button;
	private JButton [][] buttonArray;
	private int buttIndex = -1;
	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}
	private JLabel status;
	
	private JRadioButton buyShooterPlant;
	private JLabel menu1;
	private JPanel store;
	private JPanel board;
	private JSplitPane splitPane;
	private JLabel msg;
	private JLabel sunFlower;
	private JLabel sunFlowerCost;
	private JLabel Shooter;
	private JButton waveContinue;
	private JLabel peaShooter;
	private JRadioButton buySunflower;
	private JButton b;
	
	public View (int test) {
		
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
	public JMenuItem getNewGame() {
		return newGame;
	}
	
	public JRadioButton getBuyPeaShooter() {
		return  buyShooterPlant;
	}
	
	public JRadioButton getBuySunflower() {
		return  buySunflower;
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
		med.setEnabled(false);
		hard.setEnabled(false);
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
	

	public void playPrompt() {
	
		initalizePlay();
		
	}
	
	public void initalizePlay() {
		layout = new Layout();
		play.setEnabled(false);
		gameFrame = new JFrame();
		gameFrame.setSize(750, 750);
		gameFrame.setTitle("Game In Progress");
		
		 store = new JPanel();
		 board = new JPanel();
	
		 splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, store, board);
		 splitPane.setDividerLocation(350);
		 splitPane.setOneTouchExpandable(true);
	     gameFrame.getContentPane().add(splitPane);
	     board.setLayout(new GridLayout(5,7));
	     button = new ArrayList<JButton>();
	     buttonArray = new JButton[5][7];
	    
	     	
			gameFrame.setVisible(true);
			store.setLayout(new GridLayout(4,2));
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
	public void zombieInfo() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(gameFrame,"Walking Zombies will spawn!","Spawners", JOptionPane.WARNING_MESSAGE, null);
	}
	

	public void setEnabledButtons(boolean b) {
		for(JButton c : button) {
			c.setEnabled(b);
		}
	}
	

	public void setZombieOnBoard(int randRow) {
		// TODO Auto-generated method stub
		buttonArray[randRow][6].setText("Z");
		buttonArray[randRow][6].setEnabled(false);
	}
	public void updateStatusText(String text) {
		// TODO Auto-generated method stub
		status.setText(text);
		
	}
	public void updatePointsText(String updatePoints) {
		points.setText(String.valueOf(updatePoints) + " Points");
		
	}
	public void placePrompt() {
		
		JOptionPane.showMessageDialog(gameFrame, "Deploy your Plant in the garden", "Deploy", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void updateZombie(Action ac, Object[][] gameGrid, Layout layout) {
	
		for(JButton butt : button) {
			if (butt.getText().equals("Z")) {
				int update = button.indexOf(butt);
				buttIndex = update;
				if (buttIndex %7 ==0) {
					System.out.println("Game Over");
					return;
				}
				butt.setText("");
				buttIndex = button.indexOf(butt);
				buttIndex--;
				button.get(buttIndex).setText("Z");
				
				ac.behaveZombie(gameGrid, layout);
				
			}
		}
		if (buttIndex== -1) {
			return;
		}
	
			
		

	}
}
