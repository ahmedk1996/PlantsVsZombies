package Model;

public class PrintGrid {
	
	static String [][] stringGrid;
	private int rows;
	private int columns;
	
	public static String[][] getStringGrid() {
		return stringGrid;
	}

	public static void setStringGrid(String[][] stringGrid) {
		PrintGrid.stringGrid = stringGrid;
	}

	
	public PrintGrid(Object [][] gameGrid) {
		rows = gameGrid.length;
		columns = gameGrid[0].length;
		stringGrid = new String[rows][columns];
		updateGrid(gameGrid);
		addingIndicator();
		printAll();
	}
	
	public void updateGrid(Object [][] gameGrid) {
		for(int i=0 ; i < rows; i++) {
			
			for(int j=0; j < columns ; j++) {
				if(gameGrid[i][j] instanceof WalkingZombie) {
					Zombies temp = (Zombies)gameGrid[i][j];
					stringGrid[i][j] = temp.getStringtype();
				}
				else if (gameGrid[i][j] instanceof Plants) {
					Plants temp =  (Plants) gameGrid[i][j];
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


	public void moveZombieUpOne(Zombies z , Object [][] gameGrid) {
		for(int i=0 ; i <gameGrid.length; i++) {
			for(int j=0; j < gameGrid[0].length ; j++) {
				if(gameGrid[i][j] instanceof WalkingZombie) {
					gameGrid[i][j] = null;
					Zombies temp = (Zombies)gameGrid[i][j-1];
					if(gameGrid[i][0] instanceof WalkingZombie) {
						gameOver();
					}
					stringGrid[i][j] =  ".    ";
					stringGrid[i][j-1] = temp.getStringtype();
				}
				else if (gameGrid[i][j] instanceof Plants) {
					gameGrid[i][j] = null;
					Plants temp =  (Plants) gameGrid[i][j-1];
					stringGrid[i][j] =  ".    ";
					stringGrid[i][j-1] = temp.getStringtype();
					
				}
		
				}
			}
	}


	
	
	private void gameOver() {
		// TODO Auto-generated method stub
		
	}

/*	public static void main(String args[]) {
		Object [][] gameGrid = new Object[5][7];
		
		gameGrid[1][6] = new WalkingZombie(); 
		gameGrid[2][6] = new WalkingZombie();
		
		gameGrid[2][1] = new ShootingPlant();
		gameGrid[3][1] = new Sunflower();
		
		PrintGrid temp = new PrintGrid(gameGrid);
	}*/
	}
	

