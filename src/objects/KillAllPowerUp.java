package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class KillAllPowerUp extends PowerUp {

	public KillAllPowerUp() throws SlickException{
		super(new Image("res/images/powerupKillAll.png"));
	}

	protected void use() {
		for (GameObject obj : Play.gameObjects){
			if (obj instanceof Zombie){
				Play.toDeleteObjects.add(obj);
			}
		}
	}
}
