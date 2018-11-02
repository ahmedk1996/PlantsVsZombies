package Plant;



import java.util.Scanner;

import Model.Layout;

public class PlantStore {

	private Plants price;
	private  int sunPoints;
	private Scanner reader;
	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	private boolean hasGameStarted = false;
	private int num;
	private Plants previousPlant;

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
	
	}

	public Plants getPrice() {
		return price;
	}

	public void setPrice(Plants price) {
		this.price = price;
	}

	public boolean validatePurchase(Plants plant , int currentBalance) {

		if((currentBalance - plant.getCost()) >= 0)  {
			int updatedBalance = currentBalance - plant.getCost();
			setSunPoints(updatedBalance);
			System.out.println("Sun Points: " + updatedBalance);
			return true;
		}else {
			System.out.println("Not Enough Sun Points!!");
		}
		return false;
	}

	
	public void storePrices() {
		System.out.println("-----------------------------");
		System.out.println("PeaShooter Plant : " + peaShooterCost + " Points. (1)");
		System.out.println("SunFlower Plant : " + sunFlowerCost + " Points. (2)");
		System.out.println("To purchase a PeaShooter Plant, enter 1.");
		System.out.println("To purchase a SunFlower Plant, enter 2.");
		System.out.println("To Continue the wave, enter 0.");
		System.out.println("-----------------------------");

	}
	
	public void storeMenu(int sunPoints  , Layout layout) {
		
		System.out.println("You have " + getSunPoints() + " SunPoints.");
		if (getSunPoints() == 0) {
			System.out.println("You can't buy anything");
			return;
		}
	
		storePrices();
		int num = reader.nextInt();
			if (num == 1) {
				Plants sp = new ShootingPlant(); 
				if (previousPlant ==null || previousPlant instanceof ShootingPlant == false) {
					boolean canBuy = validatePurchase(sp , sunPoints);
					if (canBuy == true) {	
						layout.placePlantOnGrid(sp);
					}
					else if (canBuy == false) { //cant buy but can buy another plant
							storeMenu(getSunPoints() , layout);
					}
					
				}
				
				else {
					System.out.print("Can't Purchase! The cool down to place a Shooting Plant ends next turn.");
					storeMenu(sunPoints , layout);
				}
				previousPlant = sp;
		}
		 
			else if (num == 2) {
				Plants sf = new Sunflower();
				if (previousPlant ==null || previousPlant instanceof Sunflower == false) {
					
				
					boolean canBuy  = validatePurchase(sf , sunPoints);	
					if (canBuy == true) {
	
						layout.placePlantOnGrid(sf);
					}
					
				}
				else {
					System.out.print("Can't Purchase! The cool down to place a Sun Flower Plant ends next turn.");
				}
				previousPlant = sf;
			}
			else if (num ==0) {
				return;
			}
			
			else if( num < 0 || num > 2) {
				System.out.println("Sorry but the value you entered was invalid");

			}
			
			
		
		System.out.println("Would you like to make another purchase?");
		System.out.println("Type (1) to make another purchase. Type (2) to start the new Wave");
		if (reader.nextInt() == 1) {
			storeMenu(getSunPoints()  , layout);
		}
		
		else {
			return;
		}
		



	}


	public void purchaseStartOfGame(Layout layout , boolean start) {
		if (start == true) {
		
			sunPoints = 150;
			System.out.println("");
			System.out.println("You have " + sunPoints + " points to start with!");
			System.out.println("Spend wisely.....");
			storeMenu(sunPoints  , layout);
		}
		else {
			storeMenu(getSunPoints()  , layout);
		}
		
	
		

	}


}
