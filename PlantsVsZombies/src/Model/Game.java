package Model;

import java.util.Scanner;



public class Game {
	private Layout layout;
	private Scanner reader;
	
	public Game (Layout layout) {
		this.layout = new Layout();

	}
	
	public void start() {
		layout.createGrid();
	}
	
	public void start(int rows, int colomns) {
		layout.createGrid(rows, colomns);
	}
	
	public void redo() {
		
	}
	
	public void undo() {
		
	}
	
	public void save() {
		
	}
	
	public void load() {
		
	}
	
	public void promptStart() {
		
		reader = new Scanner(System.in);  
		System.out.println("Would you like to create a custom grid layout or continue with the default (4x7)? :");
		System.out.println("Enter 1 for custom and any number for defualt");
		int gridLayout = reader.nextInt(); 
		
		if(gridLayout == 1) {
			reader = new Scanner(System.in);
		    System.out.println("Enter a grid layout for x by y (Ex: 4x4 ): ");

		    String coordinate = reader.nextLine();
		    String[] parts = coordinate.split("x");
		    
		    String x_loc = parts[0].trim();
		    int x = Integer.parseInt(x_loc);			

		    String y_loc = parts[1].trim();
		    int y = Integer.parseInt(y_loc);			

			start(x,y);
			
		}else {
			start();
		}
	}
	
	public void placePlant() {
		
		reader = new Scanner(System.in);
	    System.out.println("Enter ");

	    String coordinate = reader.nextLine();
	    String[] parts = coordinate.split("x");
	    
	    String x_loc = parts[0].trim();
	    int x = Integer.parseInt(x_loc);			

	    String y_loc = parts[1].trim();
	    int y = Integer.parseInt(y_loc);
		
		//if()
		
	}
	
	
	public static void main(String args[]) {
		Layout layout = new Layout();
		Game game = new Game(layout);
		
		game.promptStart();
		

		

	}
	
}
