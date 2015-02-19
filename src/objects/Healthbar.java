package objects;

import game.MyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Healthbar {

	private int lifes;

	public Healthbar(int lifes) {
		int x_axis= 600;
		this.lifes=lifes;
		for(int i=1 ; i <= this.lifes; i++){
			x_axis-=40;
			try {
				MyGame.gameObjects.add(new heart(x_axis,30));
			} catch (SlickException e) {
				e.printStackTrace();
			}
			
		}
	}

	public int getLifes() {
		return this.lifes;
	}
}
