
import Controller.Controller;
import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import View.View;
/**
 * The startEngine is a class contains the main method for initializing the game.
 * This was made in order to maintain high cohesion throughout our project.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public class startEngine {
	public static void main(String[] args)
	{
		View view = new View();
		Layout layout = new Layout();
		PlantStore store = new PlantStore();
		Game game = new Game(layout, store); // aka model
		Controller controller = new Controller(game , view, store );
	}
}
