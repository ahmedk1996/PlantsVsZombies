package Model;

public class PrintGrid {

	String [][] stringGrid;
	int rows;
	int columns;

	
	public PrintGrid(Object [][] gameGrid) {
		rows = gameGrid.length+1;
		columns = gameGrid[0].length+1;
		stringGrid = new String[rows][columns];
		copy(gameGrid);
		addingIndicator();
		printAll();
	}
	
	public void copy(Object [][] gameGrid) {
		for(int i= 1 ; i < rows; i++) {
			for(int j=1; j < columns ; j++) {
				if(gameGrid[i-1][j-1] instanceof Zombies) {
					Zombies temp = (Zombies) gameGrid[i-1][j-1];
					stringGrid[i][j] = temp.getStringtype();
				}
				else if (gameGrid[i-1][j-1] instanceof Plants) {
					Plants temp = (Plants) gameGrid[i-1][j-1];
					stringGrid[i][j] = temp.getStringtype();
				}else stringGrid[i][j] = ".    ";
				}
			}
	}
	
	public void addingIndicator() {
		stringGrid[0][0] ="     ";
		for(int column = 1; column < columns; column++)
		{
			stringGrid [0][column] = column + "    "; 
		}
		for (int row = 1; row < rows; row++)
		{
		   	stringGrid[row][0] = (row) + "    ";
		}
	}
	
	public void printAll() {
		for(int i =0;i<rows;i++) {
			for(int j =0;j<columns;j++) {
				System.out.print(stringGrid[i][j]);
			}
			System.out.println("");
		}
	}
	/*
	public static void main(String args[]) {
		Object [][] gameGrid = new Object[5][7];
		
		gameGrid[1][6] = new WalkingZombie(); 
		gameGrid[2][6] = new WalkingZombie();
		
		gameGrid[2][1] = new ShootingPlant();
		gameGrid[3][1] = new Sunflower();
		
		PrintGrid temp = new PrintGrid(gameGrid);
	}*/
	}
	

