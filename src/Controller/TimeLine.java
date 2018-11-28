package Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import Model.Game;
/**
 * The TimeLine class is a class which contains all the actions used to allow the 
 * user to back and forth in a game (undo/redo)
 * 
 * The reason why we used data structure, ArrayList is because the storage has to be modifiable.
 * when the user makes new movement after undo then whatever it is already stored before, must be removed and
 * saves new statement of the game.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class TimeLine implements Serializable{
	private ArrayList<Game> timeStore;
	private int currenti;

	public TimeLine () {
		timeStore = new ArrayList<Game>();
		currenti = 0;
	}
	public TimeLine (Game game) {
		timeStore = new ArrayList<Game>();
		Game temp = deepCopy(game);
		timeStore.add(temp);
		currenti = 0;
	}
	/*
	 * stores the game status in to arraylist.
	 * @param Game
	 * @return void - new board with forward state
	 *
	 */
	public void addNext(Game game) {

		Game temp = deepCopy(game);
		
		//Controller(Game game, View view,Layout layout,PlantStore ps, Action action, Turn turn, CoolDown c,int stag)
		if(timeStore.size()> currenti+1) {
			for(int i = currenti;  i<timeStore.size()-1  ;i++) {
				timeStore.remove(i);
			}
			timeStore.add(temp);		
			currenti++;
		}else{ 
			timeStore.add(temp);
			currenti++;
		}
	}
	/*
	 * need to do "depp copy"
	 * Taking a game parameter will cause "field-by-field copy,field-for-field copy, or field copy".
	 * therefore, need to save it independently using serialization there were other ways but I used serialization for next milestone.
	 *
	 * 	Lets the user go forward if a undo was preivously selected
	 *	
	 *	@param Game
	 * 	@return Game - new board with forward state
	 */
	
	public Game deepCopy(Game orig) {
		Game obj = null;
		try {
			// Write the object out to a byte array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(orig);
			out.flush();
			out.close();

			// Make an input stream from the byte array and read
			// a copy of the object back in.
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(bos.toByteArray()));
			obj = (Game) in.readObject();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		return (Game) obj;
	}


	/**
	 * 	Checks if an undo can be made
	 * 
	 * 	@param None
	 * @return boolean - true if yes, false if no
	 */
	public boolean isUndoAvailable() {
		if(currenti-1 < 0) {
			return false;
		}else
			return true;
	}
	
	/**
	 * Checks if an undo has been made. If yes returns true, otherwise false
	 * 
	 * 	@param None
	 * @return boolean - returns true if the redo option is available
	 */
	public boolean isRedoAvailable(){
		if(timeStore.size() > currenti+1) {
			return true;
		}else
			return false;
	}

	/**
	 * 	Lets the user go back to previous state before his/her move
	 * 
	 * 	@param None
	 * @return Game - new board with previous state
	 */
	public Game undo() {
			Game game = timeStore.get(currenti-1);
			currenti--;
			return game;
	}

	/**
	 * 	Lets the user go forward if a undo was preivously selected
	 * 
	 * 	@param None
	 * @return Game - new board with forward state
	 */
	public Game redo() {
		if(timeStore.size() > currenti+1) {
			Game game = timeStore.get(currenti+1);
			currenti++;
			return game;
		}else {
			return timeStore.get(currenti);
		}
	}

}
