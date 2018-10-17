package Model;

import java.util.*;



public class wave {

	private List zombieList;
	private Layout layout;
	private Turn turn; 
	private int numOfZombies;
	
	public wave(int numOfZombies) {
		zombieList = new ArrayList<Object>();
		layout =new Layout();
		turn = new Turn();
		this.numOfZombies = numOfZombies;

	}
	
	public void startWave() {
		
		
		while (numOfZombies!=0) {
			Zombies walkingZombie = new WalkingZombie();
			spawnZombies(walkingZombie);
		}
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min > max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt(max - min) + min;
	}


	private void spawnZombies(Zombies zombie) {
		
		boolean spawn = turn.canZombieSpawn(zombie, 3);
		if (spawn ==true) {
			numOfZombies=numOfZombies-1;
		}
		int i = getRandomNumberInRange(1,4);
		layout.placeZombieOnGrid(zombie, i);
		turn = new Turn();
		turn.canZombieMove(zombie, 3);

		
	}
	
	
}