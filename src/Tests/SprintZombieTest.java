
package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Zombies.SprintZombie;
import junit.framework.TestCase;

public class SprintZombieTest extends TestCase {

	private SprintZombie sprintZ;
	
	@Before
	public void setUp() {
		sprintZ = new SprintZombie();
	}
	
	
	@Test
	public void testAttack() {
		assertEquals("Should return 50 ", 50, sprintZ.getAttackDamage());
		
	}
	
	@Test
	public void testDamaged() {
		//Not Using
		//assertEquals("Should return 50 ", 50, sprintZ.getAttackDamage());
	}
	
	@Test
	public void testTurnOver() {
		//Not Using
	}

	
	@Test
	public void testSetStringtype() {
		sprintZ.setStringtype("zombie");
		assertEquals("Should return zomebie","zombie",sprintZ.getStringtype());
	}
	
	
	@Test
	public void testIsAlive() {
		assertEquals("should return True",true,sprintZ.isAlive());
	}
	

	@Test
	public void testGetSpeed() {
		assertEquals("should return 5",5,sprintZ.getSpeed());
	}
	
	@Test
	public void testGetHealth() {
		assertEquals("should return 100",100,sprintZ.getHealth());
	}
	
	@Test
	public void testGetResistant() {
		assertEquals("should return 0",0,sprintZ.getResistant());
	}
	
	@Test
	public void testSetSpeed() {
		sprintZ.setSpeed(3);
		assertEquals("should return 3",3,sprintZ.getSpeed());
	}
	
	@Test
	public void testSetHealth() {
		sprintZ.setHealth(10);
		assertEquals("should return 10",10,sprintZ.getHealth());
	}
	@Test
	public void testGetAttackDamage() {
		assertEquals("should return 50",50,sprintZ.getAttackDamage());
	}
	@Test
	public void testSetAttackDamage() {
		sprintZ.setAttackDamage(100);
		assertEquals("should return 100",100,sprintZ.getAttackDamage());
	}

	
	
	@Test
	public void testSetResistant() {
		sprintZ.setResistant(10);
		assertEquals("should return 10",10,sprintZ.getResistant());
	}


}

