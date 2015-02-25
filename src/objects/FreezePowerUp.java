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
				gameObject.changeSpeed(-gameObject.speed, 10000);
			}
		}
	}
}
