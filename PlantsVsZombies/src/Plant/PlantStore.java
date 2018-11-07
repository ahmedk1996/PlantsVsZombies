package Plant;



import java.util.Scanner;

import Model.CoolDown;
import Model.Layout;

public class PlantStore {

	private Plants price;
	private  int sunPoints;
	private Scanner reader;
	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	private boolean hasGameStarted = false;
	private int num;
	
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
		setSunPoints(sunPoints);
	}

	public PlantStore() {
		reader = new Scanner(System.in); 
		sunPoints = 150;
	}

	public Plants getPrice() {
		return price;
	}

	public void setPrice(Plants price) {
		this.price = price;
	}

	public int validatePurchase(Plants plant , int currentBalance) {

		if((currentBalance - plant.getCost()) >= 0){
			int updatedBalance = getSunPoints() - plant.getCost();
			setSunPoints(updatedBalance);
			System.out.println("Sun Points: " + updatedBalance);
			return updatedBalance;
		}else {
			currentBalance = -1;
			//System.out.println("Not Enough Sun Points!!");
			
		}
		return currentBalance;
	}
}
/*
	
<<<<<<< HEAD
	public void storeMenu(int sunPoints  , Layout layout) {

				Plants sp = new ShootingPlant(); 
				if (previousPlant ==null || previousPlant instanceof ShootingPlant == false) {
			
						layout.placePlantOnGrid(sp);		
				}
				
	
<<<<<<< HEAD
=======
=======
>>>>>>> ef6e5997d55035f383b16bec5ddb15008fa121cd
	public void storeMenu(int sunPoints, Layout layout) {
		
		System.out.println("You have " + getSunPoints() + " SunPoints.");
		
		if (getSunPoints() == 0) {
			System.out.println("You can't buy anything");
			return ;
		}
	
		storePrices();
		int num = reader.nextInt();
			if (num == 1) {
				//Plants sp = new ShootingPlant(); 
				//if (queue.) {
				//	boolean canBuy = validatePurchase(sp , sunPoints);
//					if (canBuy == true) {	
//						layout.placePlantOnGrid(sp);
//					}
//					else if (canBuy == false) { //cant buy but can buy another plant
//							storeMenu(getSunPoints() , layout);
//					}
					
				}
				
				else {
					System.out.print("Can't Purchase! The cool down to place a Shooting Plant ends next turn.");
					storeMenu(sunPoints , layout);
				}
				//previousPlant = sp;
		}
		 
			else if (num == 2) {
>>>>>>> ef6e5997d55035f383b16bec5ddb15008fa121cd
				Plants sf = new Sunflower();
				if (previousPlant ==null || previousPlant instanceof Sunflower == false) {
					
						layout.placePlantOnGrid(sf);
					}
					
				}

<<<<<<< HEAD
<<<<<<< HEAD

}*/
=======
=======
>>>>>>> ef6e5997d55035f383b16bec5ddb15008fa121cd
	public void purchaseStartOfGame(Layout layout , boolean start) {
		if (start == true) {
		
			System.out.println("Spend wisely.....");
			storeMenu(sunPoints  , layout);
		}
		else {
			storeMenu(getSunPoints()  , layout);
		}
		
	
		

	}


}
>>>>>>> ef6e5997d55035f383b16bec5ddb15008fa121cd
