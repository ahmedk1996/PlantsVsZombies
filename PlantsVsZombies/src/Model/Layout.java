
package Model;

import Plant.Plants;
import Zombie.RugbyZombie;
import Zombie.SprintZombie;
import Zombie.WalkingZombie;

/**
 * The Layout is a class that contains the methods regarding layout of the game. This includes the setup  
* so the grid layout.
* 
* @author Group 1
* @since November 4,2018

*/
public class Layout {
	private Object[][] gameGrid;


	public int getZombieDeadRow() {
		return ZombieDeadRow;
	}

	public void setZombieDeadRow(int zombieDeadRow) {
		ZombieDeadRow = zombieDeadRow;
	}

	public int getZombieDeadCol() {
		return ZombieDeadCol;
	}

	public void setZombieDeadCol(int zombieDeadCol) {
		ZombieDeadCol = zombieDeadCol;
	}

	private int ZombieDeadRow;
	private int ZombieDeadCol;

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
		gameGrid = new Object[x][y];
	}


	public int placeSpawnWalkingZombieOnGrid(Object[][] gameGrid) {
		int random = (int) (Math.random() * 5 + 0);
		placeWalkingZombieOnGrid(random, 6, new WalkingZombie(), gameGrid);
		return random;
	}
	
	public int placeSpawnSprintZombieOnGrid(Object[][] gameGrid) {
		int random = (int) (Math.random() * 5 + 0);
		placeSprintZombieOnGrid(random, 6, new SprintZombie(), gameGrid);
		return random;
	}
	
	public int placeSpawnRugbyZombieOnGrid(Object[][] gameGrid) {
		int random = (int) (Math.random() * 5 + 0);
		placeRugbyZombieOnGrid(random, 6, new RugbyZombie(), gameGrid);
		return random;
	}
	
	
	

	public Object getGrid() {
		return gameGrid;
	}

	public void setObject(int row, int col, Object o) {
		gameGrid[row][col] = o;
	}

	public Object getObject(int row, int col) {
		return gameGrid[row][col];
	}

	public void moveZombieUpOne(int row, int col, Object o, Object[][] gameGrid) {
		gameGrid[row][col] = o;
	}

	public boolean placeWalkingZombieOnGrid(int row, int col, Object o, Object[][] gameGrid) {
		if (gameGrid[row][col] != null) {
			placeSpawnWalkingZombieOnGrid(gameGrid);

		} else {
			gameGrid[row][col] = o;
		}
		return true;
	}
	
	public boolean placeSprintZombieOnGrid(int row, int col, Object o, Object[][] gameGrid) {
		if (gameGrid[row][col] != null) {
			placeSpawnSprintZombieOnGrid(gameGrid);

		} else {
			gameGrid[row][col] = o;
		}
		return true;
	}
	
	public boolean placeRugbyZombieOnGrid(int row, int col, Object o, Object[][] gameGrid) {
		if (gameGrid[row][col] != null) {
			placeSpawnRugbyZombieOnGrid(gameGrid);

		} else {
			gameGrid[row][col] = o;
		}
		return true;
	}

	public void placePlantOnGrid(int row, int col, Plants p, Object[][] gameGrid) {
		if (gameGrid[row][col] != null) {
			System.out.println("Not Empty");
		} else {
			gameGrid[row][col] = p;
		}
	}

	public void ZombieDead(int row, int column) {
		ZombieDeadRow = row;
		ZombieDeadCol = column;

	}
	
	public Layout getLayoutObject() {
		return this;
	}

}
