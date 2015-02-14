package objects;


import org.newdawn.slick.*;
import java.util.*;

public class GameObject {

	protected Image image;
	protected float pos_x;
	protected float pos_y;
	protected int speed;
	private int max_x = 600;
	private int max_y = 600;

		
	public GameObject(Image image, float pos_x2, float pos_y2, int speed) {
		this.image = image;
		this.pos_x = pos_x2;
		this.pos_y = pos_y2;
		this.speed = speed;
	}
		
	public void render() {
		image.drawCentered(pos_x, pos_y);
	}

	public void update() {
		
	}

	protected void moveUp() {
		// Falls das Bild den Rand überschreitet, dann ganz oben zeichnen!
		// image.getHeight()/2 -> weil Bild von der Mitte aus gezeichnet wird.
		if(this.pos_y-speed-image.getHeight()/2 <= 0) {
			this.pos_y = image.getHeight()/2;
		} else {
			this.pos_y -= speed;
		}
	}

	protected void moveDown() {
		if(this.pos_y + speed + image.getHeight()/2 >= this.max_y) {
			this.pos_y = this.max_y - image.getHeight()/2;
		} else {
			this.pos_y += speed;
		}
	}

	protected void moveLeft() {
		if(this.pos_x-speed-image.getWidth()/2 <= 0) {
			this.pos_x = image.getWidth()/2;
		} else {
			this.pos_x -= speed;
		}
	}

	protected void moveRight() {
		if(this.pos_x + speed + image.getWidth()/2 >= this.max_x) {
			this.pos_x = this.max_x - image.getWidth()/2;
		} else {
			this.pos_x += speed;
		}
	}

	
}
