package objects;


import org.newdawn.slick.*;

import java.util.*;

public class GameObject {

	protected Image image;
	protected String name;
	protected float pos_x;
	protected float pos_y;
	protected int speed;
	private int max_x = 600;
	private int max_y = 600;
	protected float viewAngle =0;
	protected float turningAngle =0;
	private String direction = "up";
	private String oldDirection;


		
	public GameObject(Image image, float pos_x2, float pos_y2, int speed) {
		this.image = image;
		this.pos_x = pos_x2;
		this.pos_y = pos_y2;
		this.speed = speed;
		this.name= "game";
	}
		
	public void render() {
		image.drawCentered(pos_x, pos_y);
	}

	public void update() {
		turnObject();
		setViewAngle();
	}

	protected void setViewAngle(){
		viewAngle += turningAngle;
		if (viewAngle > 360){viewAngle -= 360;}
		if (viewAngle < -360){viewAngle += 360;}
	}
	
	protected void moveUp() {
		// Falls das Bild den Rand überschreitet, dann ganz oben zeichnen!
		// image.getHeight()/2 -> weil Bild von der Mitte aus gezeichnet wird.
		if(this.pos_y-image.getHeight()/2 <= 0) {
			this.pos_y = image.getHeight()/2;
		} else {
			this.pos_y -= speed;
		}
		
		this.oldDirection = this.direction;
		this.direction="up";
	}

	protected void moveDown() {
		if(this.pos_y + speed + image.getHeight()/2 >= this.max_y) {
			this.pos_y = this.max_y - image.getHeight()/2;
		} else {
			this.pos_y += speed;
		}
		this.oldDirection = this.direction;
		this.direction="down";
	}

	protected void moveLeft() {
		if(this.pos_x-speed-image.getWidth()/2 <= 0) {
			this.pos_x = image.getWidth()/2;
		} else {
			this.pos_x -= speed;
		}
		this.oldDirection = this.direction;
		this.direction="left";
	}

	protected void moveRight() {
		if(this.pos_x + speed + image.getWidth()/2 >= this.max_x) {
			this.pos_x = this.max_x - image.getWidth()/2;
		} else {
			this.pos_x += speed;
		}
		this.oldDirection = this.direction;
		this.direction="right";
	}
	
	
	protected void turnObject(){
		String od = this.oldDirection;
		String d  = this.direction;
		
		this.turningAngle =0;
		
		if (od == "up" && d == "right"){this.turningAngle = 90;}
		if (od == "right" && d == "down"){this.turningAngle = 90;}
		if (od == "down" && d == "left"){this.turningAngle  = 90;}
		if (od == "left" && d == "up"){this.turningAngle = 90;}
		
		if (od == "right" && d == "up"){this.turningAngle= -90;}
		if (od == "up" && d == "left"){this.turningAngle= -90;}
		if (od == "left" && d == "down"){this.turningAngle = -90;}
		if (od == "down" && d == "right"){this.turningAngle = -90;}
		
		if (od == "left" && d == "right"){this.turningAngle  = 180;}
		if (od == "right" && d == "left"){this.turningAngle  = -180;}
		if (od == "up" && d == "down"){this.turningAngle= 180;}
		if (od == "down" && d == "up"){this.turningAngle = -180;}
		
		this.image.rotate(this.turningAngle);
		
		
	}
	
}
