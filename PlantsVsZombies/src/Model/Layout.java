package Model;
import java.util.*;
public class Layout {
	private  Object[][] gameGrid;
	private Scanner reader;
	private PrintGrid grid;


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
				if (p instanceof ShootingPlant) {
					placeObjectOnGrid(inputX,inputY,new ShootingPlant());
				}
				else if (p instanceof Sunflower) {
					placeObjectOnGrid(inputX,inputY,new Sunflower());
				}
				
			}
			//grid = new PrintGrid(gameGrid);
			print();
			
	}
	catch(ArrayIndexOutOfBoundsException exception) {
		System.out.println("Can't place on the grid");

		
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
	
	public boolean placeObjectOnGrid(int row,int col, Object o) {
		if(this.gameGrid[row][col] != null) {
			System.out.println("There is an Object");
			return false;
		}else {
			gameGrid[row][col] = o;
		}
		return true;
	}





}
