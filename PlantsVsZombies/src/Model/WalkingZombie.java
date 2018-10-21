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
		super.setSpeed(1);
		super.setHealth(150);
		super.setAttackDamage(50);
		super.setWeapon(null);
	}
}
