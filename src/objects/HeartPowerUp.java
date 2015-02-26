package objects;

import game.Play;

public class HeartPowerUp extends PowerUp {

	public static int heartsOnScreen =0;
	
	public HeartPowerUp() {
		super("res/images/powerupHeart.png");
		heartsOnScreen++;
	}

	protected void use() {
		heartsOnScreen--;
		Play.player.addHeart();
	}
}
