/**
 * The Layout is a class that contains the methods regarding layout of the game. This includes the setup 
 * so the grid layout.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Model;
import java.util.*;
import java.util.Random;

import Plant.Plants;
import Plant.ShootingPlant;
import Plant.Sunflower;
import Zombie.WalkingZombie;
import Zombie.Zombies;

public class Layout {
	private  Object[][] gameGrid;
	private Scanner reader;
	private PrintGrid grid;
	private int max;
	private int min;
	private boolean valid;

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
	 
	public void placeSpawnZombieOnGrid(Layout layout) {
		int random = (int)(Math.random() * 4 + 1);
		if (layout.gameGrid[random][6] == null) {
			placeObjectOnGrid(random, 6, new WalkingZombie());
		}
		return;
	}
	

	public boolean placePlantOnGrid(Plants p ) {
		
	try {
		
			reader = new Scanner(System.in);  
			System.out.println("Enter the row and column to deploy your Plant.(Ex. 4 2)");
			int inputX = reader.nextInt();
			int inputY = reader.nextInt();

			
				if (p instanceof ShootingPlant) {
					valid = placeObjectOnGrid(inputX , inputY, new ShootingPlant());
				}
				else if (p instanceof Sunflower) {
					valid = placeObjectOnGrid(inputX, inputY, new Sunflower());
				}
				
				if (valid == false) {
					System.out.println("Please re-type the row and column");
					placePlantOnGrid(p);
				}
			
			this.print();
			
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
			System.out.println("You can't place your plant here.");
			return false;
		}else {
			gameGrid[row][col] = o;
		}
		return true;
	}





}
