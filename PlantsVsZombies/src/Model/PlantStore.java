package Model;

import java.util.Scanner;

public class PlantStore {
	
	private Plants price;
	private int currentBalance;
	private static int sunPoints;
	private Scanner reader;
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

	private final int  peaShooterCost = 100;
	private final int  sunFlowerCost = 50;
	public PlantStore(Plants price, int currentBalance) {
		this.price=price;
		this.currentBalance=currentBalance;
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
	
	public int validatePurchase(Plants plant, Game game) {
		
		if(((currentBalance - plant.getCost()) >= 0) && endOfWave(game)) {
			return currentBalance - plant.getCost();
		}else {
			System.err.println("Not enough funds");
		}
		return currentBalance;
	}
	
	public boolean endOfWave(Game game) {
		
		if (game.getCompleteWave() == true) {
			return true;
		}else {
			return false;
		}
	}
	public void storeMenu(int sunPoints) {
		reader = new Scanner(System.in);  
		System.out.println("-----------------------------");
		System.out.println("PeaShooter Plant : " + peaShooterCost + " Points. (1)");
		System.out.println("SunFlower Plant : " + sunFlowerCost + " Points. (2)");
		System.out.println("To purchase a PeaShooter Plant, enter 1.");
		System.out.println("To purchase a SunFlower Plant, enter 2.");
		
		if (reader.nextLine() == "1") {
			
		}
		else if (reader.nextLine() == "2") {
			
		}
		
		
	}

	public void purchaseStartOfGame() {
		sunPoints = 50;
		System.out.println("");
		System.out.println("You have " + sunPoints + "points.");
		storeMenu(sunPoints);
		
		
	}
	

}
