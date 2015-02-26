package objects;

import game.Play;

public class ShootPowerUp extends PowerUp {
public static int shotsOnScreen = 0;


	public ShootPowerUp() {
		super("res/images/powerupPenetrate.png");
		shotsOnScreen++;
	}

	protected void use() {
		Play.player.shots++;
		shotsOnScreen--;
	}
}
