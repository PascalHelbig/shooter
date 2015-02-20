package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ShootPowerUp extends PowerUp {
public static int shotsOnScreen = 0;

	public ShootPowerUp() throws SlickException {
		super(new Image("res/images/powerupPenetrate.png"));
		shotsOnScreen++;
	}

	protected void use() {
		Player.shots++;
		shotsOnScreen--;
	}
}
