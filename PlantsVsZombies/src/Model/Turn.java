package Model;

public class Turn {
	private static int count = 1;
	private Layout layout;

	public static int getCount() {
		return count;
	}

	public Turn() {

		layout = new Layout();
	}

	public boolean canZombieMove(Zombies z, int currentTurn) {
		if (z instanceof Zombies) {
			if (currentTurn % z.getSpeed() == 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean canSunFlowerGenerate(int currentTurn , Plants p, PlantStore store) {

		if (p instanceof Sunflower) {
				if (currentTurn % p.getSpeed() == 0) {
					store.incrementSunPoints();
					return true;
				}
				return false;
			}
			return false;
		}
}

