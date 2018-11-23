

package Plants;
/**
 *  The Sunflower is a class which extends Zombies and uses the methods from zombies. 
 * 	Sunflower allows for more points to be genreated on the field.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class Sunflower extends Plants {

	private final int cost  = 50;
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param None
	 * @return None
	 */
	public Sunflower(){
		super.setStringtype("S");
		super.setHealth(100);
		super.setSpeed(1);
		super.setName("Sunflower");
	}

	/**
	 *  gets the plants cost
	 * 
	 * @param None
	 * @return int - the plants cost
	 */
	public int getCost() {
		return cost;
	}
	
	

}
