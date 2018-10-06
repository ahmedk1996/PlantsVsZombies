package Model;

public class Game {
	Layout layout = new Layout();
	
	public Game () {
		
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
	
	public static void main(String args[]) {

	}
	
}
