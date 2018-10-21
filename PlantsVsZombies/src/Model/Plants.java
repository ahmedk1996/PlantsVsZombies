package Model;

public abstract class Plants {
	
	private String stringtype;
	private int health;
	private int cost;
	private int sunPoints;
	//private enum plants {SHOOTER , SUNFLOWER};
	private int damage;
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getStringtype() {
		return stringtype;
	}

	public void setStringtype(String stringtype) {
		this.stringtype = stringtype;
	}

	public Plants(int cost , int sunPoints , int heath){
		this.cost = cost;
		this.sunPoints = sunPoints;
		health = 100;
	
	}
	public Plants(int health){
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
	public void attacked(int damage) {
		this.health = this.health - damage;
		
	}
	public boolean ismovable(int turns , int speed) {
		if (turns == 0) {
			return false;
		}
		if ((turns%speed) == 0)
			return true;
		else 
			return false;
	}


	

	
	
}
