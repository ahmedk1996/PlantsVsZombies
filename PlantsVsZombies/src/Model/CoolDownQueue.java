package Model;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import Plant.Plants;
import Plant.ShootingPlant;

public class CoolDownQueue implements Observer{
	String name;
	Queue<Plants> queue; 
	
	
	public CoolDownQueue() {
		
	}
	/**
	 * .
	 *
	 * @param  Plant
	 * 	 * @return      result of the game
	 */
	public void createCoolDown(Plants plant) {
		queue = new LinkedList<>();
		this.name = plant.getName();
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Queue<Plants> getQueue() {
		return queue;
	}
	public void setQueue(Queue<Plants> queue) {
		this.queue = queue;
	}

	public int getRemaining() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
	
	public void addCooldown() {
		
	}
}
