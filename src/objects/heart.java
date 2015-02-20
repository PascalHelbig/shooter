package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart extends GameObject {

	public Heart(float pos_x, float pos_y) throws SlickException{
		super(new Image("res/images/heart.png"), pos_x, pos_y, 0);
	}
}

