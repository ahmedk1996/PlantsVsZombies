package Model;

public class Sunflower extends Plants {

	private final int cost  = 50;
	private static int sunPoints;
	private int turns;

	public Sunflower(){
		super.setStringtype("S    ");
		super.setHealth(100);
	}
	public Sunflower(int cost , int sunPoints, int health ){
		super(cost, sunPoints, health);
		turns = 0;
		super.setStringtype("S    ");
		super.setHealth(100);
	}

	public int getCost() {
		return cost;
	}
	
	public static void generateSunPoint(){
		sunPoints= sunPoints+50;
	}


}
