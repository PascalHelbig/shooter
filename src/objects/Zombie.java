package objects;

import game.Game;
import game.Play;
import objects.GameObject;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends GameObject {
	float playerX;
	float playerY;
	float zombieX;
	
	public static int killCounter = 0;
	public static int count = 0;
	
	float lastHeartLost;
	float safeTime = (float) 0.5;


	public Zombie() {
		super("res/images/zombie.png", 0, 0, (float)1);
		if(Math.random() < Game.CHANCE_FOR_RAGE_ZOMBIE){
			try {
				this.image = new Image("res/images/rageZombie.png");
			} catch (SlickException e) {
				e.printStackTrace();
			}
			this.speed = (float)3;
			this.oldImage = this.image;
		}
		do {
			pos_x = (float) (Game.WIDTH * Math.random());
			pos_y = (float) (Game.HEIGHT * Math.random());
		} while (distanceTo(Play.player) < Game.SPAWN_DISTANCE);
		
		count++;
	}
	
	public void update() {
		// For Image Change ---
		
		// --- Image change end
		move(this.angleTo(Play.player));
		super.update();
		
		if(intersects(Play.player)) {
			Play.player.loseHeart();
			Play.player.resetShots();

		}
	}
	
	
	public void move(float viewAngle){
		//bewege zombie im winkel zum spielen hin
		if(this.pos_x != Play.player.pos_x || this.pos_y != Play.player.pos_y){
		this.pos_y += (float) Math.cos(Math.toRadians(viewAngle)) * this.speed;
		this.pos_x -= (float) Math.sin(Math.toRadians(viewAngle)) * this.speed;
		}
	}

	public void destroy() {
		killCounter++;
		Play.scores.addScore();
		Play.scores.addMulti();
		
		if((killCounter % 10) == 0) {
			Play.createPowerUp();			
		}
	}		
}
	


