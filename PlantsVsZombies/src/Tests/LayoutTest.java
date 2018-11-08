package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Layout;
import junit.framework.TestCase;

public class LayoutTest extends TestCase {

	Object[][] gameGrid;
	
	@Before
	public void setUp() {
		gameGrid = new Object[5][7];
	}
	
	public void testGetGameGrid() {
		assertNotNull("The game is not null",gameGrid);
	}
	
	public void testSetGameGrid() {
		Object[][] gameGrid2 = new Object[5][7];
		
		assertEquals("The gamegrids are equal",gameGrid,gameGrid2);
	}

}
