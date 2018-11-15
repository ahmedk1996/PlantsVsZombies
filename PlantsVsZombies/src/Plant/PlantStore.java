package Plant;




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

	public PlantStore(boolean startOfGame) {

		sunPoints = getSunPoints();
	}

	public Plants getPrice() {
		return price;
	}

	public void setPrice(Plants price) {
		this.price = price;
	}

	public int validatePurchase(Plants plant , int currentBalance) {

		if((currentBalance - plant.getCost()) >= 0){

			return currentBalance;
		}else {
			currentBalance = -1;
			
			
		}
		return currentBalance;
	}
	public void purchase(Plants plant , int currentBalance) {
		int updatedBalance = getSunPoints() - plant.getCost();
		setSunPoints(updatedBalance);
		System.out.println("Sun Points: " + updatedBalance);
		
	}



}


