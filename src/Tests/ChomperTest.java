package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Plants.Chomper;
import junit.framework.TestCase;

public class ChomperTest extends TestCase{

	private Chomper p1;
	
	@Before
	public void setUp() {
		 p1 = new Chomper();
	}
	
	@Test
	public void test() { //test case for testing getCost() method with default constructor
		
		assertEquals("Cost of the plant should be 200", 200, p1.getCost());
	}
	
	@Test
	public void test1() { //test case to check both methods - setTurn() and getTurn()
		
		Chomper.setTurn(3);
		assertEquals("Should return true if the turn is 3", 3, Chomper.getTurn());
	}
	
}
