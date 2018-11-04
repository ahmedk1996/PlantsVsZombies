/**
 * The turn is a class which contains the methods in regards to the turns and to whether the sunflower 
 * plants can generate point or if zombies can move.
 * 
 * @author Group 1
 * @since November 4,2018

 */


package Model;
import Plant.PlantStore;
import Plant.Plants;
import Plant.Sunflower;
import Zombie.Zombies;

public class Turn {
	
	private static int count = 1;
	private Layout layout;

	public static int getCount() {
		return count;
	}

	public Turn() {

		layout = new Layout();
	}

	/**
	 * canZombieMove which handles results of the zombies movaeable
	 *
	 * @param  z  type of Zombie
	 * @param  turn the current turn
	 * @return      result of whether zombie is movable (moves the zombie)
	 */
	public boolean canZombieMove(Zombies z, int currentTurn) {
		if (z instanceof Zombies) {
			if (currentTurn % z.getSpeed() == 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * canSunFlowerGenerate which handles results of the plants ability to generate points
	 *
	 * @param  currentTurn  current turn
	 * @param  p the plant type
	 * @param  store  the store amount
	 * @return      increments the sunflower points
	 */
	public boolean canSunFlowerGenerate(int currentTurn , Plants p, PlantStore store) {

		if (p instanceof Sunflower) {
				if (currentTurn % p.getSpeed() == 0) {
					store.incrementSunPoints();
					return true;
				}
				return false;
			}
			return false;
		}
}

