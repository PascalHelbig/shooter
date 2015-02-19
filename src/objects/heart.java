package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class heart extends GameObject {

	public heart(float pos_x, float pos_y) throws SlickException{
		super(new Image("res/images/heart.png"), pos_x, pos_y, 0);
	}

	public void render() {
		super.render();
	}

	public void update() {
		
	}
	
}

