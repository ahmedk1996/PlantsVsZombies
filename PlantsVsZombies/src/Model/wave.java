package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class wave {

	private List zombieList;
	private Layout layout;
	 
	
	public wave() {
		zombieList = new ArrayList<Object>();
		layout =new Layout();
		
	}
	
	public void startWave() {
		Zombies walkingZombie = new WalkingZombie();
		//other type of zombies
		//zombieList.add(walkingZombie);
		//add other zombies
		//int index = ThreadLocalRandom.current().nextInt(zombieList.size());
		spawnZombies(walkingZombie);
		
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min > max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt(max - min) + min;
	}


	private void spawnZombies(Zombies zombie) {
		
		int i = getRandomNumberInRange(1,4);
		layout.placeZombieOnGrid(zombie, i);


		
	}
	
	
}