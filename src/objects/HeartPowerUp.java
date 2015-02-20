package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeartPowerUp extends PowerUp {

	public HeartPowerUp() throws SlickException {
		super(new Image("res/images/heart.png"));
	}

	protected void use() {
		Play.player.addHeart();
		//Play.player.changeSpeed(5, 5000);
		for(GameObject gameObject : Play.gameObjects) {
			if (gameObject instanceof Zombie) {
				gameObject.changeSpeed(-1, 10000);
			}
		}
	}
}
