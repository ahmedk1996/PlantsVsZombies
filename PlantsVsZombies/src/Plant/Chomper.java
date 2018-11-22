package Plant;

public class Chomper extends Plants{

	
	private final int cost = 150;
	private int health = 150;
	private static int turn;
	
	public Chomper() {
		super.setStringtype("C    ");
		super.setDamage(75);
		super.setHealth(150);
		super.setCost(cost);
		super.setName("Chomper");
	}
	public Chomper(int health){
		super.setHealth(300);
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
