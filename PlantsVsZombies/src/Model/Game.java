package Model;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Game {
	private Layout layout;
	private PlantStore store;
	private Scanner reader;
	public Game (Layout layout , PlantStore store) {
		this.layout = new Layout();
		this.store = new PlantStore();

	}
	
	public void start() {
		layout.createGrid();
		
		store.purchaseStartOfGame();
	}
	
	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}
	
	public void redo() {
		
	}
	
	public void undo() {
		
	}
	
	public void save() {
		
	}
	
	public void load() {
		
	}
	
	public void promptStart() {
	try {
		int gameMode = gameDifficulty();
		reader = new Scanner(System.in);  
		System.out.println("Would you like to create a custom grid layout or continue with the default (5x7)? :");
		System.out.println("Enter 1 for custom and any number for defualt");
		int gridLayout = reader.nextInt(); 
		
		if(gridLayout == 1) {
			reader = new Scanner(System.in);
		    System.out.println("Enter a grid layout for x by y (Ex: 4x4 ): ");

		    String coordinate = reader.nextLine();
		    String[] parts = coordinate.split("x");
		    
		    String x_loc = parts[0].trim();
		    int x = Integer.parseInt(x_loc);			

		    String y_loc = parts[1].trim();
		    int y = Integer.parseInt(y_loc);			

			start(x,y);
			
		}
		else {
			start();
		}
	}
	catch(Exception Ex) {
		System.out.println(Ex.toString());
	}
	}
	
/*	public void placePlant() {
		
		reader = new Scanner(System.in);
	    System.out.println("Enter ");

	    String coordinate = reader.nextLine();
	    String[] parts = coordinate.split("x");
	    
	    String x_loc = parts[0].trim();
	    int x = Integer.parseInt(x_loc);			

	    String y_loc = parts[1].trim();
	    int y = Integer.parseInt(y_loc);
		
		//if()
		
	}*/
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
			gameDifficulty();
		}
		//user input
		return 0 ;
	}
	
	
	
	public static void main(String args[]) {
		
		Layout layout = new Layout();
		PlantStore store = new PlantStore();
		Game game = new Game(layout, store);
		
		game.promptStart();
		

		

	}
	
}
