package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeartPowerUp extends PowerUp {

	public HeartPowerUp() throws SlickException {
		super(new Image("res/images/powerupHeart.png"));
	}

	protected void use() {
		Play.player.addHeart();
	}
}
