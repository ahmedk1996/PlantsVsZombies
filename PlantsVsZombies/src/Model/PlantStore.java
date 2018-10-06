package Model;

public class PlantStore {
	
	private Plants price;
	private int currentBalance;
	
	
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
	
	public int validatePurchase(Plants plant) {
		
		if((currentBalance - plant.price()) >= 0) {
			return currentBalance - plant.price();
		}else {
			System.err.println("Not enough funds");
		}
		
		
	}
	

}