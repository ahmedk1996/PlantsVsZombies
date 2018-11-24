package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Plants.PotatoMine;
import junit.framework.TestCase;

public class PotatoMineTest extends TestCase{

	private PotatoMine p1;
	
	@Before
	public void setUp() {
		 p1 = new PotatoMine();
	}
	
	@Test
	public void test() { //test case for testing getCost() method with default constructor
		
		assertEquals("Cost of the plant should be 150", 150, p1.getCost());
	}
	
	@Test
	public void test1() { //test case to check both methods - setTurn() and getTurn()
		
		PotatoMine.setTurn(3);
		assertEquals("Should return true if the turn is 3", 3, PotatoMine.getTurn());
	}
	
}
