package Model;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlantStore {

	private Plants price;
	private int currentBalance;
	private static int sunPoints;
	private Scanner reader;

	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	private boolean hasGameStarted = false;
	private wave beginWave;
	private boolean valid;
	private int num;
	private Layout layout;
	//private Layout grid;

	public static int getSunPoints() {
		return sunPoints;
	}

	public static void setSunPoints(int sunPoints) {
		PlantStore.sunPoints = sunPoints;
	}

	public int getPeaShooterCost() {
		return peaShooterCost;
	}

	public int getSunFlowerCost() {
		return sunFlowerCost;
	}



	public PlantStore() {
		reader = new Scanner(System.in); 
		
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
				boolean canBuy = validatePurchase(new ShootingPlant() , sunPoints);
				if (canBuy == true) {					
					layout.placePlantOnGrid(new ShootingPlant());
				}
				else {
					if (canBuy == false) { //cant buy but can buy another plant
						storeMenu(getSunPoints(), false);
					}
				}
			}
		 
			else if (num == 2) {
				
				boolean canBuy  = validatePurchase(new Sunflower() , sunPoints);	
				if (canBuy == true) {
					
					layout.placePlantOnGrid(new Sunflower());
				
				}
				else {
					if (canBuy == false) {
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
