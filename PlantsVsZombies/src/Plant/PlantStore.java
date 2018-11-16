package Plant;



/**
 *  The PlantStore is a class which contains all the methods common between all the plant
 *  purchases and handling the costs on the plants and stores the sun points.
 * 
 * 
 * @author Group 1
 * @since November 4,2018

 */
public class PlantStore {

	private Plants price;
	private  int sunPoints;
	
	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;


	
	public  int getSunPoints() {
		return sunPoints;
	}

	public  void setSunPoints(int sunPoints) {
		this.sunPoints = sunPoints;
	}

	public int getPeaShooterCost() {
		return peaShooterCost;
	}

	public int getSunFlowerCost() {
		return sunFlowerCost;
	}

	public void incrementSunPoints() {

		sunPoints = sunPoints+50;
	}

	public PlantStore() {

		sunPoints = getSunPoints();
	}

	public Plants getPrice() {
		return price;
	}

	public void setPrice(Plants price) {
		this.price = price;
	}

	/**
	 * 	validatePurchase, makes sure you can purchase the plant with sufficent SunPoints
	 * 	@plant- which plant you are buying
	 * 	@currentBalnce - the number of currentBalance currently have
	 * 	@return none
	 */
	public int validatePurchase(Plants plant , int currentBalance) {

		if((currentBalance - plant.getCost()) >= 0){

			return currentBalance;
		}else {
			currentBalance = -1;
			
			
		}
		return currentBalance;
	}
	
	/**
	 * purchase method, updates the balance of the amount of sunpoints, depending
	 * on which plant has been purchased
	 * 	@param plant - the type of plant that has been bought
	 * 	@param currentBalance - number of sun points the user currently has
	 * 	@return none
	 */
	public void purchase(Plants plant , int currentBalance) {
		int updatedBalance = getSunPoints() - plant.getCost();
		setSunPoints(updatedBalance);
		System.out.println("Sun Points: " + updatedBalance);
		
	}



}


