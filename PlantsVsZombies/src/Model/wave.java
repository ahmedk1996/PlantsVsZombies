package Model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class wave {
	private int count = 0;
	private ArrayList<Zombies> zombieList;
	int place;
	private Layout layout;
	 
	public wave(Layout game) {
		zombieList = new ArrayList<Zombies>();
		layout = game;
	}
	
	public Layout startWave() {
		Zombies walkingZombie = new WalkingZombie();
		spawnZombies(walkingZombie);
		return layout;
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
	
	public void level(int lvl) {
		if(lvl == 1) {
			 zombieList.add(new WalkingZombie());
		}
	}

	private void spawnZombies(Zombies zombie) {
		
		place = getRandomNumberInRange(0,4);
		layout.placeZombieOnGrid(zombie, place);
	}
	
	
}