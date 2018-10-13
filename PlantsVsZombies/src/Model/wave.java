package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class wave {

	List zombieList;
	public wave() {
		zombieList = new ArrayList<Object>();
	}
	
	public void startWave() {
		Zombies walkingZombie = new WalkingZombie();
		//other type of zombies
		zombieList.add(walkingZombie);
		//add other zombies
		int index = ThreadLocalRandom.current().nextInt(zombieList.size());
		
		//
		spawnZombies();
		
	}

	private void spawnZombies() {
		// TODO Auto-generated method stub
		//randomly spawns zombies
		
	}
}
