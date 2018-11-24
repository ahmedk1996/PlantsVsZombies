package Plants;


/**
 *  The Chomper is a class which extends Plants and uses the methods from plants. 
 * Chomper is a type of plant which kills itself and the zombie next to it
 * 
 * @author Group 1
 * @since November 22,2018

 */
public class Chomper extends Plants{

	
	private final int cost = 200;
	private int health = 300;
	private static int turn;
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param None
	 * @return None
	 */
	public Chomper() {
		super.setStringtype("CP");
		super.setDamage(100);
		super.setHealth(300);
		super.setCost(cost);
		super.setName("Chomper");
	}
	
	/**
	 *  Sets the objects properties with the correct identifiers
	 * 
	 * @param int - health of the plant
	 * @return None
	 */
	public Chomper(int health){
		super.setHealth(300);
		super.setDamage(35);
		super.setStringtype("C    ");
		super.setName("Chomper");
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
		Chomper.turn = turn;
	}
	
}
