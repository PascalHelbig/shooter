package objects;

import game.Play;

import org.newdawn.slick.SlickException;

public class Healthbar {

	public static int lifes;

	public Healthbar(int lifes) {
		int x_axis= 600;
		this.lifes=lifes;
		for(int i=1 ; i <= this.lifes; i++){
			x_axis-=40;
			try {
				Play.gameObjects.add(new heart(x_axis,30));
			} catch (SlickException e) {
				e.printStackTrace();
			}
			
		}
	}

	public int getLifes() {
		return this.lifes;
	}
}
