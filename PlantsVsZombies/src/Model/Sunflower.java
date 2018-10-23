package Model;

public class Sunflower extends Plants {

	private final int cost  = 50;
	private static int sunPoints;
	private int turns;

	public Sunflower(){
		super.setStringtype("S    ");
		super.setHealth(100);
		super.setSpeed(1);
	}

	public int getCost() {
		return cost;
	}
	
	public static void generateSunPoint(){
		sunPoints= sunPoints+50;
	}


}
