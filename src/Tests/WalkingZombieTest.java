
package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Zombies.WalkingZombie;
import junit.framework.TestCase;


/**
 * The WalkingZombieTest is a test class which tests the bare methods 
 * to make sure each testable method is functioning as its 
 * supposed to be.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class WalkingZombieTest extends TestCase {

	WalkingZombie walkingZ;
	
	@Before
	public void setUp() {
		walkingZ = new WalkingZombie();
	}
	
	
	@Test
	public void testAttack() {
		assertEquals("Should return 50 ", 50, walkingZ.getAttackDamage());
		
	}
	
	@Test
	public void testDamaged() {
		//Not Using
		//assertEquals("Should return 50 ", 50, walkingZ.getAttackDamage());
	}
	
	@Test
	public void testTurnOver() {
		//Not Using
	}

	
	@Test
	public void testSetStringtype() {
		walkingZ.setStringtype("zombie");
		assertEquals("Should return zomebie","zombie",walkingZ.getStringtype());
	}
	
	
	@Test
	public void testIsAlive() {
		assertEquals("should return True",true,walkingZ.isAlive());
	}
	

	@Test
	public void testGetSpeed() {
		assertEquals("should return 1",1,walkingZ.getSpeed());
	}
	
	@Test
	public void testGetHealth() {
		assertEquals("should return 100",100,walkingZ.getHealth());
	}
	
	@Test
	public void testGetResistant() {
		assertEquals("should return 0",0,walkingZ.getResistant());
	}
	
	@Test
	public void testSetSpeed() {
		walkingZ.setSpeed(3);
		assertEquals("should return 3",3,walkingZ.getSpeed());
	}
	
	@Test
	public void testSetHealth() {
		walkingZ.setHealth(10);
		assertEquals("should return 10",10,walkingZ.getHealth());
	}
	@Test
	public void testGetAttackDamage() {
		assertEquals("should return 50",50,walkingZ.getAttackDamage());
	}
	@Test
	public void testSetAttackDamage() {
		walkingZ.setAttackDamage(100);
		assertEquals("should return 100",100,walkingZ.getAttackDamage());
	}

	
	
	@Test
	public void testSetResistant() {
		walkingZ.setResistant(10);
		assertEquals("should return 10",10,walkingZ.getResistant());
	}


}

