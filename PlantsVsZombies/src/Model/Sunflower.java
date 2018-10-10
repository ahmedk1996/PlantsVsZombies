package Model;

public class Sunflower extends Plants {

	
	
	private final int health = 10;
	private final int cost  = 50;
	private int sunPoints;
	
	public Sunflower(){
		
		
	}
	public Sunflower(int cost){
		super(cost);
	}

	
	private void generateSunPoint(){
		sunPoints = + 10;
	}
	public int getCost() {
		return cost;
	}



}
