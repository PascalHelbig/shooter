package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shot extends GameObject {

	public Shot(float pos_x, float pos_y, float angle) throws SlickException {
		super(new Image("res/images/laser2.png"), pos_x, pos_y, 10);
		this.angle = angle;
		this.image.rotate(angle-90);
	}

	public void update() {
		this.pos_y -= (float) Math.cos(Math.toRadians(this.angle)) * this.speed;
		this.pos_x += (float) Math.sin(Math.toRadians(this.angle)) * this.speed;
	}
}
