package Plant;

public class PotatoMine extends Plants{
	
	private final int cost = 100;
	private int health = 100;
	private static int turn;
	
	public PotatoMine() {
		super.setStringtype("M    ");
		super.setDamage(1000);
		super.setHealth(health);
		super.setCost(cost);
		super.setName("PotatoeMine");
	}
	public PotatoMine(int health){
		this.health = health;
		super.setDamage(25);
		super.setStringtype("M    ");
		super.setName("PotatoeMine");
	}
	public int getCost() {
		return cost;
	}
	
	public static int getTurn() {
		return turn;
	}
	public static void setTurn(int turn) {
		PotatoMine.turn = turn;
	}
}
