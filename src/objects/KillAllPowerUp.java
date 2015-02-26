package objects;

import game.Play;

public class KillAllPowerUp extends PowerUp {

	public KillAllPowerUp() {
		super("res/images/powerupKillAll.png");
	}

	protected void use() {
		for (GameObject obj : Play.gameObjects){
			if (obj instanceof Zombie){
				Play.toDeleteObjects.add(obj);
			}
		}
	}
}
