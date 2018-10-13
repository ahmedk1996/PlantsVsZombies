package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class wave {

	private List zombieList;
	private Layout layout;
	public wave() {
		zombieList = new ArrayList<Object>();
	}
	
	public void startWave() {
		Zombies walkingZombie = new WalkingZombie();
		//other type of zombies
		zombieList.add(walkingZombie);
		//add other zombies
		int index = ThreadLocalRandom.current().nextInt(zombieList.size());
		
		spawnZombies();
		
	}

	private void spawnZombies() {
		
		if(layout.getGrid()==null) {
			
		}
		
	}
}
