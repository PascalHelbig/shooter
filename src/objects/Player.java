package objects;

import game.Play;

import org.newdawn.slick.*;

public class Player extends GameObject {

	
	public Player(int pos_x, int pos_y) throws SlickException {		
		super(new Image("res/images/guy.png"), pos_x, pos_y, 5);
	}

	public void checkInputs(Input input)  {
		if(input.isKeyDown(Input.KEY_W)) {	
			this.moveUp();
		}
		if(input.isKeyDown(Input.KEY_S)) {
			this.moveDown();
		}
		if(input.isKeyDown(Input.KEY_A)) {
			this.moveLeft();
		}
		if(input.isKeyDown(Input.KEY_D)) {
			this.moveRight();
		}
	
		
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			try {
				Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
				
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	
	}
	public static double safeTime = 0.5;
	public static long lastHeartLost;
}