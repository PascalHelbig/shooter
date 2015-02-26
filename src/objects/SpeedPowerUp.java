package objects;

import game.Play;

public class SpeedPowerUp extends PowerUp {

	public SpeedPowerUp() {
		super("res/images/powerupSpeed.png");
	}

	protected void use() {
		Play.player.changeSpeed(Play.player.speed/2, 3000);
	}
}
