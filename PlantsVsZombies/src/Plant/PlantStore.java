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
		/*	int updatedBalance = getSunPoints() - plant.getCost();
			setSunPoints(updatedBalance);
			System.out.println("Sun Points: " + updatedBalance); */
			return currentBalance;
		}else {
			currentBalance = -1;
			//System.out.println("Not Enough Sun Points!!");
			
		}
		return currentBalance;
	}
	public void purchase(Plants plant , int currentBalance) {
		int updatedBalance = getSunPoints() - plant.getCost();
		setSunPoints(updatedBalance);
		System.out.println("Sun Points: " + updatedBalance);
		
	}



}


