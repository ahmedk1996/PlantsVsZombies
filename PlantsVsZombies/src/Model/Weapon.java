

package Model;
/**
 *  The Weapon  is the weapon for the attacking zombies. It contains the underlying 
 * model of the weapons health,speed etc. 
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeaponSpeed() {
		return weaponSpeed;
	}

	public void setWeaponSpeed(int weaponSpeed) {
		this.weaponSpeed = weaponSpeed;
	}

	public int getWeaponresistant() {
		return weaponresistant;
	}

	public void setWeaponresistant(int weaponresistant) {
		this.weaponresistant = weaponresistant;
	}

	public int getWeaponhealth() {
		return weaponhealth;
	}

	public void setWeaponhealth(int weaponhealth) {
		this.weaponhealth = weaponhealth;
	}

	public int getWeaponattackDamage() {
		return weaponattackDamage;
	}

	public void setWeaponattackDamage(int weaponattackDamage) {
		this.weaponattackDamage = weaponattackDamage;
	}

	
}
