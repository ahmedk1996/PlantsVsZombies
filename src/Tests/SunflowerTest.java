package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Plants.Sunflower;
import junit.framework.TestCase;

/**
 * The SunflowerTest is a test class which tests the bare methods 
 * to make sure each testable method is functioning as its 
 * supposed to be.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class SunflowerTest extends TestCase{

	@Test
	public void test() { //this test checks the getCost method in Sunflower class
		Sunflower s1 = new Sunflower();
		assertEquals("Should pass if the cost of a sunflower plant is 50", 50, s1.getCost());
	}
	@Test
	public void testPlantString() { //this test checks the getCost method in Sunflower class
		Sunflower s1 = new Sunflower();
		assertEquals("The String that is placed on the model gridArray", "S", s1.getStringtype());
	}

	
}
