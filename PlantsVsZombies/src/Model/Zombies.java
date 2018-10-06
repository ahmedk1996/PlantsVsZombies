package Model;

public abstract class Zombies{
	
	private enum Type{walkingZombie};
	
	private int turn;
	private int resistant;	// range of the speed is 1~3, 1 is the fastest,means every turn it moves, and 3 is the slowest, every 3 turns it move one tile.
	private int speed;
	private int health;
	private int attackDamage;
	private Weapon weapon;
	
	
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
	public void move() {};
	public void attack() {};
	public void damaged() {};
}
