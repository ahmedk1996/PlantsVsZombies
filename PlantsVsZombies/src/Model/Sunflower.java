package Model;

public class Sunflower extends Plants {

	
	
	private final int health = 10;
	private final int cost  = 50;
	private int sunPoints;
	public Sunflower(int health, int cost){
		super(health, cost);
		
	}
	public Sunflower(){
		
	}
	
	private void generateSunPoint(){
		
		sunPoints = + 10;
		
	}



}
