package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends GameObject {
	float playerX;
	float playerY;
	float zombieX;
	
	float lastHeartLost;
	float safeTime = (float) 0.5;

	public Zombie(int pos_x, int pos_y) throws SlickException {
		super(new Image("res/images/zombie.png"), pos_x, pos_y, (float)1);
	}
	
	public void update() {
		move(this.angleTo(Play.player));
		super.update();
		
		if(intersects(Play.player)) {
			Play.player.loseHeart();
		}
	}
	
	
	public void move(float viewAngle){
		//bewege zombie im winkel zum spielen hin
		if(this.pos_x != Play.player.pos_x || this.pos_y != Play.player.pos_y){
		this.pos_y += (float) Math.cos(Math.toRadians(viewAngle)) * this.speed;
		this.pos_x -= (float) Math.sin(Math.toRadians(viewAngle)) * this.speed;
		}
	}
		
}
	


