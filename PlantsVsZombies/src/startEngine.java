import Controller.Controller;
import Model.Game;
import Model.Layout;
import Plant.PlantStore;
import View.View;

public class startEngine {
	public static void main(String[] args)
	{
		View view = new View();
		Layout layout = new Layout();
		PlantStore store = new PlantStore();
		Game game = new Game(layout, store); // aka model
		Controller controller = new Controller(game , view );
	}
}
