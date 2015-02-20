package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeartPowerUp extends PowerUp {

	public HeartPowerUp() throws SlickException {
		super(new Image("res/images/heart.png"));
	}

	protected void use() {
		System.out.println("Herz++");
	}
}
