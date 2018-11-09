package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Layout;
import Model.Turn;
import junit.framework.TestCase;

public class TurnTest extends TestCase{

	private Turn turn;
	@Before
	public void setUp() {
		
		turn = new Turn();

	}
	@Test
	public void testNotNullGameGrid() {
		assertNotNull("The turn class is not null",turn);
	}
	

}
