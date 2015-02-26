package objects;

import game.Game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class GameObject {

	protected Image image;
	protected float pos_x;
	protected float pos_y;
	private float alt_pos_x;
	private float alt_pos_y;
	private float speed_change = 0;
	private long time_speed_change_ends = 0;
	protected float speed;
	protected float angle =0;
	// For Image Change ---
	private long time_image_change_ends;
	protected Image oldImage = null;
	// --- Image change end	
	protected Shape hitbox;

	public GameObject(String imagePfad, float pos_x, float pos_y, float speed) {
		try {
			this.image = new Image(imagePfad);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// For Image Change ---
		this.oldImage = image;
		// --- Image change end
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.alt_pos_x = pos_x;
		this.alt_pos_y = pos_y;
		this.hitbox = new Rectangle(this.pos_x, this.pos_y, this.image.getWidth(), this.image.getHeight());
		this.speed = speed;
	}
		
	public void render() {
		image.drawCentered(pos_x, pos_y);
	}

	public void update() {
		turnObject();
		this.alt_pos_x = this.pos_x;
		this.alt_pos_y = this.pos_y;
		setHitbox();
		
		if(System.currentTimeMillis() > this.time_speed_change_ends) {
			this.speed -= speed_change;
			this.speed_change = 0;
		}
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
		if(this.pos_y + speed + image.getHeight()/2 >= Game.HEIGHT) {
			this.pos_y = Game.HEIGHT - image.getHeight()/2;
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
		if(this.pos_x + speed + image.getWidth()/2 >= Game.WIDTH) {
			this.pos_x = Game.WIDTH - image.getWidth()/2;
		} else {
			this.pos_x += speed;
		}
	}

	public boolean outOfField(){
		Rectangle field = new Rectangle(0, 0, Game.WIDTH, Game.HEIGHT);
		return	!getHitbox().intersects(field);
	}
	
	protected void turnObject(){
		// Wenn sich die Position nicht geändert hat, dann muss nichts gedreht werden.
		if (pos_x == alt_pos_x && pos_y == alt_pos_y) {
			return;
		}

		// Berechne anhand der neuen Koordinaten, den neuen Winkel
		float new_angle = (float) Math.toDegrees(Math.atan2(this.pos_y - this.alt_pos_y, this.pos_x - this.alt_pos_x))+ 90;
		// Modulo 360, damit der Wert zwischen 0 und 360 liegt.
		new_angle %= 360;
		
		this.image.rotate(new_angle-this.angle);
		this.angle = new_angle;		
	}

	protected float angleTo(GameObject object) {
		return ((float) Math.toDegrees(Math.atan2(this.pos_y - object.pos_y, this.pos_x - object.pos_x))+ 90);
	}

	public Shape getHitbox() {
		return this.hitbox;
	}

	public boolean intersects(GameObject object) {
		return this.getHitbox().intersects(object.getHitbox());
	}

	protected float distanceTo(GameObject object) {
		float x = this.pos_x - object.pos_x;
		float y = this.pos_y - object.pos_y;
		
		return (float) Math.sqrt(x*x + y*y);
	}

	protected void setHitbox() {
		this.hitbox.setCenterX(pos_x);
		this.hitbox.setCenterY(pos_y);
	}

	public void destroy() {
	}

	public void changeSpeed(float change, int duration) {
		if (this.speed <= 3){
		this.speed_change += change;
		this.speed += change;
		this.time_speed_change_ends = System.currentTimeMillis() + duration;
		}
	}
	// For Image Change ---
	public void changeImage(String newImage, long duration){
		try {
			this.image = new Image(newImage);
			this.image.rotate(this.angle);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.time_image_change_ends = System.currentTimeMillis() + duration;
	}
	
	public boolean updateImage(boolean condition){
		if(System.currentTimeMillis() > this.time_image_change_ends && condition) {
			this.image = this.oldImage;
			return false;
		} else if(condition){
			return true;
		} else {
			return false;
		}
	}
	// --- Image Change end
}
