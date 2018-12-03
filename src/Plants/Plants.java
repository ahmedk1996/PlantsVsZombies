
package Plants;

import java.io.Serializable;

/**
 * Reflection: The Plant is an abstract class which contains all the methods common between all the plants
 * be it their health or the damage they give for example. This is a design decision which we 
 * still support using as it allows for loose coupling.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public abstract class Plants implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stringtype;
	private int health;
	private int cost;
	private int sunPoints;
	private int speed;
	private int damage;
	private String name;
	private int cooldown = 2; //defalut Cooldown takes 1 turns
	
	
	/**
	 *  gets the plants damage
	 * 
	 * @param None
	 * @return int - the plants damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 *  gets the plants cooldown, if any
	 * 
	 * @param None
	 * @return int - the cooldown on the plants
	 */
	public int getCooldown() {
		return cooldown;
	}
	
	/**
	 *  sets the plants cooldown
	 * 
	 * @param int- changes based on how many cooldown the plants have
	 * @return None
	 */
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	/**
	 *  sets the plants damage
	 * 
	 * @param int - the plants damage on zombies
	 * @return None
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 *  gets the plants substring for identification
	 * 
	 * @param None
	 * @return String - the plants indentifier
	 */
	public String getStringtype() {
		return stringtype;
	}

	/**
	 *  sets the plants substring
	 * 
	 * @param String - the new string for the plant
	 * @return None
	 */
	public void setStringtype(String stringtype) {
		this.stringtype = stringtype;
	}

	/**
	 *  initalizes the plants cost, user sunpoints and its health
	 * 
	 * @param cost - cost of the plant
	 * @param sunpoints - sunpoints the user has in the bank
	 * @param health - the health of the plant
	 * @return None
	 */
	public Plants(int cost , int sunPoints , int heath){
		this.cost = cost;
		this.sunPoints = sunPoints;
		health = 100;
	
	}
	
	/**
	 *  initalizes the plants health
	 * 
	 * @param health - the health of the plant
	 * @return None
	 */
	public Plants(int health){
		this.health = health;
		
	}

	/**
	 * Default Constructor
	 * 
	 * @param None
	 * @return None
	 */
	public Plants() {
		
	}
	
	/**
	 *  gets the cost of the plant
	 * 
	 * @param None
	 * @return int - cost of plant
	 */
	public int getCost() {
		return cost;
	}

	/**
	 *  sets the plants cost
	 * 
	 * @param int - the cost of the plant
	 * @return None
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 *  gets the health of the plant
	 * 
	 * @param None
	 * @return int - health of plant
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 *  sets the helath of the plant
	 * 
	 * @param int - health of the plant
	 * @return None
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 *  checks how much health the plant now hass after taking damage
	 * 
	 * @param int - how much damge is being done
	 * @return None
	 */
	public void damageDealt(int hitpoints){
		int reducedHealth = this.health - hitpoints;
		setHealth (reducedHealth);
	}
	
	/**
	 * updates the health of the plant
	 * 
	 * @param int - damage being done to the plant
	 * @return None
	 */
	public void attacked(int damage) {
		this.health = this.health - damage;
		
	}
	
	
	public boolean ismovable(int turns , int speed) {
		if (turns == 0) {
			return false;
		}
		if ((turns%speed) == 0)
			return true;
		else 
			return false;
	}

	/**
	 *  gets the speed of the plant
	 * 
	 * @param None
	 * @return int - speed of plant
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 *  sets the speed of the plant
	 * 
	 * @param int - attack speed of the plant
	 * @return None
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 *  gets the name of the plant
	 * 
	 * @param None
	 * @return String  - name of plant
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *  sets the name of the plant
	 * 
	 * @param String - name of the plant
	 * @return None
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
}
