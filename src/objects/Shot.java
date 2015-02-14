package objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shot extends GameObject {

	public Shot(float pos_x, float pos_y, float angle) throws SlickException {
		super(new Image("res/images/laser2.png"), pos_x, pos_y, 10);
		this.viewAngle =angle;
		this.image.rotate(this.viewAngle-90);
		this.name="shot";
	}

	public void update() {
		this.pos_y -= (float) Math.cos(Math.toRadians(this.viewAngle)) * this.speed;
		this.pos_x += (float) Math.sin(Math.toRadians(this.viewAngle)) * this.speed;
	}

	
	private float viewAngle;
}
