package objects;

import game.Play;

public class SpeedPowerUp extends PowerUp {

	public SpeedPowerUp() {
		super("res/images/powerupSpeed.png");
	}

	protected void use() {
		Play.player.changeSpeed((float)(Play.player.speed*0.6), 3000);
	}
}
