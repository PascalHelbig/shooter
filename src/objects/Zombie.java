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
	
	public Zombie(int pos_x, int pos_y) throws SlickException {
		super(new Image("res/images/zombie.png"), pos_x, pos_y, 1);
	}
	
	public void update() {
		move(this.angleTo(MyGame.player));
	}
	

	public void move(float viewAngle){
		//bewege zombie im winkel zum spielen hin
		if(this.pos_x != Player.position.getX() || this.pos_y != Player.position.getY()){
		this.pos_y -= (float) Math.cos(viewAngle) * this.speed;
		this.pos_x += (float) Math.sin(viewAngle) * this.speed;
		System.out.println(viewAngle);
		}
	}
}
