package Model;

public class Sunflower extends Plants {

	
	
	private final int health = 10;
	private final int cost  = 50;
	private int sunPoints;
	private int turns;
	
	public Sunflower(){
		
		
	}
	public Sunflower(int cost , int sunPoints, int health ){
		super(cost, sunPoints, health);
		turns = 0;
	}

	public int getCost() {
		return cost;
	}
	
	private void generateSunPoint(){
		sunPoints+=50;
	}


}
