package Controller;

import java.util.ArrayList;

import Model.Action;
import Model.CoolDown;
import Model.Game;
import Model.Layout;
import Model.Turn;
import Plant.PlantStore;
import View.View;

public class TimeLine {
	
	ArrayList<Controller> timeStore;
	int currenti;
	public TimeLine () {
		timeStore = new ArrayList<Controller>();
		currenti = 0;
	}
	
	public void addNext(Controller controller) {
		if(timeStore.size() > currenti) {
			timeStore.set(currenti, controller);
			currenti ++;
		}else{ 
			timeStore.set(currenti, controller);
			currenti ++;
		}
	}
	
	public boolean isUndoAvailable() {
		return timeStore.isEmpty();
	}
	public boolean isRedoAvailable() {
		if(timeStore.size() > currenti) {
			return true;
		}else
			return false;
	}
	
	public Controller undo() {
		return timeStore.get(currenti);
	}
	
	public Controller redo() {
		return timeStore.get(currenti+1);
	}
	
	
	
}
