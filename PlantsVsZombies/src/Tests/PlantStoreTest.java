package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Plant.PlantStore;
import Plant.Plants;
import Plant.ShootingPlant;
import junit.framework.TestCase;

public class PlantStoreTest extends TestCase{
	
	
	@Test
	public void test() { //this test checks current balance for SunPoints
		PlantStore ps = new PlantStore(true);
		assertEquals("The starting Sunpoints value should be 150", 150, ps.getSunPoints());
	}
	
	@Test
	public void test1() { //this test checks the setSunPoints method
		PlantStore ps = new PlantStore(true);
		ps.setSunPoints(500);
		assertEquals("The sunflower points should now be set to 500", 500, ps.getSunPoints());
	}
	
	@Test
	public void test2() { //this is a bogus test case (this is allowed because we have a validate method that will check this value)
		PlantStore ps = new PlantStore(true);
		ps.setSunPoints(-500);
		assertEquals("The sunflower points should now be set to 500", -500, ps.getSunPoints());
	}
	
	@Test
	public void test3() { //this test case tests the return cost of the pea shooter
		PlantStore ps = new PlantStore(true);
		assertEquals("The PeaShooter cost should be 100", 100, ps.getPeaShooterCost());
	}
	
	@Test
	public void test4() { //this test case tests the return cost of the sun flower
		PlantStore ps = new PlantStore(true);
		assertEquals("The PeaShooter cost should be 50", 50, ps.getSunFlowerCost());
	}
	
	@Test
	public void test5() { //this test checks the increment method which adds 50 points to the current amount
		PlantStore ps = new PlantStore(true);
		ps.setSunPoints(300);
		ps.incrementSunPoints();
		assertEquals ("This should return 350 after the increment", 350, ps.getSunPoints());
	}

/*	@Test
	public void test6() { //this test is for validate purchase for a successful case
		PlantStore ps = new PlantStore();
		ShootingPlant p1 = new ShootingPlant();
		assertTrue ("Should return true because current balance is 150 and shooting plant cost 100", ps.validatePurchase(p1, ps.getSunPoints()));
	}*/
	
	/*@Test
	public void test7() { //this test is for validate purchase for a unsuccessful case
		PlantStore ps = new PlantStore();
		ps.setSunPoints(50);
		ShootingPlant p1 = new ShootingPlant();
		assertFalse ("Should return false because current balance is 150 and shooting plant cost 100", ps.validatePurchase(p1, ps.getSunPoints()));
	}*/
}
