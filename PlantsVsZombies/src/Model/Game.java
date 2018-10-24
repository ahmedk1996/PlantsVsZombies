package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Layout layout;
	private PlantStore store;
	private Scanner reader;
	private wave beginwave;
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
		
			if(isGameOver()) {
				gamedone = isGameOver();
				System.out.println("GAME IS OVER!!! LOSER");
			}
			if(gameClear()) {
				gamedone = gameClear();
				System.out.println("YOU Cleared STAGE!");
			}
			layout.print();
		}
	}
	
	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}

	public Boolean isGameOver() {
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			if(layout.getObject(i,0) instanceof Zombies) {
				return true;
			}
		}
		return false;
	}
	public Boolean gameClear() {
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
	
	public void promptStart() {
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


	public int gameDifficulty() {
		try {
			System.out.println("There are 3 levels of difficulty");
			System.out.println("1).Easy --- 2).Medium --- 3).Hard");
			reader = new Scanner(System.in); 
			int mode = reader.nextInt();
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
