package objects;

import game.Play;

public class ShootPowerUp extends PowerUp {


	public ShootPowerUp() {
		super("res/images/powerupPenetrate.png");
	}

	protected void use() {
		Play.player.shots++;
		Play.player.pickUpTimeShotPowerUp = System.currentTimeMillis();
	}
}
