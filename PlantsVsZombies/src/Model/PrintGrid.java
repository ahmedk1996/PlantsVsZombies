package Model;

public class PrintGrid {

	Object [][] stringGrid;
	int rows;
	int columns;
	
	public PrintGrid(Object [][] gameGrid) {
		rows = gameGrid.length+1;
		columns = gameGrid[0].length+1;
		stringGrid = new Object[rows][columns];
		copy(gameGrid);
		addingIndicator();
	}
	
	public void copy(Object [][] gameGrid) {
		for(int i= 1 ; i < rows; i++) {
			for(int j=0; j < columns-1 ; j++) {
				if(gameGrid[i-1][j] instanceof Zombies) {
					Zombies temp = (Zombies) gameGrid[i-1][j];
					stringGrid[i][j] = temp.getStringtype();
				}
				else if (gameGrid[i-1][j] instanceof Plants) {
					Plants temp = (Plants) gameGrid[i-1][j];
					stringGrid[i][j] = temp.getStringtype();
				}else stringGrid[i][j] = ".    ";
				}
			}
	}
	
	public void addingIndicator() {
		for(int row = 0; row < rows; row++)
		{
			stringGrid [0][rows] = row + " "; 
		}
		for (int column = 1; column < columns; column++)
		{
		   	stringGrid[column][columns] = (column - 1) + "    ";
		}
	}
	
}
