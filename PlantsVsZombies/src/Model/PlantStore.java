package Model;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlantStore {

	private Plants price;
	private int currentBalance;
	private  int sunPoints;
	private Scanner reader;

	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	private boolean hasGameStarted = false;
	private wave beginWave;
	private boolean valid;
	private int num;
	private static Layout layout;
	//private Layout grid;

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



	public PlantStore() {
		reader = new Scanner(System.in); 
		layout = new Layout();
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
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
			System.out.println("You have " + updatedBalance + " Sun Points left.");
			return true;
		}else {
			System.err.println("Not Enough Sun Points!!");
		}
		return false;
	}

	/*	public boolean endOfWave(Game game) {

		if (game.getCompleteWave() == true) {
			return true;
		}else {
			return false;
		}
	}*/
	
	public void storePrices() {
		System.out.println("-----------------------------");
		System.out.println("PeaShooter Plant : " + peaShooterCost + " Points. (1)");
		System.out.println("SunFlower Plant : " + sunFlowerCost + " Points. (2)");

	}
	
	public void storeMenu(int sunPoints , boolean startOfGame) {
		
		System.out.println("You have " + getSunPoints() + " SunPoints.");
		System.out.println("To purchase a PeaShooter Plant, enter 1.");
		System.out.println("To purchase a SunFlower Plant, enter 2.");
		System.out.println("-----------------------------");

		storePrices();
		num = reader.nextInt();
	
		if (getSunPoints() == 0) {
			return;
		}
			if (num == 1) {
				Plants sp = new ShootingPlant(); 
				boolean canBuy = validatePurchase(sp , sunPoints);
				
				if (canBuy == true) {	
					
					layout.placePlantOnGrid(sp);
				}
				else {
					System.out.println("To Start the wave, enter 0");
					System.out.println();
					num = reader.nextInt();
					if (num== 0) {
						return;
					}
					if (canBuy == false) { //cant buy but can buy another plant
						storeMenu(getSunPoints(), false);
					}
				}
			}
		 
			else if (num == 2) {
				Plants sf = new Sunflower();
				boolean canBuy  = validatePurchase(sf , sunPoints);	
				if (canBuy == true) {
					
					layout.placePlantOnGrid(sf);
					
				
				}
				else {
					if (canBuy == false) {
						System.out.println("To Start the wave, enter 0 ");
						System.out.println();
						num = reader.nextInt();
						if (num== 0) {
							return;
						}
						storeMenu(getSunPoints(), false);
					}
				}
			}

		
		System.out.println("Would you like to make another purchase?");
		System.out.println("Type (1) to make another purchase. Type (2) to start the new Wave");
		if (reader.nextInt() == 1) {
			storeMenu(getSunPoints() , false);
		}
		else {
			return;
		}
		



	}


	public void purchaseStartOfGame() {
		hasGameStarted = true;
		sunPoints = 150;
		System.out.println("");
		System.out.println("You have " + sunPoints + " points to start with!.");
		System.out.println("Spend wisely.....");
		storeMenu(sunPoints , hasGameStarted);


	}


}
