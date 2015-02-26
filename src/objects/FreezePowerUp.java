package objects;

import game.Play;

public class FreezePowerUp extends PowerUp {

	public FreezePowerUp(){
		super("res/images/powerupFreeze.png");
	}

	protected void use() {
		for(GameObject gameObject : Play.gameObjects) {
			if (gameObject instanceof Zombie) {
				// For Image Change ---
				gameObject.changeImage("res/images/freezedZombie.png",10000);
				((Zombie) gameObject).freezed = true;
				// --- Image change end
				gameObject.changeSpeed(-gameObject.speed, 10000);
			}
		}
	}
}
