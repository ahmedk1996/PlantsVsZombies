//package Tests;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import Model.Game;
//import Model.Layout;
//import Plant.PlantStore;
//import junit.framework.TestCase;
//
//public class GameTest extends TestCase {
//	private Game game;
//	private Layout layout;
//	private PlantStore ps;
//	@Before
//	public void setUp() {
//		layout = new Layout();
//		ps = new PlantStore();
//		game = new Game(layout,ps);
//	}
//
//	@Test
//	public void testNotNull() {
//		assertNotNull("The game class is not null", game);
//	}
//	
//
//	@Test
//	public void testSetZombieCounter() {
//		game.setZombieCounter(3);
//		assertEquals("Zombie counter is 3",3,game.getZombieCounter());
//		assertNotEquals("Zombie counter and value are not equal",4,game.getZombieCounter());
//	}
//	
//
//	
//
//}
