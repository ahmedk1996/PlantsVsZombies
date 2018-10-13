package Model;
import java.util.*;
public class Layout {
	private static Object[][] gameGrid;
	private Scanner reader;
	public enum plants { S, F, empty , }
	
	public void createGrid() {
		int j = 0;
		gameGrid = new Object [5][7];
		//System.out.print("    0        1        2        3        4        5        6  ");
		/*for (int i = 0; i < 5; i++) {
			System.out.println();
			System.out.println();
			System.out.println("  ");
			for (int k = 0; k<7; k++) {
				System.out.print("    -    ");
				if(k == 6) {
					
					System.out.print(j++);
				}
				
			}
		}*/
		for(int row = 0; row < 5; row++)
		{
			System.out.print((row % 10) + " ");
		    for (int column = 0; column < 7; column++)
		    {
		    	gameGrid[row][column] = ".    ";
		        System.out.print(gameGrid[row][column]);
		       
		    }
		    System.out.println();
		    System.out.println();
		}
		System.out.print("  ");
		for (int column = 0; column < 7; column++)
			   System.out.print((column % 10 + "    "));
		System.out.println();
	}
	
	
	private void printGrid() {
		for(int row = 0; row < 5; row++)
		{
			System.out.print((row % 10) + " ");
		    for (int column = 0; column < 7; column++)
		    {
	    	
		    	System.out.print(gameGrid[row][column]);
	       
		    }
	    System.out.println();
	    System.out.println();
	}
	System.out.print("  ");
	for (int column = 0; column < 7; column++)
		   System.out.print((column % 10 + "    "));
	System.out.println();
	}
	
	public void createGrid(int rows, int colomns) {
		
		 gameGrid = new Object [rows][colomns];
		 int j = 0;
		for (int num = 0; num < colomns; num++) {
			System.out.print(" " + num + " ");
		}
		//System.out.print(" 0  1  2  3  4  5  6  ");
		for (int i = 0; i < rows; i++) {
			System.out.println("  ");
			for (int k = 0; k<colomns; k++) {
				System.out.print(" - ");
				if(k == colomns-1) {
					
					System.out.print(j++);
				}
				
			}
		}
	}
	
	public void placePlantOnGrid(Plants p) {
		
		try {
		reader = new Scanner(System.in);  
		System.out.println("Enter the row and column to deploy your Plant.(Ex. 4 2)");
		if (p instanceof ShootingPlant) {
			
			int inputX = reader.nextInt();
			int inputY = reader.nextInt();
			gameGrid[inputX][inputY] = "S    ";
			 printGrid();
		}
		else if (p instanceof Sunflower) {
			int inputX = reader.nextInt();
			int inputY = reader.nextInt();
			gameGrid[inputX][inputY] = "F    ";
			printGrid();
		}
		}
		catch(Exception ex) {
			ex.getMessage();
		}
	}

	public Object getGrid() {
		return gameGrid;
	}


	

}
