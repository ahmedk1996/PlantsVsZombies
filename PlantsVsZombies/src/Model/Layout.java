package Model;
import java.util.*;
public class Layout {
	private static Object[][] gameGrid;
	


	private Scanner reader;
	public enum plants { S, F, empty , }
	private PrintGrid grid;
	// Creating Grid of [5][7] 
	
	public static Object[][] getGameGrid() {
		return gameGrid;
	}


	public static void setGameGrid(Object[][] gameGrid) {
		Layout.gameGrid = gameGrid;
	}

	public void createGrid(int x, int y) {
		gameGrid = new Object [x][y];

		for(int row = 0; row < x; row++)
		{
			System.out.print((row % 10) + " ");
		    for (int column = 0; column < y; column++)
		    {
		    	gameGrid[row][column] = ".    ";
		        System.out.print(gameGrid[row][column]);
		       
		    }
		    System.out.println();
		    System.out.println();
		}
		System.out.print("  ");
		for (int column = 0; column < 7; column++)
			   System.out.print((column % 10 + "    "));
		System.out.println();
	}
	
	
	private void printGrid() {
		for(int row = 0; row < 5; row++)
		{
			System.out.print((row % 10) + " ");
		    for (int column = 0; column < 7; column++)
		    {
		    	System.out.print(gameGrid[row][column]);
		    }
	    System.out.println();
	    System.out.println();
	}
	System.out.print("  ");
	for (int column = 0; column < 7; column++)
		   System.out.print((column % 10 + "    "));
	System.out.println();
	}

	 
	public void placeSpawnZombieOnGrid(Zombies z, int randRow) {
	
		if(gameGrid[randRow][6] == ".    ") {
				gameGrid[randRow][6] = z;
				grid = new PrintGrid(gameGrid);
		}
		
}
	

	
	public boolean placePlantOnGrid(Plants p) {
		
		try {
		
		reader = new Scanner(System.in);  
		System.out.println("Enter the row and column to deploy your Plant.(Ex. 4 2)");
		int inputX = reader.nextInt();
		int inputY = reader.nextInt();
		
		if(gameGrid[inputX][inputY] == ".    ") {
		if (p instanceof Plants) {
			gameGrid[inputX][inputY] = p;
			grid = new PrintGrid(gameGrid);
		}
		else if (p instanceof Sunflower) {
		
			gameGrid[inputX][inputY] = p;
			grid  = new PrintGrid(gameGrid);
			
			
		}
		}
		else {
		
			System.out.println("There seems to be an already placed Plant here...");
			return false;
		}
		
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return true;
	}
	
/*	public void reset() {
		
		for(int row = 0; row < 5; row++)
		{
			System.out.print((row % 10) + " ");
		    for (int column = 0; column < 7; column++)
		    {
		    	gameGrid[row][column] = ".    ";
		    	System.out.print(gameGrid[row][column]);
	       
		    }
	    System.out.println();
	    System.out.println();
	}
		for (int column = 0; column < 7; column++)
			   System.out.print((column % 10 + "    "));
		System.out.println();
	}*/
	

	public Object getGrid() {
		return gameGrid;
	}



	





}
