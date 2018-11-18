
package Model;

import java.util.Scanner;
import Plant.PlantStore;
import java.io.*;
/**
 * The Game is a class contains the methods regarding starting the game. This includes the setup for it  
 * an example of this would be selecting the game difficulty.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class Game {
	private Layout layout;

	public PlantStore getStore() {
		return store;
	}

	public void setStore(PlantStore store) {
		this.store = store;
	}

	private PlantStore store;

	private int zombieCounter;

	public int getZombieCounter() {
		return zombieCounter;
	}

	public void setZombieCounter(int zombieCounter) {
		this.zombieCounter = zombieCounter;
	}

	public Game(Layout layout, PlantStore store) {
		this.layout = new Layout();
		this.store = new PlantStore();

		zombieCounter = 0;
	}

	/**
	 * start which handles starting the initial game..
	 *
	 * @param gameMode the current game mode
	 * @return void
	 */
	public void start() {

	}

	/**
	 * start which creates a custom layout of the grid
	 *
	 * @param row    row number
	 * @param column column number
	 * @return void
	 */
	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}

	/**
	 * loadHelptxt tells the user instructions about the game when required
	 *
	 * @return void
	 */
	public void loadHelptxt() throws FileNotFoundException {
		String toString = "";
		try {
			Scanner txtFile = new Scanner(new FileReader("Help.txt"));
			while (txtFile.hasNextLine()) {
				toString = toString + txtFile.nextLine() + "\n";
			}
			System.out.println(toString);
		} catch (FileNotFoundException e) {
			System.out.println("Help File Doesn't Exist");
		}
	}

	/**
	 * redo which re-does the users command that he had just made.
	 *
	 * @param unknown
	 * @param unknown
	 * @return void
	 */
	public void redo() {

	}

	/**
	 * undo which which returns the previous game board layout
	 *
	 * @param unknown
	 * @param unknown
	 * @return void
	 */
	public void undo() {

	}

	/**
	 * save which saves the custom layout of the grid with all the instances saved
	 *
	 * @param unknown
	 * @param unknown
	 * @return void
	 */
	public void save() {

	}

	/**
	 * load which loads the custom grid saved initially
	 *
	 * @param unknown
	 * @param unknown
	 * @return void
	 */
	public void load() {

	}
	public Game getGameObject() {
		return new Game(this.layout,this.store);
	}
}
