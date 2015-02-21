package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FreezePowerUp extends PowerUp {

	public FreezePowerUp() throws SlickException {
		super(new Image("res/images/powerupFreeze.png"));
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
