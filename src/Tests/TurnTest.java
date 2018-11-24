//package Tests;
//
//
//import org.junit.Before;
//import org.junit.Test;
//
//import Model.Turn;
//import Plant.PlantStore;
//import Plant.Sunflower;
//import Zombie.WalkingZombie;
//import junit.framework.TestCase;
//
//public class TurnTest extends TestCase{
//
//	private Turn turn;
//	private WalkingZombie z;
//	private Sunflower p;
//	private PlantStore s;
//	
//	@Before
//	public void setUp() {
//		
//		turn = new Turn();
//		s = new PlantStore();
//		z = new WalkingZombie();
//		p = new Sunflower();
//	}
//	
//	@Test
//	public void testNotNullGameGrid() {
//		assertNotNull("The turn class is not null",turn);
//	}
//	
//	
//	@Test
//	public void testCanZombieMoved() {
//	
//		assertTrue("Its Zombies turn to move",	turn.canZombieMove(z, 1));
//	}
//	
//	@Test
//	public void testCannotZombieMoved() {
//		z.setSpeed(3);
//		assertFalse("Its not Zombies turn to move",	turn.canZombieMove(z, 1));
//	}
//	
//	@Test
//	public void testCanSunFlowerGenerate() {
//		
//		assertTrue("Can generate Sun Points", turn.canSunFlowerGenerate(1, p, s));
//	}
//
//	@Test
//	public void testCannotSunFlowerGenerate() {
//		p.setSpeed(3);
//		assertFalse("Cannot generate Sun Points", turn.canSunFlowerGenerate(2, p, s));
//	}
//
//}
