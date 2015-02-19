package objects;

import java.util.ArrayList;
import java.util.List;

import game.MyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends GameObject {
	float playerX;
	float playerY;
	float zombieX;

	
	private GameObject[] bullets;
	
	private int life = 30;

	public Zombie(int pos_x, int pos_y) throws SlickException {
		super(new Image("res/images/zombie.png"), pos_x, pos_y, (float)1);
	}
	
	public void update() {
		move(this.angleTo(MyGame.player));
		super.update();
		
		if(getHitbox().intersects(MyGame.player.getHitbox())) {
			hitPlayer();
		}
	}
	
	
	public void move(float viewAngle){
		//bewege zombie im winkel zum spielen hin
		if(this.pos_x != MyGame.player.pos_x || this.pos_y != MyGame.player.pos_y){
		this.pos_y += (float) Math.cos(Math.toRadians(viewAngle)) * this.speed;
		this.pos_x -= (float) Math.sin(Math.toRadians(viewAngle)) * this.speed;
		}
	}

	public void hitPlayer() {
		
		for(GameObject gameObject : MyGame.gameObjects) {
			if(gameObject instanceof heart) {
				if(getHitbox().intersects(MyGame.player.getHitbox())) {
					if (System.currentTimeMillis() > (Player.lastHeartLost + Player.safeTime*1000)){
						MyGame.verlorenesHerz = (heart) gameObject;
						Player.lastHeartLost=System.currentTimeMillis();
					}
				}
			}
		}
			
			System.out.println("sys "+System.currentTimeMillis());
			System.out.println("Player "+Player.lastHeartLost);
	   }
		
	}
		
	
	


