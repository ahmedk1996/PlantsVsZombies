package Model;
import java.util.Arrays;

public class Layout {
	private static Object[][] gameGrid;

	public void createGrid() {
		int j = 0;
		gameGrid = new Object [5][7];
		System.out.print("    0        1        2        3        4        5        6  ");
		for (int i = 0; i < 5; i++) {
			System.out.println();
			System.out.println();
			System.out.println("  ");
			for (int k = 0; k<7; k++) {
				System.out.print("    -    ");
				if(k == 6) {
					
					System.out.print(j++);
				}
				
			}
		}
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
	

	
//	public static void main (String args[]) {
//		Layout layout1 = new Layout();
//		layout1.createGrid();
//		
//		System.out.println("  ");
//		System.out.println("  ");
//		
//		Layout layout2 = new Layout();
//		layout2.createGrid(5, 7);
//		
//		System.out.println("  ");
//		System.out.println("  ");
//		
//		Layout layout3 = new Layout();
//		layout3.createGrid(7, 8);
//	}
//	
}
