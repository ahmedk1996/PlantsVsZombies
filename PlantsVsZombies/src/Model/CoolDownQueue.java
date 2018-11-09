
package Model;


import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;
import java.util.Queue;
import Plant.Plants;
import Plant.ShootingPlant;
import Plant.Sunflower;

public class CoolDownQueue implements Observer{
	String name;
	Queue<Plants> queue; 
	
	public CoolDownQueue(Plants plant) {
		queue = new LinkedList<Plants>();
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
		
		for(int i=0; i<plant.getCooldown(); i++) {
			queue.add(plant);
		}
		
		/**
		if(plant instanceof ShootingPlant) {
			for(int i=0; i<plant.getCooldown(); i++) {
				queue.add(new ShootingPlant());
			}
		}else {
			for(int i=0; i<plant.getCooldown(); i++) {
				queue.add(new Sunflower());
			}
		}**/
		
		
		System.out.println(plant.getName() + "'s Cool Down : " + getRemaining());
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		queue.poll();
		
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

