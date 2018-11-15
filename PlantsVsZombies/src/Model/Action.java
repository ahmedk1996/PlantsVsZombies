/**
 * The ShootingPlant is a class which contains all the actions used throughout the 
 * game this includes starting and ending the game.
 * 
 * @author Group 1
 * @since November 4,2018

 */

package Model;

import javax.swing.JButton;

import Plant.PlantStore;
import Plant.Plants;
import Plant.ShootingPlant;
import Plant.Sunflower;
import Zombie.WalkingZombie;
import Zombie.Zombies;

public class Action {

	private Turn turn;
	private Zombies zombie;
	private int health;
	private int currentTurn;

	public Action() {

	}

	/**
	 * plantShoot which handles the shooting plants abilities.
	 * 
	 * @param buttonArray
	 * @param ps
	 *
	 * @param None
	 * @return None
	 */
	public void plantShoot(Object[][] gameGrid, Layout layout, JButton[][] buttonArray, PlantStore ps) {

		turn = new Turn();
		currentTurn++;
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[0].length; j++) {

				if (gameGrid[i][j] instanceof Sunflower) {
					Plants temp = (Plants) layout.getGameGrid()[i][j];

					turn.canSunFlowerGenerate(currentTurn, temp, ps);
				}
				if (gameGrid[i][j] instanceof ShootingPlant) { // search if plant is a shooter
					for (int index = 0; index < gameGrid[i].length; index++) { // iterate through that plant shooter's
																				// row to find a zombie
						if (gameGrid[i][index] instanceof Zombies) { // zombies in the same row
							ShootingPlant attackingPlant = new ShootingPlant(); // making instance to figure out the

							zombie = (Zombies) (gameGrid[i][index]); // get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health - attackingPlant.getDamage()); // reduce health
							int healthUpdate = health - attackingPlant.getDamage();
							System.out
									.println("Zombie at " + i + " " + index + " " + "has " + healthUpdate + " health");
							if (zombie.getHealth() <= 0) {

								buttonArray[i][index].setText("");
								gameGrid[i][index] = null; // zombie dead
								System.out.println(zombie.getStringtype() + "is dead.");
							}
							break;
						}

					}

				}
			}
		}
	}

	/**
	 * behaveZombie - Zombie will move or attack if it is able. Check List - check
	 * front tile is empty (doesn't matter zombie reaches [i][0] because
	 * isgameovesr() would check everytime) -check Zombie is movable -yes move -
	 * check front tile is plant -check Zombie is movable -yes attack - invoke
	 * ZombieAttack(), replace Plant object to returned plant
	 * 
	 * @param gameGrid *
	 * @param None
	 * @return None
	 * 
	 */
	public int behaveZombie(Object[][] gameGrid, Layout layout) {
		turn = new Turn();
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[0].length; j++) { // J starts at 1 because if it is 0, it will get error.
				if (gameGrid[i][j] instanceof Zombies) { // checking that is Zombie class
					Zombies temp = (Zombies) gameGrid[i][j]; // Copying the zombie object

					if (i >= 0 && j == 0) {
						return 0;
					}
					if (gameGrid[i][j - 1] instanceof Plants) { // Attacking the Plant! Using zombieAttack();

						zombieAttack((Zombies) gameGrid[i][j], (Plants) gameGrid[i][j - 1], gameGrid, i, j - 1);

					}

					else {
						layout.setObject(i, j, null); // empty the previous spot
						layout.moveZombieUpOne(i, j - 1, temp, gameGrid); // place zombie
					}

				}
			}
		}

		return 1;
	}

	/**
	 * Zombie Attacks(zombie, Plant) - Zombie attacks plant, this function is used
	 * in behaveZombie(); - zombie Attack p - check Plant health <= 0 - yes; return
	 * null; - no ; return attackedplant;
	 *
	 * @param z an absolute URL giving the base location of the image
	 * @param p the location of the image, relative to the url argument
	 * @return the image at the specified URL
	 * @see Image
	 */
	public Plants zombieAttack(Zombies z, Plants p, Object[][] gameGrid, int row, int col) {
		Plants attackedPlant = p;
		Zombies o = new WalkingZombie();
		attackedPlant.attacked(o.attack());
		System.out.println("Plant has " + attackedPlant.getHealth() + " health");
		if (attackedPlant.getHealth() == 0) {
			System.out.println(attackedPlant.getStringtype() + " is killed by " + o.getStringtype());

		}

		return attackedPlant;
	}

	/**
	 * IncrementTurn
	 * 
	 * @param None
	 * @return None
	 */
	public void incrementTurn() {
		this.currentTurn++;
	}

	/**
	 * isGameOver Returns true or false depending on whether the game is over or not
	 *
	 * @param layout which passes in the gameGrid instance
	 * @return Boolean
	 */
	public Boolean isGameOver(Layout layout) {
		for (int i = 0; i < layout.getGameGrid().length; i++) {
			if (layout.getObject(i, 0) instanceof Zombies) {
				return true;
			}
		}
		return false;
	}

	/**
	 * gameclear Returns false if there is a zombie on the gameGrid
	 *
	 * @param layout which passes in the gameGrid instance
	 * @return Boolean
	 */
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
