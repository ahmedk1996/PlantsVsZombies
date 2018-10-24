package Model;

public class Action {

	private Turn turn;
	private Layout layout;
	private Zombies zombie;
	private Plants plant;
	private int health;
	private int currentTurn;
	private PlantStore store;

	public Action(PlantStore store) {
		this.store = store;
	}
	
	
	/**
	 * startAction which handles results of the plants, zombies and game.
	 *
	 * @param  layout  layout of the game
	 * @param  gameTurn the current turn
	 * @return      result of the game
	 */
	public Object[][] startAction(Layout layout,int gameTurn) {
		this.layout = layout;
		this.currentTurn = gameTurn;
		behaveZombie();
		plantShoot();
		
		layout.print();
		if(isGameOver()) {
			System.out.println("!!!!!GAME OVER!!!!!");
			return null;
		}else
			return layout.getGameGrid();
	}	

	/**
	 * plantShoot which handles the shooting plants abilities.
	 *
	 * @param None
	 * @return None
	 */
	public void plantShoot() {
		turn = new Turn();
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			for(int j=0; j < layout.getGameGrid()[0].length ; j++) {
				if (layout.getGameGrid()[i][j] instanceof Sunflower) {
					Plants temp = (Plants)layout.getGameGrid()[i][j];
					turn.canSunFlowerGenerate(currentTurn, temp , store);
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
	}


	/** behaveZombie - Zombie will move or attack if it is able. 
	* Check List
	*- check front tile is empty (doesn't matter zombie reaches [i][0] because isgameovesr() would check everytime)
	*		-check Zombie is movable
	*			-yes move 
	*- check front tile is plant
	*		-check Zombie is movable
	*			-yes attack 
 	*				- invoke ZombieAttack(), replace Plant object to returned plant 	 *
 	* @param  None
 	* @return None
 	* 
 	*/
	public void behaveZombie() {
		turn = new Turn();
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			for(int j=1; j < layout.getGameGrid()[0].length ; j++) { // J starts at 1 because if it is 0, it will get error. 
				if(layout.getGameGrid()[i][j] instanceof Zombies){ // checking that is Zombie class
					Zombies temp = (Zombies)layout.getGameGrid()[i][j]; // Copying the zombie object
					if(turn.canZombieMove(temp,currentTurn)){ // checking the Zombie Object is movable.
						if(layout.getGameGrid()[i][j-1] == null) {
							layout.setObject(i, j, null); // empty the previous spot
							layout.placeObjectOnGrid(i, j-1, temp);	//place zombie
						}else if (layout.getGameGrid()[i][j-1] instanceof Zombies) { // later we can pile up 2 zombies
							System.out.println("There is a Zombie in front of");
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


	
	}

	
	
	/** Zombie Attacks(zombie, Plant) - Zombie attacks plant, this function is used in behaveZombie();
		 * - zombie Attack p
		 * - check Plant health <= 0 
		 * 		- yes; return null; 
		 * 		- no ; return attackedplant;
	 *
	 * @param  z  an absolute URL giving the base location of the image
	 * @param  p the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */
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
	}

	
	
	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute {@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */
	public void increamentTurn() {
		this.currentTurn++;
	}

	
	
	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute {@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */
	public Boolean isGameOver() {
		for(int i=0 ; i <layout.getGameGrid().length; i++) {
			if(layout.getObject(i,1) instanceof Zombies) {
				return true;
			}
		}
		return false;
	}
	

}
