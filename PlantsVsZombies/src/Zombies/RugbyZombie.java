
package Zombies;
/**
 * The Rugby is a class which extends Zombies and uses the methods from zombies.  
 * This type of zombie that is aggresive.
 * Setting an abstract class for both Plants and Zombies allows for high cohesion.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class RugbyZombie extends Zombies{
	

	/**
	 *  Initialize the starting state of the zombie
	 * 
	 * @param None
	 * @return None
	 */
	public RugbyZombie() {

		super.setName("RugbyZombie");
		super.setStringtype("RZ");

		super.setSpeed(1);
		super.setHealth(150);
		super.setAttackDamage(80);
		super.setWeapon(null);
	}
}
