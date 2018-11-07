package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Plant.PlantStore;
import Plant.Sunflower;
import junit.framework.TestCase;

public class SunflowerTest extends TestCase{

	@Test
	public void test() { //this test checks the getCost method in Sunflower class
		Sunflower s1 = new Sunflower();
		assertEquals("Should pass if the cost of a sunflower plant is 50", 50, s1.getCost());
	}

	
}
