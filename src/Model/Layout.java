
package Model;

import java.io.Serializable;

import Plants.Plants;
import Zombies.Zombies;
import Zombies.RugbyZombie;
import Zombies.SprintZombie;
import Zombies.WalkingZombie;

/**
 * The Layout is a class that contains the methods regarding layout of the game. This includes the setup  
* so the grid layout.
* 
* Reflections: We decided to use a grid Arraylist is because the storage has to be modifiable.
 * when the user makes new movement after undo then whatever it is already stored before, must be removed and
 * saves new statement of the game.
* 
* @author Group 1
* @since November 4,2018

*/
public class Layout implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[][] gameGrid;
	private Status status;
	public Layout() {
		gameGrid = new Object[5][7];
		this.status = Status.created;
	}
	
	public Layout(Object[][] gamegrid,Status status) {
		this.gameGrid = gamegrid;
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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

	public void placeSpawnZombieOnGrid(Zombies z) {
		int range = (4 - 0) + 1;
		int random = (int)(Math.random() * range) + 0;
		if (gameGrid[random][6] != null) {
			placeSpawnZombieOnGrid(z);
		} else {
			gameGrid[random][6] = z;
		}
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

	public void moveZombieUpOne(int row, int col, Object o) {
		gameGrid[row][col] = o;
	}

	
	public void placePlantOnGrid(int row, int col, Plants p) {
		if (gameGrid[row][col] != null) {
			System.out.println("Not Empty");
		} else {
			gameGrid[row][col] = p;
		}
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

	public Layout getLayoutObject() {
		return this;
	}

}
