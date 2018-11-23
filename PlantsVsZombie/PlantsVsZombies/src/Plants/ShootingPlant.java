

package Plants;
/**
 *  The ShootingPlant is a class which extends Plants and uses the methods from plants. 
 * ShootingPlant is a type of plant which shoots zombies which are in its row and cause them to lose health.
 * 
 * @author Group 1
 * @since November 4,2018

 */

public class ShootingPlant  extends Plants{
	

	private final int cost = 100;
	private final int sunPoints = 50;
	private int health = 100;
	private static int turn;
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param None
	 * @return None
	 */
	public ShootingPlant() {
		super.setStringtype("SP");
		super.setDamage(25);
		super.setHealth(100);
		super.setCost(cost);
		super.setName("ShootingPlant");
	}
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param int - health of the plant
	 * @return None
	 */
	public ShootingPlant(int health){
		this.health = health;
		super.setDamage(25);
		super.setStringtype("F    ");
		super.setName("ShootingPlant");
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
	
	/**
	 *  Gets the current turn 
	 * 
	 * @param None
	 * @return int - int changes based on if its users turn of AI's turn
	 */
	public static int getTurn() {
		return turn;
	}
	
	/**
	 *  Sets the current turn 
	 * 
	 * @param int - int changes based on if its users turn of AI's turn
	 * @return None
	 */
	public static void setTurn(int turn) {
		ShootingPlant.turn = turn;
	}

}
