package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlantStore {
	
	private Plants price;
	private int currentBalance;
	private static int sunPoints;
	private Scanner reader;
	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	private boolean hasGameStarted = false;
	
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
			System.out.println("You have " + updatedBalance + " Sun Points.");
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
	public void storeMenu(int sunPoints , boolean startOfGame) {
		reader = new Scanner(System.in);  
		System.out.println("-----------------------------");
		System.out.println("PeaShooter Plant : " + peaShooterCost + " Points. (1)");
		System.out.println("SunFlower Plant : " + sunFlowerCost + " Points. (2)");
		System.out.println("To purchase a PeaShooter Plant, enter 1.");
		System.out.println("To purchase a SunFlower Plant, enter 2.");
		System.out.println("-----------------------------");
		
		try{ 
			
		if (reader.nextInt() == 1) {
			Plants p = new ShootingPlant();
			boolean canBuy = validatePurchase(p , sunPoints);
			if (canBuy == true) {
				Layout grid = new Layout();
				grid.placePlantOnGrid(p);
			}
			
		}
		else if (reader.nextLine() == "2") {
			Plants p = new Sunflower();
			boolean canBuy  = validatePurchase(p , sunPoints);	
			if (canBuy == true) {
				Layout grid = new Layout();
				grid.placePlantOnGrid(p);
			}
		}
		
		System.out.println("Would you like to make another purchase?");
		startOfGame = false;
		
		}
		catch(InputMismatchException e){
			System.out.println("Invalid Input");
			
		}
	}

	public void purchaseStartOfGame() {
		hasGameStarted = true;
		sunPoints = 50;
		System.out.println("");
		System.out.println("You have " + sunPoints + " points to start with!.");
		System.out.println("Spend wisely.....");
		storeMenu(sunPoints , hasGameStarted);
		
		
	}
	

}
