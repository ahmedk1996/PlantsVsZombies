package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

import Plant.PlantStore;

import java.util.*;
import java.io.*;  

public class Game {
	private Layout layout;
	public PlantStore getStore() {
		return store;
	}

	public void setStore(PlantStore store) {
		this.store = store;
	}


	private PlantStore store;
	private Scanner reader;
	private int gameTurns = 1;
	private int zombieCounter;

	public Game (Layout layout , PlantStore store) {
		this.layout = new Layout();
		this.store = new PlantStore();
		zombieCounter = 0;
	}

	/**
	 * start which handles starting the initial game..
	 *
	 * @param gameMode the current game mode
	 * @return      void
	 */
	public void start(int gameMode) {

		boolean gamedone = false;
		if(!(zombieCounter <=1)) {
			layout.placeSpawnZombieOnGrid(layout);
		}
		layout.print();
		store.purchaseStartOfGame(layout , true);

		while(gamedone == false) {
			if(!(zombieCounter <= 1)) {
				layout.placeSpawnZombieOnGrid(layout);
			}
			zombieCounter--;
			layout.print();
			store.purchaseStartOfGame(layout , false);
			Action action = new Action(store);
			layout.setGameGrid(action.startAction(layout,gameTurns));
			layout.print();
		}
	}
	
	/**
	 * start which creates a custom layout of the grid
	 *
	 * @param  row  row number
	 * @param  column  column number
	 * @return  void
	 */
	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}

	
	/**
	 * promptStart which asks the user for the input required for the game difficulty
	 * 
	 * @return  int response of game difficulty. 1 for easy, 2 for medium and 3 for hard.

	 */
	public void promptStart(){
		int gameMode = gameDifficulty();
		reader = new Scanner(System.in);  
		System.out.println("Below is a 5x7 grid layout:");


		if(gameMode == 1) {
			System.out.println("Easy mode selected. Zombie types include: Walking Zombies. Move up 1 tile each time ");
			zombieCounter = 4;
		}else if(gameMode == 2){
			System.out.println("Medium mode selected. Zombie types include: ");
			zombieCounter =6;
		}
		else if(gameMode==3){
			System.out.println("Hard mode selected. Zombie types include: ");
			zombieCounter = 8;
		}
		
		start(gameMode);
	}

	/**
	 * loadHelptxt tells the user instructions about the game when required
	 *
	 * @return  void
	 */
	public void loadHelptxt() throws FileNotFoundException {
		String toString = "";
		try{
			Scanner txtFile	= new Scanner(new FileReader("Help.txt"));
			 while(txtFile.hasNextLine()) {
		            toString= toString+ txtFile.nextLine() + "\n";     
			 }
			 System.out.println(toString);
		}catch(FileNotFoundException e){
			System.out.println("Help File Doesn't Exist");
		}
	}

	/**
	 * gameDifficulty lets the user select the difficulty mode
	 * 
	 * @return int response of game difficulty. 1 for easy, 2 for medium and 3 for hard and 9 help.
	 */
	public int gameDifficulty() {
		try {
			System.out.println("There are 3 levels of difficulty");
			System.out.println("1).Easy --- 2).Medium --- 3).Hard --- 9) Help");
			reader = new Scanner(System.in); 
			int mode = reader.nextInt();
			if(mode == 9) {
				try {
					loadHelptxt();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return gameDifficulty();
			}
			
			if (mode == 1) {
				System.out.println("Easy mode has been selected...Good Luck!");
				//set off variable for game difficulty
				return 1;
			}
			else if (mode == 2) {

				return 2;
			}

			else if(mode == 3) {
				return 3;
			}
			else {
				System.out.println("Please make a selection to proceed.");
				gameDifficulty();
			}


		}
		catch (InputMismatchException e ) {

		}
		//user input
		return 0 ;
	}
	
	/**
	 * redo which re-does the users command that he had just made.
	 *
	 * @param  unknown
	 * @param  unknown
	 * @return  void
	 */
	public void redo() {

	}

	/**
	 * undo which which returns the previous game board layout
	 *
	 * @param  unknown
	 * @param  unknown
	 * @return  void
	 */
	public void undo() {

	}

	/**
	 * save which saves the custom layout of the grid with all the instances saved
	 *
	 * @param  unknown
	 * @param  unknown
	 * @return  void
	 */
	public void save() {

	}

	/**
	 * load which loads the custom grid saved initially
	 *
	 * @param  unknown
	 * @param  unknown
	 * @return  void
	 */
	public void load() {

	}


	public static void main(String args[]) {

		Layout layout = new Layout();
		PlantStore store = new PlantStore();
		// We will test wave by after using beginWave = new wave(1);
		Game game = new Game(layout, store);
		game.promptStart();

	}

}
