
package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Zombies.RugbyZombie;

import junit.framework.TestCase;


/**
 * The RugbyZombieTest is a test class which tests the bare methods 
 * to make sure each testable method is functioning as its 
 * supposed to be.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class RugbyZombieTest extends TestCase {

	private RugbyZombie rugby;
	
	@Before
	public void setUp() {
		rugby = new RugbyZombie();
	}
	
	
	@Test
	public void testAttack() {
		assertEquals("Should return 80 ", 80, rugby.getAttackDamage());
		
	}
	
	@Test
	public void testDamaged() {
		//Not Using
		//assertEquals("Should return 50 ", 50, rugby.getAttackDamage());
	}
	
	@Test
	public void testTurnOver() {
		//Not Using
	}

	@Test
	public void testSetStringtype() {
		rugby.setStringtype("zombie");
		assertEquals("Should return zomebie","zombie",rugby.getStringtype());
	}
	
	
	@Test
	public void testIsAlive() {
		assertEquals("should return True",true,rugby.isAlive());
	}
	

	@Test
	public void testGetSpeed() {
		assertEquals("should return 1",1,rugby.getSpeed());
	}
	
	@Test
	public void testGetHealth() {
		assertEquals("should return 150",150,rugby.getHealth());
	}
	
	@Test
	public void testGetResistant() {
		assertEquals("should return 0",0,rugby.getResistant());
	}
	
	@Test
	public void testSetSpeed() {
		rugby.setSpeed(3);
		assertEquals("should return 3",3,rugby.getSpeed());
	}
	
	@Test
	public void testSetHealth() {
		rugby.setHealth(10);
		assertEquals("should return 10",10,rugby.getHealth());
	}
	@Test
	public void testGetAttackDamage() {
		assertEquals("should return 80",80,rugby.getAttackDamage());
	}
	@Test
	public void testSetAttackDamage() {
		rugby.setAttackDamage(100);
		assertEquals("should return 100",100,rugby.getAttackDamage());
	}

	
	
	@Test
	public void testSetResistant() {
		rugby.setResistant(10);
		assertEquals("should return 10",10,rugby.getResistant());
	}


}

