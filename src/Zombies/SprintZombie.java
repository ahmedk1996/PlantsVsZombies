
package Zombies;
/**
 * The SprintZombie is a class which extends Zombies and uses the methods from zombies.  
 * This type of zombie walks at a fast pace hence the name.
 * Setting an abstract class for both Plants and Zombies allows for high cohesion.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class SprintZombie extends Zombies{
	
	/**
	 *  Initialize the starting state of the zombie
	 * 
	 * @param None
	 * @return None
	 */
	public SprintZombie() {

		super.setName("SprintZombie");
		super.setStringtype("SZ");

		super.setSpeed(5);
		super.setHealth(150);
		super.setAttackDamage(50);
		super.setWeapon(null);
	}
}
