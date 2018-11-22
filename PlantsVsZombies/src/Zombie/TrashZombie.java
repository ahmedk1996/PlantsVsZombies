
package Zombie;
/**
 * The SprintZombie is a class which extends Zombies and uses the methods from zombies.  
 * This type of zombie walks at a fast pace hence the name.
 * Setting an abstract class for both Plants and Zombies allows for high cohesion.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class TrashZombie extends Zombies{
	
/*Initial Status for SprintZombie
 *  speed = 5 tile for 2 turns,
 *  health = 100
 *  attackDamage = 50
 *  Weapon = null;
 * 
 */
	
	public TrashZombie() {

		super.setName("TrashZombie");
		super.setStringtype("TZ   ");

		super.setStringtype("TZ");

		super.setSpeed(1);
		super.setHealth(125);
		super.setAttackDamage(50);
		super.setWeapon(null);
	}
}
