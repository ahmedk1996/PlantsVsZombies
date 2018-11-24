/*package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Action;
import Model.Layout;
import Zombie.WalkingZombie;
import junit.framework.TestCase;

public class ActionTest extends TestCase {
	
	private Action action;
	private Layout layout;
	private WalkingZombie z;
	private Object o;
	
	@Before
	public void setUp() {
		action = new Action();
		layout = new Layout();
		z = new WalkingZombie();
	}
	
	@Test
	public void testNotNull() {
		assertNotNull("Action is not null",action);
	}
	
	@Test
	public void testGameNotClear() {
		
		layout.setObject(0, 0, z);
		
		assertFalse("The game is not cleared yet...",action.gameClear(layout));
	}
	
	@Test
	public void testGameClear() {
		
		layout.setObject(0, 0, o);
		
		assertTrue("The game is cleared ...",action.gameClear(layout));
	}
	
	@Test
	public void testIsGameOver() {
		
		layout.setObject(0, 0, z);
		
		assertFalse("The game is over ...",action.gameClear(layout));
	}
	
	@Test
	public void testIsNotGameOver() {
		
		layout.setObject(0, 0, o);
		
		assertTrue("The game is not over ...",action.gameClear(layout));
	}
	
	
}
*/