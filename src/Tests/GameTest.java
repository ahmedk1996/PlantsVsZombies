package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Game;
import Model.Layout;
import Plants.PlantStore;
import junit.framework.TestCase;

public class GameTest extends TestCase {
	
	private Game game;
	private Layout layout;
	private PlantStore ps;
	private int  zombieCounter = 4;
	private int level = 1;
	
	
	@Before
	public void setUp() {
		layout = new Layout();
		ps = new PlantStore();
		game = new Game(layout,ps,zombieCounter,level);
	}

	@Test
	public void testNotNull() {
		assertNotNull("The game class is not null", game);
	}
	

}
