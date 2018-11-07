
package Model;


import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import java.util.Queue;
import Plant.Plants;

public class CoolDownQueue implements Observer{
	String name;
	PriorityQueue<Plants> queue; 
	
	public CoolDownQueue(Plants plant) {
		queue = new PriorityQueue<Plants>();
		this.name = plant.getName();
		addCooldown(plant);
	}
	/**
	 * depends on the type of the plant, it checks the cool-down of the plants
	 * and add it to the queue.
	 * 
	 * @param plant
	 */
	
	public void addCooldown(Plants plant) {
		for(int i=0;i<plant.getCooldown();i++) {
			queue.add(plant);
		}
		System.out.println(plant.getName() + "'s Cool Down : " + getRemaining());
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		queue.remove();
		
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
	public void setQueue(PriorityQueue<Plants> queue) {
		this.queue = queue;
	}

	public int getRemaining() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
	
	public void removeCooldown() {
		queue.remove();
	}
	
	
}

