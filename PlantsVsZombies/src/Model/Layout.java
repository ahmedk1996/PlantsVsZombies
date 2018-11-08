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

import Controller.Controller;
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

	public void print() {
		grid = new PrintGrid(gameGrid);
	}
	public void print(Object[][] gameGrid) {
		grid = new PrintGrid(gameGrid);
	}
	 
	public int placeSpawnZombieOnGrid(Object[][] gameGrid) {
		int random = (int)(Math.random() * 5 + 0);
		placeObjectOnGrid(random, 6, new WalkingZombie() , gameGrid);
		return random;
	}
	

/*	public boolean placePlantOnGrid(Plants p ) {
				if (p instanceof ShootingPlant) {
					valid = placeObjectOnGrid(inputX , inputY, new ShootingPlant());
				}
				else if (p instanceof Sunflower) {
					valid = placeObjectOnGrid(inputX, inputY, new Sunflower());
				}
					return true;
	}*/

	public Object getGrid() {
		return gameGrid;
	}
 
	public void setObject(int row,int col, Object o) {
		gameGrid[row][col] = o;
	}
	
	public Object getObject(int row,int col) {
		return gameGrid[row][col];
	}
	
	
	
	public boolean placeObjectOnGrid(int row,int col, Object o, Object[][] gameGrid) {
		if(gameGrid[row][col] != null) {
			placeSpawnZombieOnGrid(gameGrid);
			
		}else {
			gameGrid[row][col] = o;
		}
		return true;
	}

	public void placePlantOnGrid(int row , int col , Plants p ,Object[][] gameGrid ) {
		if(gameGrid[row][col] != null) {
			System.out.println("Not Empty");
		}
		else {
			gameGrid[row][col] = p;
		}
	}



}
