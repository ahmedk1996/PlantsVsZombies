package Model;

public class ShootingPlant  extends Plants{
	

	private final int cost = 100;
	private final int sunPoints = 50;
	private int turns;
	public ShootingPlant() {
		
	}
	public ShootingPlant(int cost, int health ){
		super(cost ,health);
		super.setStringtype("F    ");
		turns =0;
	}
	public int getCost() {
		return cost;
	}

}
