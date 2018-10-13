package Model;


public class WalkingZombie extends Zombies{
/*Initial Status for WalkingZombie
 *  speed = 1 tile for 2 turns,
 *  health = 20
 *  attackDamage = 10
 *  Weapon = null;
 * 
 */
	
	public WalkingZombie() {
		super.setStringtype("WK   ");
		super.setSpeed(2);
		super.setHealth(20);
		super.setAttackDamage(10);
		super.setWeapon(null);
	}
}
