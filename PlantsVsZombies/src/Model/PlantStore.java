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
	public void storeMenu(int sunPoints , boolean startOfGame) {




		System.out.println("-----------------------------");
		System.out.println("PeaShooter Plant : " + peaShooterCost + " Points. (1)");
		System.out.println("SunFlower Plant : " + sunFlowerCost + " Points. (2)");
		System.out.println("To purchase a PeaShooter Plant, enter 1.");
		System.out.println("To purchase a SunFlower Plant, enter 2.");
		System.out.println("-----------------------------");

		reader = new Scanner(System.in); 
		int num = reader.nextInt();
		label: try{ 

			if (num == 1) {
				Plants p = new ShootingPlant();
				boolean canBuy = validatePurchase(p , sunPoints);
				if (canBuy == true) {
					Layout grid = new Layout();
					grid.placePlantOnGrid(p);
					break label;
				}
			}

			if (num == 2) {
				Plants p = new Sunflower();
				boolean canBuy  = validatePurchase(p , sunPoints);	
				if (canBuy == true) {
					Layout grid = new Layout();
					grid.placePlantOnGrid(p);
					break label;
				}
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid Input");
		}

		System.out.println("You have " + getSunPoints() + " SunPoints.");
		System.out.println("Would you like to make another purchase?");

		System.out.println("Type (1) to make another purchase. Type (2) to start the new Wave");

		if (reader.nextInt() == 1) {
			if (getSunPoints()<getSunFlowerCost()) {
				System.out.println("You do not have money to buy any plants");
				System.out.println("The next wave is on its way!");
				return ;
			}else {
				
				storeMenu(getSunPoints(), false);
			}


		}


		startOfGame = false;



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
