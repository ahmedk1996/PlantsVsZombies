package Model;

public abstract class Zombies{
	
	//private enum Type{walkingZombie};
	
	private String stringtype;
	private int turn = 0;
	private int resistant=0;	// range of the speed is 1~3, 1 is the fastest,means every turn it moves, and 3 is the slowest, every 3 turns it move one tile.
	private int speed;
	private int health;
	private int attackDamage;
	private boolean alive = true;
	private Weapon weapon = null;

	
	public boolean ismovable() {
		if (turn == 0) {
			return false;
		}
		if ((turn%speed) == 0)
			return true;
		else 
			return false;
	};
	
	public int attack() {
		return this.attackDamage;
	};

	public void damaged(int attackDamage) {
		if (attackDamage >= this.health){
			this.health = 0;
			this.alive = false; 
		}else {
			this.health -= attackDamage;
		}
	};
	public void turnOver() {
		this.turn++;
	}
	
	public String getStringtype() {
		return stringtype;
	}

	public void setStringtype(String type) {
		this.stringtype = type;
	}

	public boolean isAlive() {
		return alive;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getSpeed() {
		return speed;
	}

	public int getHealth() {
		return health;
	}

	public int getResistant() {
		return resistant;
	}

	public void setResistant(int resistant) {
		this.resistant = resistant;
	}


	
}
