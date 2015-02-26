package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ShootPowerUp extends PowerUp {


	public ShootPowerUp() throws SlickException {
		super(new Image("res/images/powerupPenetrate.png"));
	}

	protected void use() {
		Play.player.shots++;
		Play.player.pickUpTimeShotPowerUp = System.currentTimeMillis();
	}
}
