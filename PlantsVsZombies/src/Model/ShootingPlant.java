package Model;

public class ShootingPlant  extends Plants{
	

	private final int cost = 100;
	private final int sunPoints = 50;
	private int health = 100;
	private static int turn;
	
	public ShootingPlant() {
		super.setStringtype("F    ");
	}
	public ShootingPlant(int health){
		this.health = health;
		super.setStringtype("F    ");
	}
	public int getCost() {
		return cost;
	}
	public static void turnOver() {
		turn++;
	}
	
	public static int getTurn() {
		return turn;
	}
	public static void setTurn(int turn) {
		ShootingPlant.turn = turn;
	}
	public static void shooterPlantShoot() {
		//shoot in the same row
		
	}

}
