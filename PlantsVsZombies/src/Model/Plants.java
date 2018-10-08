package Model;

public abstract class Plants {
	
	private int health;
	private int cost;
	private int xCord;
	private int yCord;
	private int turns =0 ;

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}
	public Plants(){
		
	}

	public Plants(int health , int cost ){
		this.health = health;
		this.cost = cost;
		this.turns = 0;
		
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
	
	public boolean ismovable() {
		if (turns == 0) {
			return false;
		}
		if ((turns%speed) == 0)
			return true;
		else 
			return false;
	};

	
	
}
