package Model;

public class Action {

	private Turn turn;
	private Layout layout;
	public Action() {
		int count = turn.getCount();
		count++;
	}
	
	public void plantAttack(Layout layout) {
	
		for(int i=0 ; i <Layout.getGameGrid().length; i++) {
			for(int j=0; j < Layout.getGameGrid()[0].length ; j++) {
				if(Layout.getGameGrid()[i][j] instanceof WalkingZombie) {
					Layout.getGameGrid()[i][j] = null;
					Zombies temp = (Zombies)Layout.getGameGrid()[i][j-1];
			}
		}
		}
	}
}
