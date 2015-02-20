package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeartPowerUp extends PowerUp {

	public static int heartsOnScreen =0;
	
	public HeartPowerUp() throws SlickException {
		super(new Image("res/images/heart.png"));
		heartsOnScreen++;
	}

	protected void use() {
		heartsOnScreen--;
		Play.player.addHeart();
	}
}
