

package Zombies;
import java.io.Serializable;

import Model.Weapon;


/**
 * The Zombie is an abstract class which contains all the methods common between all the zombies
 * be it their health or the damage they give for example.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public abstract class Zombies implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String stringtype;
	private String Name;
	private int turn; // this is initial turn.
	private int resistant=0;	// range of the speed is 1~3, 1 is the fastest,means every turn it moves, and 3 is the slowest, every 3 turns it move one tile.
	private int speed;
	private int health;
	private int attackDamage;
	private boolean alive = true;
	private Weapon weapon = null;
	
	/**
	 *  gets the name of the zombie to identify the type
	 * 
	 * @param None
	 * @return String - name of the zombie
	 */
	public String getName() {
		return Name;
	}

	/**
	 *  sets the name of the zombie to identify the type
	 * 
	 * @param String - name of the zombie
	 * @return None
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 *  used to allow the zombies to atack plants
	 * 
	 * @param None
	 * @return int - how much damage the zombie does
	 */
	public int attack() {
		return this.attackDamage;
	}

	/**
	 *  used to allow the plants to attack zombies
	 * 
	 * @param int - damage taken
	 * @return None
	 */
	public void damaged(int attackDamage) {
		if (attackDamage >= this.health){
			this.health = 0;
			this.alive = false; 
		}else {
			this.health -= attackDamage;
		}
	}
	
	/**
	 *  Used to get the identifier string of the Zombie
	 * 
	 * @param None
	 * @return String - identifer string of the zombie
	 */
	public String getStringtype() {
		return stringtype;
	}

	/**
	 *  Used to set the identifier string of the Zombie
	 * 
	 * @param String - identifer string of the zombie
	 * @return None
	 */
	public void setStringtype(String type) {
		this.stringtype = type;
	}

	/**
	 *  Used to check if the zombie is still alive
	 * 
	 * @param None
	 * @return boolean - true if the zombie is alive, false otherwise
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 *  Used to get the current turn
	 * 
	 * @param None
	 * @return int - based on whos turn it is
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 *  Used to set the current turn
	 * 
	 * @param int - based on whos turn it is
	 * @return None 
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 *  Used to set the speed of the zombie
	 * 
	 * @param int - the speed of the zombie
	 * @return None
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 *  Used to set the health of the zombie
	 * 
	 * @param int - the health of the zombie
	 * @return None
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 *  Used to get the damage of the zombie
	 * 
	 * @param None
	 * @return int - the damage of the zombie
	 */
	public int getAttackDamage() {
		return attackDamage;
	}

	/**
	 *  Used to set the damage of the zombie
	 * 
	 * @param int - the damage of the zombie
	 * @return None
	 */
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	/**
	 *  Used to get the weapon
	 * 
	 * @param None
	 * @return weapon - the type of weapon used
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 *  Used to set the weapon of the zombie
	 * 
	 * @param weapon - the weapon wwe want the zombie to use
	 * @return None
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 *  Used to get the speed of the zombie
	 * 
	 * @param None
	 * @return int - the health of the zombie
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 *  Used to get the health of the zombie
	 * 
	 * @param None
	 * @return int - the health of the zombie
	 */
	public int getHealth() {
		return health;
	}

	/**
	 *  Used to get the reistance of the zombie
	 * 
	 * @param None
	 * @return int - the reistance of the zombie
	 */
	public int getResistant() {
		return resistant;
	}

	/**
	 *  Used to set the reistance of the zombie
	 * 
	 * @param int - the reistance of the zombie
	 * @return None
	 */
	public void setResistant(int resistant) {
		this.resistant = resistant;
	}



	
}

