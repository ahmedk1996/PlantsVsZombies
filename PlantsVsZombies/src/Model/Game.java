package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Layout layout;
	private PlantStore store;
	private Scanner reader;
	private wave beginwave;
	private int gameTurns = 1;

	public Game (Layout layout , PlantStore store) {
		this.layout = new Layout();
		this.store = new PlantStore();
	}
	
	public void start(int gameMode) {
		boolean gamedone = false;
		//if (gameMode == 1) {
		//	beginwave = new wave(4);
		//}
		
		layout.setObject(3, 6, new WalkingZombie());		
		layout.print();
		while(!gamedone) {
			store.purchaseStartOfGame();
			Action action = new Action();
			layout.setGameGrid(action.startAction(layout,gameTurns));
			layout.print();
			if(isGameOver()) {
				gamedone = isGameOver();
				System.out.println("GAME IS OVER!!! LOSER");
			}
			if(gameClear()) {
				gamedone = gameClear();
				System.out.println("YOU Cleared STAGE!");
			}
			
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
			System.out.println("Easy mode selected. Zombie types include: ");
		}else if(gameMode == 2){
			System.out.println("Medium mode selected. Zombie types include: ");
		}
		else if(gameMode==3){
			System.out.println("Hard mode selected. Zombie types include: ");
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
		//wave beginWave = new wave(1);
		Game game = new Game(layout, store);
		
		game.promptStart();
		

		

	}
	//System.out.println("Would you like to create a custom grid layout or continue with the default (5x7)? :");
	//System.out.println("Enter 1 for custom and any number for defualt");
//	int gridLayout = reader.nextInt(); 
	
//	if(gridLayout == 1) {
//		reader = new Scanner(System.in);
//	    System.out.println("Enter a grid layout for x by y (Ex: 4x4 ): ");
//
//	    String coordinate = reader.nextLine();
//	    String[] parts = coordinate.split("x");
//	    
//	    String x_loc = parts[0].trim();
//	    int x = Integer.parseInt(x_loc);			
//
//	    String y_loc = parts[1].trim();
//	    int y = Integer.parseInt(y_loc);			
//
//		start(x,y);
//		
//	}
//	else {
//		start();
//	}
}
