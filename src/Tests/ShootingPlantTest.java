package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Plants.ShootingPlant;
import junit.framework.TestCase;

/**
 * The ShootingPlantTest is a test class which tests the bare methods 
 * to make sure each testable method is functioning as its 
 * supposed to be.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class ShootingPlantTest extends TestCase{

	@Test
	public void test() { //test case for testing getCost() method with default constructor
		ShootingPlant p1 = new ShootingPlant();
		assertEquals("Cost of the plant should be 100", 100, p1.getCost());
	}
	
	@Test
	public void test1() { //test case to check both methods - setTurn() and getTurn()
		//ShootingPlant p1 = new ShootingPlant ();
		ShootingPlant.setTurn(3);
		assertEquals("Should return true if the turn is 3", 3, ShootingPlant.getTurn());
	}
	
}
