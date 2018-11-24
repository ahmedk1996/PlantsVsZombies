package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import Model.CoolDown;
import Model.CoolDownQueue;
import Plants.Plants;
import Plants.ShootingPlant;
import junit.framework.TestCase;

public class CoolDownQueueTest extends TestCase {
	CoolDownQueue q;
	String name;
	Queue<Plants> queue; 
	
	@Before
	public void setUp() {
		
		ShootingPlant sp = new ShootingPlant();
		q = new CoolDownQueue(sp);
		queue = new LinkedList<Plants>();
		this.name = sp.getName();
		//addCooldown(plant);
	}

	@Test
	//public void addCooldown(Plants plant)
	public void test() {
		ShootingPlant sp = new ShootingPlant();
		q.addCooldown(sp);
		assertTrue("in the queue, plant has been saved",q.getQueue().contains(sp));
		
	}
	@Test
	//getname()
	public void test2() {
		ShootingPlant sp = new ShootingPlant();
		assertEquals("getName should be ShootingPlant",sp.getName(),q.getName());
	}
	@Test
	//GetRemaint()
	public void test3() {
		assertEquals("",2,q.getRemaining());
	}
	@Test
	public void test4() {
		assertFalse("isempty should be false",q.isEmpty());
	}
	
}
