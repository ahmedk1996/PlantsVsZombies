/**
 * The Sunflower is a class which extends Zombies and uses the methods from zombies. 
 * This allows for high cohesion.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Plant;
public class Sunflower extends Plants {

	private final int cost  = 50;
	private static int sunPoints;
	private int turns;

	public Sunflower(){
		super.setStringtype("S    ");
		super.setHealth(100);
		super.setSpeed(1);
	}

	public int getCost() {
		return cost;
	}
	
	public static void generateSunPoint(){
		sunPoints= sunPoints+50;
	}


}
