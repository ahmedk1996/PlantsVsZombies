package Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import Model.Game;
/**
 * 	
	 * Reflections: We needed to store a copy of the object, send them to another process which runs on the same system.
	 * Serializable makes storing and sending objects easy which is why we chose it to implement save and load.
 */
public class ObjectPersistance implements Serializable {
	public ObjectPersistance() {		
	}
	/**
	 *It saves the object file 
	 * 
	 * 	@param Game 
	 * @return None
	 */
	public void save(Game c) {
		// save the object to file
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("save.sav");
			out = new ObjectOutputStream(fos);
			out.writeObject(c);

			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 *It load the object file 
	 * 
	 * 	@param None 
	 * @return Game
	 */
	
	public Game load() {
		Game con = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {

			fin = new FileInputStream("save.sav");
			ois = new ObjectInputStream(fin);
			con = (Game) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return con;
	}

}
