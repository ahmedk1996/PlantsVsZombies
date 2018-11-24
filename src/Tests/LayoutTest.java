package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Layout;
import junit.framework.TestCase;

public class LayoutTest extends TestCase {

	private Layout layout;
	private int row;
	private int col;
	private Object c;
	
	@Before
	public void setUp() {
		layout = new Layout();

	}
	@Test
	public void testNotNullGameGrid() {
		assertNotNull("The layout class is not null",layout);
	}
	
//Testing both getting and setting an Object onto the game grid. These objects can be of any type of Plant or Zombie.
	@Test
	public void testSetObject() {
		row = 0;
		col=0;
		layout.setObject(row, col, c);
		assertEquals("The two objects are equal",layout.getObject(row, col),c);
	}
	
	
}
