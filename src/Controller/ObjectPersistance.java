package Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Game;

public class ObjectPersistance {
	Game game = null;
	String filename = "time.ser";
	public void save(Game orig) {
        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(game);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public Game load() {
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            game = (Game) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return game;
    }
	
}
