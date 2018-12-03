
package Model;

/**
 *  The Weapon  is the weapon for the attacking zombies. It contains the underlying 
 * model of the weapons health,speed etc. 
 * 
 * Reflection: This class is responsible for zombie attacking other objects on the
 * board. This class is really well put together as it only has one responsibility.
 * 
 * This class defines methods that will help the zombie attack and set different attributes 
 * for the attacks of zombies. Some methods provide different speeds for attacking zombies,
 * how much damage it does, etc.
 * 
 * @author Group 1
 * @since November 4,2018

 */
public abstract class Weapon {
	private String name;
	private int weaponSpeed;
	private int weaponresistant;
	private int weaponhealth;
	private int weaponattackDamage;
	
	/**
	 *  getter method of name
	 * 
	 * @param None
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 *  setter method of name
	 * 
	 * @param String
	 * @return None
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  getter method of weaponspeed
	 * 
	 * @param None
	 * @return int
	 */
	public int getWeaponSpeed() {
		return weaponSpeed;
	}

	/**
	 *  setter method of speed
	 * 
	 * @param int
	 * @return None
	 */
	public void setWeaponSpeed(int weaponSpeed) {
		this.weaponSpeed = weaponSpeed;
	}

	/**
	 *  getter method of resistance
	 * 
	 * @param None
	 * @return int
	 */
	public int getWeaponresistant() {
		return weaponresistant;
	}

	/**
	 *  setter method for resistance
	 * 
	 * @param int
	 * @return None
	 */
	public void setWeaponresistant(int weaponresistant) {
		this.weaponresistant = weaponresistant;
	}

	/**
	 *  getter method of health
	 * 
	 * @param None
	 * @return int
	 */
	public int getWeaponhealth() {
		return weaponhealth;
	}

	/**
	 *  setter method of weapon health
	 * 
	 * @param int
	 * @return None
	 */
	public void setWeaponhealth(int weaponhealth) {
		this.weaponhealth = weaponhealth;
	}

	/**
	 *  getter method of attack damage
	 * 
	 * @param None
	 * @return int
	 */
	public int getWeaponattackDamage() {
		return weaponattackDamage;
	}

	/**
	 *  setter method of atack damage
	 * 
	 * @param int
	 * @return None
	 */
	public void setWeaponattackDamage(int weaponattackDamage) {
		this.weaponattackDamage = weaponattackDamage;
	}

	
}
