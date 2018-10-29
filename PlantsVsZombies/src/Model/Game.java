package Model;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import java.io.*;  

public class Game {
	private Layout layout;
	private PlantStore store;
	private Scanner reader;
	private int gameTurns = 1;
	private int zombieCounter;

	public Game (Layout layout , PlantStore store) {
		this.layout = new Layout();
		this.store = new PlantStore();
		zombieCounter = 0;
	}

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

			/*if(action.isGameOver(layout)) {
				System.out.println("GAME IS OVER!!! LOSER");
			}*/
			/*if(gameClear(layout)) {
				System.out.println("YOU Cleared STAGE!");
			}*/
			layout.print();
		}
	}

	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}

	/*public Boolean isGameOver(Layout layout) {
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			if(layout.getObject(i,0) instanceof Zombies) {
				return true;
			}
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			if (layout.getObject(i,1) instanceof Zombies ) {
				return true;
			}
		}


		return false;
	}*/
	public Boolean gameClear(Layout layout) {
		Boolean flag = true;
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			for(int j=0; j < layout.getGameGrid()[0].length ; j++) {
				if(layout.getObject(i,j) instanceof Zombies) {
					flag = false;
				}
			}
		}
		return flag;
	}

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

	public int gameDifficulty() {
		try {
			System.out.println("There are 3 levels of difficulty");
			System.out.println("1).Easy --- 2).Medium --- 3).Hard --- 9) Help");
			reader = new Scanner(System.in); 
			int mode = reader.nextInt();
			/*if(mode == 9) {
				try {
					loadHelptxt();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return gameDifficulty();
			}*/
			
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
	public void redo() {

	}

	public void undo() {

	}

	public void save() {

	}

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
