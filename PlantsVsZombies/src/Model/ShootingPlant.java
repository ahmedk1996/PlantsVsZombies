package Model;

public class ShootingPlant  extends Plants{
	

	private final int cost = 5;
	public ShootingPlant() {
		
	}
	public ShootingPlant(int cost){
		super(cost);
	}
	public int getCost() {
		return cost;
	}

}
