package Model;

public class Action {

	private Turn turn;
	private Layout layout;
	private Zombies zombie;
	private Plants plant;
	//private int count;
	private int health;
	private int currentTurn;

	public Action() {
	}

	public Object[][] startAction(Layout layout,int gameTurn) {
		this.layout = layout;
		this.currentTurn = gameTurn;
	//	layout.print();
		behaveZombie();
		plantShoot();
		
		layout.print();
		if(isGameOver()) {
			System.out.println("!!!!!GAME OVER!!!!!");
			return null;
		}else
			return layout.getGameGrid();
	}	

	public void plantShoot() {
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			for(int j=0; j < layout.getGameGrid()[0].length ; j++) {
				if(layout.getGameGrid()[i][j] instanceof ShootingPlant) { //search if plant is a shooter
					for (int index =0 ; index<layout.getGameGrid()[i].length; index++) { // iterate through that plant shooter's row to find a zombie
						if (layout.getGameGrid()[i][index] instanceof Zombies) { // zombies in the same row
							ShootingPlant attackingPlant = new ShootingPlant(); // making instance to figure out the attack damage of the plant
							zombie = (Zombies) (layout.getGameGrid()[i][index]); //get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health - attackingPlant.getDamage()); // reduce health 
							int healthUpdate = health - attackingPlant.getDamage();
							System.out.println("Zombie at "+ i + " " + j + " " + "has " + healthUpdate + " health");
							if (zombie.getHealth() <= 0) {
								layout.getGameGrid()[i][index] =null; // zombie dead
								System.out.println(zombie.getStringtype() + "is dead." );
							}
						}
					}						 
				}
			}
		}
	}


	public void behaveZombie() {
		Turn turn = new Turn();
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			for(int j=1; j < layout.getGameGrid()[0].length ; j++) { // J starts at 1 because if it is 0, it will get error. 
				if(layout.getGameGrid()[i][j] instanceof Zombies){ // checking that is Zombie class
					Zombies temp = (Zombies)layout.getGameGrid()[i][j]; // Copying the zombie object
					if(turn.canZombieMove(temp,currentTurn)){ // checking the Zombie Object is movable.
						if(layout.getGameGrid()[i][j-1] == null) {
							layout.setObject(i, j, null); // empty the previous spot
							layout.placeObjectOnGrid(i, j-1, temp);	//place zombie
						}else if (layout.getGameGrid()[i][j-1] instanceof Zombies) { // later we can pile up 2 zombies
							System.out.print("There is a Zombie in front of");
						}
						else if (layout.getGameGrid()[i][j-1] instanceof Plants) { // Attacking the Plant! Using zombieAttack();
							layout.setObject(i, j-1, zombieAttack((Zombies)layout.getGameGrid()[i][j],(Plants)layout.getGameGrid()[i][j-1]));
							
						}else {
							System.out.println("error here");
						}
					}
				}
			}
		}

		/**behaveZombie - Zombie will move or attack if it is able. 
		 * Check List
		 *- check front tile is empty (doesn't matter zombie reaches [i][0] because isgameovesr() would check everytime)
		 *		-check Zombie is movable
		 *			-yes move 
		 *- check front tile is plant
		 *		-check Zombie is movable
		 *			-yes attack 
		 *				- invoke ZombieAttack(), replace Plant object to returned plant 
		 */
	}

	public Plants zombieAttack(Zombies z, Plants p) {
		Plants attackedPlant = p;
			Zombies o = new WalkingZombie();
			attackedPlant.attacked(o.attack()); 
			System.out.println("Plant has " + attackedPlant.getHealth() + " health");
			if(attackedPlant.getHealth() <= 0) {
				System.out.println(attackedPlant.getStringtype()+" is killed by " + o.getStringtype());
				return null;
			}
		
		
		return attackedPlant;

		/** Zombie Attacks(zombie, Plant) - Zombie attacks plant, this function is used in behaveZombie();
		 * - zombie Attack p
		 * - check Plant health <= 0 
		 * 		- yes; return null; 
		 * 		- no ; return attackedplant;
		 */
	}

	public void increamentTurn() {
		this.currentTurn++;
	}

	public Boolean isGameOver() {
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			if(layout.getObject(i,0) instanceof Zombies) {
				return true;
			}
		}
		return false;
	}
	
/*	public static void main(String args[]) {
		Layout layout = new Layout();
		WalkingZombie z= new WalkingZombie();
		Plants p = new ShootingPlant();
		layout.placeObjectOnGrid(3, 6, z);
		layout.placeObjectOnGrid(3, 1, p);
		Action ac = new Action();
		layout = ac.startAction(layout, 0);
		
	}*/
}
