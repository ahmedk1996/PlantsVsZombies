package View;

import java.awt.*;
import javax.swing.*;
import Controller.Controller;
import Model.Layout;
import Zombies.RugbyZombie;
import Zombies.SprintZombie;
import Zombies.WalkingZombie;
import Zombies.Zombies;
import Plants.Chomper;
import Plants.Plants;
import Plants.PotatoMine;
import Plants.ShootingPlant;
import Plants.Sunflower;

/**
 *  The View is a class which extends JFrame and includes getters 
 * and setters for the different types of buttons and menu objects 
 * used to be called in the Controller class.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public class View extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public JButton[][] buttons;
	private JSplitPane split;
	private JPanel optionPanel,storePanel, gridPanel;
	private JButton easy,inte,hard,help;
	private JButton purchase,waveContinue;
	private Controller controller;
	private JMenuBar playMenuBar;
	private JMenu gameMenu,optionMenu;
	private JMenuItem undo,redo,save,load,newGame,exit,levelBuilder;
	private JLabel points,status;
	private ButtonGroup group;
	private JRadioButton buySunflower,buyShooterPlant,buyPotatoMine,buyChomper;

	/**
	 *  Constructor to initialize the controller and other objects
	 * 
	 * @param Controller - the controller that will be listening to events
	 * @return None
	 */
	public View (Controller c) {
		controller = c;
		super.setTitle("Plant Vs Zombie");
		buttons = new JButton[5][7];
		split = new JSplitPane();
		optionPanel = new JPanel();
		storePanel =  new JPanel();
		gridPanel = new JPanel();
		group = new ButtonGroup();
		//super.setLayout();

		//setPreferredSize(new Dimension(1000,1200));
		super.setSize(1000, 800);
		super.setLayout(new GridLayout(3, 1));
		optionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
		super.add(optionPanel,BorderLayout.NORTH);

		//super.add();               // due to the GridLayout, our splitPane will now fill the whole window

		// let's configure our splitPane:
		split.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly

	
		storePanel.setSize(200,200);
		storePanel.setLayout(new GridLayout(6, 2));
		super.add(storePanel);
		super.add(gridPanel);
		// split.setTopComponent(storePanel); 
		//split.setBottomComponent(gridPanel);  
		gridPanel.setLayout(new GridLayout(5,7));
		gridPanel.setSize(500,1000);

		initiateOptionPanel();
		initiateStorePanel();
		initiateGridPanel();
		initiateMenuBar();
		setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	/**
	 *  Sets the menu bar to display the correct items on the JFrame
	 * 
	 * @param None
	 * @return None
	 */
	public void initiateMenuBar() {
		playMenuBar = new JMenuBar();
		
		gameMenu = new JMenu("Game");
		playMenuBar.add(gameMenu);
		
		optionMenu = new JMenu("Option");
		playMenuBar = new JMenuBar();
		playMenuBar.add(gameMenu);
		playMenuBar.add(optionMenu);
		
		//save,load,newGame,exit;
		undo = new JMenuItem("undo");
		undo.setActionCommand("Undo");
		undo.addActionListener(controller);
		optionMenu.add(undo);
		
		redo = new JMenuItem("redo");
		redo.setActionCommand("Redo");
		redo.addActionListener(controller);
		optionMenu.add(redo);
		super.setJMenuBar(playMenuBar);
		
		
		newGame= new JMenuItem("new Game");
		newGame.setActionCommand("newGame");
		newGame.addActionListener(controller);
		gameMenu.add(newGame);
		
		save= new JMenuItem("Save");
		save.setActionCommand("save");
		save.addActionListener(controller);
		gameMenu.add(save);
		
		load= new JMenuItem("Load");
		load.setActionCommand("load");
		load.setEnabled(false);
		load.addActionListener(controller);
		gameMenu.add(load);
		
		levelBuilder= new JMenuItem("levelBuilder");
		levelBuilder.setActionCommand("levelBuilder");
		load.addActionListener(controller);
		gameMenu.add(levelBuilder);
		
		exit= new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(controller);
		gameMenu.add(exit);
		
		this.setJMenuBar(playMenuBar);
		
	}


	/**
	 *  used to set the buttons to diplay pictures 
	 * 
	 * @param layout - current state of the grid
	 * @return None
	 */
	public void loadlayout(Layout layout) {
		Object[][] grid = layout.getGameGrid();
		for(int i =0; i< 5; i++) {
			for(int j =0 ; j<7 ; j++) {
				if(grid[i][j] instanceof Plants) {
					Plants temp = (Plants) grid[i][j];
					if(temp instanceof ShootingPlant) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/repee.png")).getImage();
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					}else if(temp instanceof Sunflower) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/resun.png")).getImage();
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					}else if(temp instanceof PotatoMine) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/repotato.png")).getImage();
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					}else if(temp instanceof Chomper) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/rechomper.png")).getImage();
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					}
				}else if(grid[i][j] instanceof Zombies) {
					Zombies temp = (Zombies) grid[i][j];
					if(temp instanceof WalkingZombie) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/rewalking.png")).getImage();
		
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					}else if(temp instanceof SprintZombie) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/resprint.png")).getImage();
						
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					
					}else if(temp instanceof RugbyZombie) {
						buttons[i][j].setText(temp.getStringtype());
						Image myIcon = new ImageIcon(this.getClass().getResource("/rerugby.png")).getImage();
				
						buttons[i][j].setIcon(new ImageIcon(myIcon));
					
					}
				}else{
					buttons[i][j].setText("");
					Image myIcon = new ImageIcon(this.getClass().getResource("/regrass.png")).getImage();
					buttons[i][j].setIcon(new ImageIcon(myIcon));
					//buttons[i][j].setIcon(null);
					buttons[i][j].setEnabled(true);
				}
			}
		}
	}
	
	/**
	 *  Once the game has started the user will be able to choose from 3 differnt difficutlties:
	 * -Easy
	 * -Intermediate
	 * -Hard
	 * 
	 * @param None
	 * @return None
	 */
	public void enableLevelButtons() {
		easy.setEnabled(true);
		inte.setEnabled(true);
		hard.setEnabled(true);
	}
	
	/**
	 *  Once the user has selected one of the 3 differnt difficutlties, the option to change will be disabled
	 * 
	 * @param None
	 * @return None
	 */
	public void disableLevel() {
		easy.setEnabled(false);

		inte.setEnabled(false);

		hard.setEnabled(false);

	}

	
	/**
	 *  Used to enable ingame buttons like:
	 * -Purchase
	 * -Simulate Wave
	 * 
	 * @param None
	 * @return None
	 */
	public void enableFunctionButtons() {
		//enablebuttons();
		purchase.setEnabled(true);
		waveContinue.setEnabled(true);
	}
	
	/**
	 *  Used to disable ingame buttons like:
	 * -Purchase
	 * -Simulate Wave
	 * 
	 * @param None
	 * @return None
	 */
	public void disEnableFunctionButtons() {
		//enableButtons(false);	
		purchase.setEnabled(false);
		waveContinue.setEnabled(false);
	}

	/**
	 *  Used to create the grid with buttons:
	 * 
	 * @param boolean - true if button is enabled, false otherwise
	 * @return None
	 */
	public void enableButtons(boolean flag) {
		for(int i =0; i< 5; i++) {
			for(int j =0 ; j<7 ; j++) {
				buttons[i][j].setEnabled(flag);
			}
		}
	}

	/**
	 *  Used to enable purchase buttons like
	 * 
	 * @param boolean - true if the button is enabled
	 * @return None
	 */
	public void enablePurchaseButton(boolean flag) {
		purchase.setEnabled(flag);
	}
	
	/**
	 *  Used to check status of undo button
	 * 
	 * @param boolean - true if the undo button should be avalilable, false otherwise
	 * @return None
	 */
	public void undostatus(boolean flag) {
		if(flag == true) {
			undo.setEnabled(true);
		}else {
			undo.setEnabled(true);
		}
	}
	
	/**
	 *  Used to check status of redo button
	 * 
	 * @param boolean - true if the redo button should be avalilable, false otherwise
	 * @return None
	 */
	public void redostatus(boolean flag) {
		if(flag == true) {
			redo.setEnabled(true);
		}else {
			redo.setEnabled(true);
		}
	}
	
	/**
	 *  Used to display prompts on the screen if the player won the game
	 * 
	 * @param None
	 * @return None
	 */
	public void win() {
		JOptionPane.showMessageDialog(this.gridPanel, "Congratulations. You beat the Zombies!", "Winner!",
				JOptionPane.INFORMATION_MESSAGE);
		int result = JOptionPane.showConfirmDialog(this.gridPanel, "Would you like to quit the game?" , "Quit" , JOptionPane.OK_CANCEL_OPTION);
		if (result == 0){
			System.exit(0);
		}
	}

	/**
	 *  Used to display prompts on the screen if the player lost the game
	 * 
	 * @param None
	 * @return None
	 */
	public void loose() {
		JOptionPane.showMessageDialog(this.gridPanel, "GAME OVER! YOU HAVE FAILED TO PROTECT YOUR GARDEN.",
				"Try Again!! Next Time!", JOptionPane.INFORMATION_MESSAGE);
		for(int i =0; i< 5; i++) {
			for(int j =0 ; j<7 ; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
		this.enableLevelButtons();

	}
	
	/**
	 *  Used to update the users ingame balance
	 * 
	 * @param int- number of sunpoints the user should have
	 * @return None
	 */
	public void updatePoints(int sunpoint) {
		points.setText("Sun Points :"+ String.valueOf(sunpoint) + " Points");
	}
	
	/**
	 *  Used to change font and color of the text
	 * 
	 * @param info - what is the text to be changed
	 * @return None
	 */
	public void updateInfo(String info) {
		status.setText(info);
		status.setForeground(Color.red);
	}
	
	/**
	 *  Used to generate a prompt message
	 * 
	 * @param message - the desired message that should be in the prompt
	 * @return None
	 */
	public void promptMessage(String message) {
		JOptionPane.showMessageDialog(this.gridPanel,message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 *  Used to display help and introduction instructions on the screen
	 * 
	 * @param None
	 * @return None
	 */
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
		JOptionPane.showMessageDialog(this, helpText);

	}
	
	/**
	 *  Used to initiate option controls
	 * 
	 * @param None
	 * @return None
	 */
	public void initiateOptionPanel() {
		easy = new JButton("Easy");
		easy.setActionCommand("easy");
		optionPanel.add(easy);
		easy.addActionListener(controller);
		inte = new JButton("Intermediate");
		inte.setActionCommand("Intermediate");
		optionPanel.add(inte);
		inte.addActionListener(controller);
		hard = new JButton("Hard");
		hard.setActionCommand("Hard");
		optionPanel.add(hard);
		hard.addActionListener(controller);
		help = new JButton("Help");
		optionPanel.add(help);
		help.setActionCommand("Help");
		help.addActionListener(controller);
	}
	
	/**
	 *  Used to inistaite store controls
	 * 
	 * @param None
	 * @return None
	 */
	public void initiateStorePanel() {
		JLabel menu1 = new JLabel("Welcome to the PVZ Store");

		storePanel.add(menu1);

		points = new JLabel("Sunpoints : ");
		storePanel.add(points);
		JLabel msg = new JLabel("");
		storePanel.add(msg);

		JLabel sunFlower = new JLabel("Purchase SunFlower Plant");
		storePanel.add(sunFlower);
		JLabel sunFlowerCost = new JLabel("50 Sun Points");
		storePanel.add(sunFlowerCost);
		buySunflower = new JRadioButton();

		buySunflower.addActionListener(controller);
		buySunflower.setActionCommand("buySunflower");
		storePanel.add(buySunflower);
		JLabel Shooter = new JLabel("Purchase Shooter Plant");
		storePanel.add(Shooter);
		JLabel peaShooter = new JLabel("100 Sun Points");
		storePanel.add(peaShooter);
		buyShooterPlant = new JRadioButton();
		buyShooterPlant.addActionListener(controller);
		buyShooterPlant.setActionCommand("buyShooterPlant");
		storePanel.add(buyShooterPlant);



		//text for the potato mine buying options
		JLabel potatoMine = new JLabel("Purchase Potato Mine"); 
		storePanel.add(potatoMine);
		JLabel potatoMineCost = new JLabel ("100 Sun Points");
		storePanel.add(potatoMineCost);
		buyPotatoMine = new JRadioButton();
		buyPotatoMine.addActionListener(controller);
		buyPotatoMine.setActionCommand("buyPotatoMine");
		storePanel.add(buyPotatoMine);

		//text for the Chomper buying options
		JLabel chomper = new JLabel("Purchase Chomper"); 
		storePanel.add(chomper);
		JLabel chomperCost = new JLabel ("200 Sun Points");
		storePanel.add(chomperCost);
		buyChomper = new JRadioButton();
		buyChomper.setActionCommand("buyChomper");
		storePanel.add(buyChomper);


		purchase = new JButton("Purchase");
		purchase.setActionCommand("Purchase");
		purchase.addActionListener(controller);
		storePanel.add(purchase);
		purchase.setEnabled(true);
		waveContinue = new JButton("Simulate Wave");
		waveContinue.setActionCommand("simulate");
		waveContinue.addActionListener(controller);
		storePanel.add(waveContinue);
		status = new JLabel();
		status.setForeground(Color.blue);

		//redo = new JMenuItem("redo");
		group.add(buyShooterPlant);
		group.add(buySunflower);
		group.add(buyPotatoMine);
		group.add(buyChomper);

		storePanel.add(status);
	}

	/**
	 *  Used to initiate game grid
	 * 
	 * @param None
	 * @return None
	 */
	public void initiateGridPanel() {
		for(int i =0; i< 5; i++) {
			for(int j =0 ; j<7 ; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setActionCommand("grid");
				buttons[i][j].putClientProperty("row",i);
				buttons[i][j].putClientProperty("col",j);
				buttons[i][j].addActionListener(controller);
				gridPanel.add(buttons[i][j]);
			}
		}
	}
	
	/**
	 *  Used to get the contents of all the buttons on the game grid
	 * 
	 * @param None
	 * @return JButton [][] - the array of objects in the grid
	 */
	public JButton[][] getButtons() {
		return buttons;
	}


	/**
	 *  Used to set the buttons of the grid
	 * 
	 * @param JButton[][] - the value or state we want to change the button to
	 * @return None
	 */
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}


	public ButtonGroup getGroup() {
		return group;
	}

	
	/**
	 *  Used to get the state of the easy button
	 * 
	 * @param None
	 * @return JButton 
	 */
	public JButton getEasy() {
		return easy;
	}


	/**
	 *  Used to get the object of type sunflower
	 * 
	 * @param None
	 * @return JRadioButton
	 */
	public JRadioButton getBuySunflower() {
		return buySunflower;
	}

	/**
	 *  Used to get the object of type ShooterPlant
	 * 
	 * @param None
	 * @return JRadioButton
	 */
	public JRadioButton getBuyShooterPlant() {
		return buyShooterPlant;
	}

	/**
	 *  Used to get the object of type PotatoeMine
	 * 
	 * @param None
	 * @return JRadioButton
	 */
	public JRadioButton getBuyPotatoMine() {
		return buyPotatoMine;
	}

	/**
	 *  Used to get the object of type Chomper
	 * 
	 * @param None
	 * @return JRadioButton
	 */
	public JRadioButton getBuyChomper() {
		return buyChomper;
	}

	public void enableLoad() {
		load.setEnabled(true);
		
	}

}