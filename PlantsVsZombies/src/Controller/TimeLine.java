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
	
	private ArrayList<Controller> timeStore;
	private Controller co;
	private int currenti;
	
	public TimeLine () {
		timeStore = new ArrayList<Controller>();
		currenti = 0;
	}
	
	public void addNext(Controller controller) {
		Controller temp = controller;
		//Controller(Game game, View view,Layout layout,PlantStore ps, Action action, Turn turn, CoolDown c,int stag)
		
		if(timeStore.size() > currenti) {
			timeStore.set(currenti, separation(temp.getGame(),temp.getView(),temp.getLayout(),temp.getPs(),temp.getAction(),temp.getTurn(),temp.getCoolDownList(),temp.getStageNum()));
			currenti ++;
		}else{ 
			timeStore.add(separation(temp.getGame(),temp.getView(),temp.getLayout(),temp.getPs(),temp.getAction(),temp.getTurn(),temp.getCoolDownList(),temp.getStageNum()));
			currenti ++;
		}
	}
	
	public Controller separation(Game game, View view,Layout layout,PlantStore ps, Action action, Turn turn, CoolDown c,int stag) {
		
		return  new Controller(game,view,layout,ps,action,turn,c,stag);
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
	
	public Controller Undo() {
		if(currenti <= 0) {
			return timeStore.get(currenti);
		}else {
			currenti--;
			return timeStore.get(currenti);
		}
	}
	
	public Controller redo() {
		return timeStore.get(currenti+1);
	}
	
	
	
}
