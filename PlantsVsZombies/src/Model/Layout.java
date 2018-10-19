package Model;
import java.util.*;
public class Layout {
	private Object[][] gameGrid;
	private Scanner reader;
	private PrintGrid grid;
	public enum plants { S, F, empty , }

	// Creating Grid of [5][7] 
	public Layout() {
		gameGrid = new Object[5][7];
	}
	
	public Object[][] getGameGrid() {
		return gameGrid;
	}

	public void setGameGrid(Object[][] gameGrid) {
		this.gameGrid = gameGrid;
	}

	public void createGrid(int x, int y) {
		gameGrid = new Object [x][y];		
	}
	
	public void placeZombieOnGrid(Zombies z, int randRow) {
		if(gameGrid[randRow][6] == null) {
			gameGrid[randRow][6] = z;
			print(gameGrid);
		}else {
			System.out.print("Not empty");
		}
	}

/*	public void placePlantOnGrid(Plants p) {
		try {
			reader = new Scanner(System.in);  
			System.out.println("Enter the row and column to deploy your Plant.(Ex. 4 2)");
			int inputX = reader.nextInt() -1;
			int inputY = reader.nextInt() -1;
			
			if(gameGrid[inputX][inputY] == null) {
				gameGrid[inputX][inputY] = p;
				print(gameGrid);
			}else {
				System.out.println("There seems to be an already placed Plant here...");
			}
		}
		catch(Exception ex) {
			ex.getMessage();
		}
	} *
	/*
	public void reset() {

		for(int row = 0; row < 5; row++)
		{

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
	public void reset() {	
		for(int row = 0; row < 5; row++)
		{
			for (int column = 0; column < 7; column++)
			{
				gameGrid[row][column] = null;
			}
		}
	}
	public void print() {
		grid = new PrintGrid(gameGrid);
	}
	public void print(Object[][] gameGrid) {
		grid = new PrintGrid(gameGrid);
	}
	 
	public void placeSpawnZombieOnGrid(Zombies z, int randRow) {
		if(gameGrid[randRow][6] == null) {
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

			if(gameGrid[inputX][inputY] == null) {
				if (p instanceof Plants) {
					gameGrid[inputX][inputY] = p;
					grid = new PrintGrid(gameGrid);
				}
				else if (p instanceof Sunflower) {
					gameGrid[inputX][inputY] = p;
					grid  = new PrintGrid(gameGrid);
				}
			}else {
				System.out.println("There seems to be an already placed Plant here...");
				return false;
			}
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return true;
	}
	

	public Object getGrid() {
		return gameGrid;
	}

	public void setObject(int row,int col, Object o) {
		gameGrid[row][col] = o;
	}
	
	public Object getObject(int row,int col) {
		return gameGrid[row][col];
	}
	
	public void placeObjectOnGrid(int row,int col, Object o) {
		if(this.gameGrid[row][col] != null) {
			System.out.println("There is an Object");
		}else {
			gameGrid[row][col] = o;
		}
	}





}
