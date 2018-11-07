package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Queue;

import Plant.Plants;


/**
 * @author Hun
 * This Class is CoolDown for Storing, checking the plants cool-down for each plants.
 * We decided to use queue to store, trace, and validate each plant's cool-down for further extention.
 * Queue data-structure is first in and first out. 
 * the functionalities of the queue ex) pop, push fit with automated reduction cool-down. 
 * 
 * We are using Observe pattern to notify every plant CoolDown queue to reduce the cool-down.
 * 
 */
public class CoolDown extends Observable{
	//contains the queue of each plants
	ArrayList<CoolDownQueue> queueList; 
	
	public CoolDown() {
		
	}
	
	public void turnOver(){
		setChanged();
	    notifyObservers();
	}
	
	/**
	 * checkingQueue checks there is queue for the plants.
	 * @param plant
	 * @return boolean
	 */
	
	public boolean checkingQueue(Plants plant) {
		for(CoolDownQueue queue : queueList) {
			if(queue.name.equals(plant.getName())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * It return the number of for cooldown of the given plants the turns the queue and return how many turns is remaining.
	 * @param plant
	 * @return int
	 */
	
	public CoolDownQueue getPlantQueue(Plants plant) {
		for(int i = 0; i <queueList.size();i++ ) {
			if(queueList.get(i).getName().equals(plant.getName())) {
				return queueList.get(i);
			}
		}
		return null; // In case of error
	}
	public int cooldownRemaining(Plants plant) {
		for(CoolDownQueue queue : queueList) {
			if(queue.name.equals(plant.getName())) {
				return queue.getRemaining();
			}
		}
		return -1; // error if there isn't queue;
	}
	
	/**
	 * When user buy the plant, First check, if it is been purchased before,
	 * then just addCooldown based on the
	 * @param plant
	 */
	public void purchasedPlant(Plants plant) {
		if(!checkingQueue(plant)) {
			this.queueList.add(new CoolDownQueue(plant));
		}else {
			if(getPlantQueue(plant).isEmpty()) {
				getPlantQueue(plant).addCooldown(plant);
			}else
				System.out.println("CoolDown Remaining : " + getPlantQueue(plant).getRemaining());
			}
		}
	}

