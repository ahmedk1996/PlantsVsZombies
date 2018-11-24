package Plants;

/**
 *  The PotatoeMine is a class which extends Plants and uses the methods from plants. 
 * PotatoeMine is a type of plant which kills itself and the zombie next to it
 * 
 * @author Group 1
 * @since November 22,2018

 */
public class PotatoMine extends Plants{
	
	private final int cost = 150;
	private int health = 100;
	private static int turn;
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param None
	 * @return None
	 */
	public PotatoMine() {
		super.setStringtype("PM");
		super.setDamage(100);
		super.setHealth(health);
		super.setCost(cost);
		super.setName("PotatoMine");
	}
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param int - health of the plant
	 * @return None
	 */
	public PotatoMine(int health){
		this.health = health;
		super.setDamage(100);
		super.setStringtype("PM    ");
		super.setName("PotatoMine");
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
		PotatoMine.turn = turn;
	}
}
