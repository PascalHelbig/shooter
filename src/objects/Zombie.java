package objects;

import java.util.ArrayList;
import java.util.List;

import game.MyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends GameObject {
	float playerX;
	float playerY;
	
	private GameObject[] bullets;
	
	public Zombie(int pos_x, int pos_y) throws SlickException {
		super(new Image("res/images/player.jpg"), pos_x, pos_y, 2);
		this.name="zombie";
	}
	
	public void update() {
		move(calculateAngle());
	}
	
	public double calculateDistance(){
		playerX= Player.position.getX();
	    playerY= Player.position.getY();
		
		float diffX= this.pos_x-playerX;
		float diffY= this.pos_y-playerY;
		
		double length = Math.sqrt(Math.pow(diffX, 2)+Math.pow(diffY, 2));
		return length;
	}
	
	public float calculateAngle(){
		float hypotenuse = Math.abs((float)calculateDistance());
		float ankathete = Math.abs(this.pos_y-playerY);
		
		float angle = ankathete/hypotenuse;
		return angle;
	}
	
	public void move(float viewAngle){
		this.pos_y -= (float) Math.cos(Math.toRadians(viewAngle)) * this.speed;
		this.pos_x += (float) Math.sin(Math.toRadians(viewAngle)) * this.speed;
	}
	
	public void getBullets(){
		for (GameObject object : MyGame.gameObjects){
			if (object.name == "shot"){
			}
				
		}
	}
}
