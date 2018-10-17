package Model;

public class Action {

	private Turn turn;
	private Layout layout;
	private Zombies zombie;
	private PrintGrid printgrid;
	private Plants plant;
	private int count;
	private int health;
	public Action() {
	/*	count= Turn.getCount();
		count++;*/
	}
	
	public void plantShoot(Layout layout) {
	
		for(int i=0 ; i <Layout.getGameGrid().length; i++) {
			for(int j=0; j < Layout.getGameGrid()[0].length ; j++) {
				if(Layout.getGameGrid()[i][j] instanceof ShootingPlant) { //search if plant is a shooter
					for (int index =0 ; index<Layout.getGameGrid()[i].length; index++) { // iterate through that plant shooter's row to find a zombie
						if (Layout.getGameGrid()[i][index] instanceof Zombies) { // zombies in the same row
							zombie = (Zombies) (Layout.getGameGrid()[i][index]); //get instance of zombie
							health = zombie.getHealth();
							zombie.setHealth(health -25); // reduce health
							if (zombie.getHealth()<=0) {
								Layout.getGameGrid()[i][index] =null; // zombie dead
								PrintGrid.stringGrid[i][index] = ".    ";
							}
						}
					}
					
						 
				}
			
		}
	}
		return;
	}

	public void moveZombieUpOne() {
		for(int i=0 ; i <Layout.getGameGrid().length; i++) {
			for(int j=0; j < Layout.getGameGrid()[0].length ; j++) {
				if(Layout.getGameGrid()[i][j] instanceof WalkingZombie) {
					Layout.getGameGrid()[i][j] = null;
					Zombies temp = (Zombies)Layout.getGameGrid()[i][j-1];
					if(Layout.getGameGrid()[i][0] instanceof WalkingZombie) {
						gameOver(); // zombie is at the end
					}
					PrintGrid.stringGrid[i][j] =  ".    ";
					PrintGrid.stringGrid[i][j-1] = temp.getStringtype();
				}
				else if (Layout.getGameGrid()[i][j] instanceof Plants) {
					Layout.getGameGrid()[i][j] = null;
					Plants temp =  (Plants) Layout.getGameGrid()[i][j-1];
					PrintGrid.stringGrid[i][j] =  ".    ";
					PrintGrid.stringGrid[i][j-1] = temp.getStringtype();
					
				}
		
				}
			}
		return;
	}
	
	public void zombieAttack() {
		for(int i=0 ; i <Layout.getGameGrid().length; i++) {
			for(int j=0; j < Layout.getGameGrid()[0].length ; j++) {
				if(Layout.getGameGrid()[i][j] instanceof Zombies) {	
					if (Layout.getGameGrid()[i][j-1] instanceof ShootingPlant) {
						plant = (ShootingPlant)(Layout.getGameGrid()[i][j]);
						health = plant.getHealth();
						zombie.setHealth(health - 50);
						 if (plant.getHealth()<=0) {
								Layout.getGameGrid()[i][j-1] =null; // plant dead
								PrintGrid.stringGrid[i][j-1] = ".    ";
							}
					}
					else if (Layout.getGameGrid()[i][j+1] instanceof ShootingPlant) {
						plant = (Sunflower)(Layout.getGameGrid()[i][j-1]);
						health = plant.getHealth();
						zombie.setHealth(health - 75);
						 if (plant.getHealth()<=0) {
								Layout.getGameGrid()[i][j-1] =null; // plant dead
								PrintGrid.stringGrid[i][j-1] = ".    ";
							}
					}
					
				}
			}
		}
		return;
	}
	
	public void gameOver() {
		
	}


}
