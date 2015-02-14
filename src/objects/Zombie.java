package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends GameObject {

	public Zombie(int pos_x, int pos_y) throws SlickException {
		super(new Image("res/images/player.jpg"), pos_x, pos_y, 2);
	}
}
