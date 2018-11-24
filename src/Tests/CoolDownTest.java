package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Model.CoolDown;
import Model.CoolDownQueue;
import Plants.ShootingPlant;
import junit.framework.TestCase;

public class CoolDownTest extends TestCase {
/**
 * assertTrue(book.size() == 0);
 * assertEquals(1, book.size());
 * assertFalse(), assertNull()�
 * protected void tearDown() ;
 */

	CoolDown list;
	ShootingPlant sp;
	CoolDownQueue queue;
	@Before
	public void setUp() {
		//qL = new ArrayList<CoolDownQueue>();
		list = new CoolDown();
		sp= new ShootingPlant();
		queue = new CoolDownQueue(new ShootingPlant()); 
	}
	@Test
	//test for purchasePlant
	public void test() {
		sp= new ShootingPlant();
		list.purchasePlant(sp);
		assertEquals("hmm",sp.getName(),list.getPlantQueue(sp).getName());
	}
	
	
	@Test 
	//test for getPlantQueue
	public void test2() {
		list.purchasePlant(sp);
		list.getPlantQueue(sp).equals(sp);
		
	}
	
	@Test 
	//public int cooldownRemaining(Plants plant)
	public void test3() {
		sp= new ShootingPlant();
		list.purchasePlant(sp);
		assertEquals("ShootingPlant's remaining turns are 2", 2,list.cooldownRemaining(sp));
	
	}
	@Test 
	//public boolean validatePurchase(Plants plant)
	public void test4() {
		sp= new ShootingPlant();
		list.purchasePlant(sp);
		assertFalse("plant is just bought therefore, it should return false",list.validatePurchase(sp));
	}
	
	
	}