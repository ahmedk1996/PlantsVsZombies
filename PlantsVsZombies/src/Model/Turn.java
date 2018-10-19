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


	public boolean canZombieSpawn(Zombies z, int interval) {

		if (z instanceof WalkingZombie) {

			if (count % interval == 0) {

				//layout.moveZombieUpOne(z);
				count++;
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean canPlantShoot(Plants p, int interval) {

		if (p instanceof ShootingPlant) {
			if (count % interval == 0) {

				ShootingPlant.shooterPlantShoot();
				count++;
				return true;
			}
			return false;
		}

		return false;
	}

	public boolean canSunFlowerGenerate(int count, Plants p, int interval) {

		if (p instanceof Sunflower) {
			if (count % interval == 0) {
				Sunflower.generateSunPoint();
				count++;
				return true;
			}
			return false;
		}
		return false;
	}
}

