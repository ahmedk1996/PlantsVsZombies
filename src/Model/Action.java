/*
 * Reflection: I think this class was very well done, this class is responsible
 * for actions being performed on the board. All methods in this class help move pieces
 * on the board.
 * 
 *  I would not change this class or the functionality or responsibility that this class has.
 * 
 */
package Model;

import java.io.Serializable;

import Plants.Chomper;
import Plants.PotatoMine;
import Plants.PlantStore;
import Plants.Plants;
import Plants.ShootingPlant;
import Plants.Sunflower;
import Zombies.RugbyZombie;
import Zombies.SprintZombie;
import Zombies.WalkingZombie;
import Zombies.Zombies;

/**
 * The Action is a class which contains all the actions used throughout the game
 * this includes starting and ending the game.
 * 
 * @author Group 1
 * @since November 4,2018
 * 
 */
public class Action implements Serializable {

	// private Layout layout;
	// private Zombies zombie;
	// private int health;
	// private Status status;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Action() {

	}

	/**
	 * startAction which handles results of the plants, zombies and game.
	 *
	 * @param layout   layout of the game
	 * @param gameTurn the current turn
	 * @return result of the game
	 */
	public Layout startAction(Layout layout) {
		// this.currentTurn = gameTurn;
		Layout lay = plantShoot(layout);
		lay = behaveZombie(layout);
		lay = updateStatus(layout);
		return lay;
	}

	/**
	 * updateStatus which handles result of the game if it has been won or not
	 *
	 * @param layout layout of the game
	 * @return Layout result of the game
	 */
	public Layout updateStatus(Layout layout) {
		if (layout.getStatus() == Status.start ||layout.getStatus() == Status.created) {
			return layout;
		} else {
			for (int i = 0; i < layout.getGameGrid().length; i++) {
				if (layout.getGameGrid()[i][0] instanceof Zombies) {
					layout.setStatus(Status.loose);
					return layout;
				}
			}
			for (int i = 0; i < layout.getGameGrid().length; i++) {
				for (int j = 0; j < layout.getGameGrid()[0].length; j++) {
					if (layout.getGameGrid()[i][j] instanceof Zombies) {
						layout.setStatus(Status.inProgress);
						// this.status= Status.inProgress;
						// break;
						return layout;
					}
				}
			}
		}
		// this.status = Status.win;
		layout.setStatus(Status.win);
		return layout;
	}

	/**
	 * plantShoot which handles the shooting plants abilities.
	 *
	 * @param Layout - current layout of the board
	 * @return None
	 */
	public Layout plantShoot(Layout layout) {
		Zombies zombie;
		int health;

		for (int i = 0; i < layout.getGameGrid().length; i++) {
			for (int j = 0; j < layout.getGameGrid()[0].length; j++) {
				if (layout.getGameGrid()[i][j] instanceof Sunflower) {
					Plants temp = (Plants) layout.getGameGrid()[i][j];

				}
				if (layout.getGameGrid()[i][j] instanceof ShootingPlant) { // search if plant is a shooter
					for (int index = 0; index < layout.getGameGrid()[i].length; index++) { // iterate through that plant
																							// shooter's
						// row to find a zombie
						if (layout.getGameGrid()[i][index] instanceof Zombies) { // zombies in the same row

							Plants attackingPlant = new ShootingPlant(); // making instance to figure out the
							attackingPlant = (ShootingPlant) (layout.getGameGrid()[i][j]);

							zombie = (Zombies) (layout.getGameGrid()[i][index]); // get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health - attackingPlant.getDamage()); // reduce health

							if (zombie.getHealth() <= 0) {

								layout.getGameGrid()[i][index] = null; // zombie dead

							} else {
								zombie.getHealth();
							}

							System.out.println(
									"Zombie at " + i + " " + index + " " + "has " + zombie.getHealth() + " health");
							break;
						}
					}

				} else if (layout.getGameGrid()[i][j] instanceof PotatoMine) { // search if plant is a PotatoeMine
																				// Object
					for (int index = 0; index < layout.getGameGrid()[i].length; index++) { // iterate through that plant
																							// row to find a zombie
						if (layout.getGameGrid()[i][index] instanceof Zombies) { // zombies in the same row

							zombie = (Zombies) (layout.getGameGrid()[i][index]); // get instance of zombie
							Plants attackingPlant = new PotatoMine(); // making instance to figure out the
							attackingPlant = (PotatoMine) (layout.getGameGrid()[i][j]);
							zombie = (Zombies) (layout.getGameGrid()[i][index]); // get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health - attackingPlant.getDamage()); // reduce health

							if (zombie.getHealth() <= 0) {

								layout.getGameGrid()[i][index] = null; // zombie dead

							} else {
								zombie.getHealth();
							}
							System.out.println(
									"Zombie at " + i + " " + index + " " + "has " + zombie.getHealth() + " health");
							layout.getGameGrid()[i][j] =null;
							break;
						}
					
					}

				}

				else if (layout.getGameGrid()[i][j] instanceof Chomper) { // search if plant
					// * is a Chomper Object

						int index = j+1;
						if (layout.getGameGrid()[i][index] instanceof Zombies) { // zombies in the same row

							Plants attackingPlant = new Chomper(); // making instance to figure out the
							attackingPlant = (Chomper) (layout.getGameGrid()[i][j]);
							zombie = (Zombies) (layout.getGameGrid()[i][index]); // get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health - attackingPlant.getDamage()); // reduce health

							if (zombie.getHealth() <= 0) {

								layout.getGameGrid()[i][index] = null; // zombie dead

							} else {
								zombie.getHealth();
							}

							System.out.println(
									"Zombie at " + i + " " + index + " " + "has " + zombie.getHealth() + " health");
							break;
						}
						
					}
				}

			}
		
		return layout;
	}

	/**
	 * behaveZombie - Zombie will move or attack if it is able. Check List - check
	 * front tile is empty (doesn't matter zombie reaches [i][0] because
	 * isgameovesr() would check everytime) -check Zombie is movable -yes move -
	 * check front tile is plant -check Zombie is movable -yes attack - invoke
	 * ZombieAttack(), replace Plant object to returned plant *
	 * 
	 * @param layout - current layout of the game
	 * @return Layout - end result of the layout (usally the next state)
	 */
	public Layout behaveZombie(Layout layout) {

		for (int i = 0; i < layout.getGameGrid().length; i++) {
			for (int j = 1; j < layout.getGameGrid()[0].length; j++) { // J starts at 1 because if it is 0, it will get
																		// error.
				if (layout.getGameGrid()[i][j] instanceof Zombies) { // checking that is Zombie class
					Zombies temp = (Zombies) layout.getGameGrid()[i][j]; // Copying the zombie object

					if (layout.getGameGrid()[i][j - 1] == null) {
						layout.setObject(i, j, null); // empty the previous spot
						layout.placeObjectOnGrid(i, j - 1, temp); // place zombie
					} else if (layout.getGameGrid()[i][j - 1] instanceof Zombies) { // later we can pile up 2 zombies
						System.out.println("There is a Zombie in front of");
					} else if (layout.getGameGrid()[i][j - 1] instanceof Plants) { // Attacking the Plant! Using
																					// zombieAttack();
						Plants at = (Plants) zombieAttack((Zombies) layout.getGameGrid()[i][j],
								(Plants) layout.getGameGrid()[i][j - 1]);
						if (at.getHealth() <= 0) {
							layout.setObject(i, j - 1, null);
						}
					} else {
						System.out.println("error here");
					}
				}
			}
		}
		return layout;
	}

	/**
	 * Zombie Attacks(zombie, Plant) - Zombie attacks plant, this function is used
	 * in behaveZombie(); - zombie Attack p - check Plant health <= 0 - yes; return
	 * null; - no ; return attackedplant;
	 *
	 * @param z zombie that is doing damage
	 * @param p plant that is being attacked
	 * @return returns the plant object
	 * 
	 */
	public Plants zombieAttack(Zombies z, Plants p) {
		Plants attackedPlant = p;
		attackedPlant.attacked(z.attack());
		System.out.println(p.getName() + " gets attacked by " + z.getName() + "!!");
		System.out.println("Plant has " + attackedPlant.getHealth() + " health");
		if (attackedPlant.getHealth() <= 0) {
			System.out.println(attackedPlant.getName() + " is killed by " + z.getName() + "!!");
			// attackedPlant = null;
		}
		return attackedPlant;
	}

	/**
	 * isGameOver Returns true or false depending on whether the game is over or not
	 *
	 * @param layout - current layout of the game
	 * @return Boolean - true if won, false if no
	 */
	public Boolean isGameOver(Layout layout) {
		for (int i = 0; i < layout.getGameGrid().length; i++) {
			if (layout.getObject(i, 0) instanceof Zombies) {
				return true;
			}
		}
		return false;
	}

	public Boolean gameClear(Layout layout) {
		Boolean flag = true;
		for (int i = 0; i < layout.getGameGrid().length; i++) {
			for (int j = 0; j < layout.getGameGrid()[0].length; j++) {
				if (layout.getObject(i, j) instanceof Zombies) {
					flag = false;
				}
			}
		}
		return flag;
	}

}