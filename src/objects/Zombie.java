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
		super(new Image("res/images/player.jpg"), pos_x, pos_y, 2);
		this.name="zombie";
	}
	
	public void update() {
		move(calculateAngle());
	}
	
	public double calculateDistanceZombieToPlayer(){
		//berechne Länge des vektors zwischen spieler und zombie
		playerX= Player.position.getX();
	    playerY= Player.position.getY();
		
		float diffX= this.pos_x-playerX;
		float diffY= this.pos_y-playerY;
		
		double length = Math.sqrt(Math.pow(diffX, 2)+Math.pow(diffY, 2));
		System.out.println("x: "+length); //passt!
		return length;

	}
	
	public float calculateAnglePoint(){
		//berechne Länge des vektors zwischen spieler und punkt3
		zombieX= this.pos_x;
	    playerY= Player.position.getY();
		
		float diffX=zombieX-Player.position.getX();
		
		System.out.println("x: "+diffX); //passt!
		return diffX;

	}
	
	public float calculateAngle(){
		//berechne winkel zwischen spieler und zombie
		float hypotenuse = (float)calculateDistanceZombieToPlayer();
		float gegenkathete = calculateAnglePoint();
		
		float angle = gegenkathete/hypotenuse;
		//angle=(float)Math.toDegrees(Math.asin(angle)); gibt gradzahl aus (zombie zu spieler winkel)
		System.out.println("Gegenkathete: "+gegenkathete+" hypotenuse: "+hypotenuse+" angle: "+Math.toDegrees(Math.asin(angle))); //passt
		return angle;
	}
	
	public void move(float viewAngle){
		//bewege zombie im winkel zum spielen hin
		if(this.pos_x != Player.position.getX() || this.pos_y != Player.position.getY()){
		this.pos_y -= (float) Math.cos(viewAngle) * this.speed;
		this.pos_x -= (float) Math.sin(viewAngle) * this.speed;
		}
	}
	
	public void getBullets(){
		for (GameObject object : MyGame.gameObjects){
			if (object.name == "shot"){
			}
				
		}
	}
}
