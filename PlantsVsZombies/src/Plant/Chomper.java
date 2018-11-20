package Plant;

public class Chomper extends Plants{

	
	private final int cost = 100;
	private int health = 300;
	private static int turn;
	
	public Chomper() {
		super.setStringtype("C    ");
		super.setDamage(35);
		super.setHealth(health);
		super.setCost(cost);
		super.setName("Chomper");
	}
	public Chomper(int health){
		this.health = health;
		super.setDamage(35);
		super.setStringtype("C    ");
		super.setName("Chomper");
	}
	public int getCost() {
		return cost;
	}
	
	public static int getTurn() {
		return turn;
	}
	public static void setTurn(int turn) {
		Chomper.turn = turn;
	}
	
}
