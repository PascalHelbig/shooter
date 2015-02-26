package objects;

import game.Game;
import game.Play;


public class PowerUp extends GameObject {

	public PowerUp(String imagePfad) {
		super(imagePfad, 0, 0, 0);
		do {
			pos_x = (float) (Game.WIDTH * Math.random());
			pos_y = (float) (Game.HEIGHT * Math.random());
		} while (distanceTo(Play.player) < Game.SPAWN_DISTANCE);
		setHitbox();
	}

	protected void use(){

	}

	public void update() {
		if (intersects(Play.player)){
			use();
			Play.toDeleteObjects.add(this);
		}
	}
	
	
}
