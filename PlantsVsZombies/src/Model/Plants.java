package Model;

public abstract class Plants {
	
	private int health;
	private int cost;
	private static int turns ;
	private int sunPoints;
	private enum plants {SHOOTER , SUNFLOWER};
	
	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}
	public Plants(int cost , int sunPoints , int heath){
		this.cost = cost;
		this.sunPoints = sunPoints;
		this.health = health;
	
	}
	public Plants(int cost , int health){
		this.cost = cost;
		this.health = health;
		
	}

	public Plants() {
		
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void damageDealt(int hitpoints){
		int reducedHealth = this.health - hitpoints;
		setHealth (reducedHealth);
	}
	
	public boolean ismovable(int turns , int speed) {
		if (turns == 0) {
			return false;
		}
		if ((turns%speed) == 0)
			return true;
		else 
			return false;
	};
	
	private void generateSunPoint(){
		
	}

	
	
}
