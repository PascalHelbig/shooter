package objects;

import game.Play;

import org.newdawn.slick.*;

public class Player extends GameObject {

	
	public Player(int pos_x, int pos_y) throws SlickException {		
		super(new Image("res/images/guy.png"), pos_x, pos_y, 5);
	}

	public void checkInputs(Input input)  {
		if(input.isKeyDown(Input.KEY_W) || input.isControllerUp(0)) {	
			this.moveUp();
		}
		if(input.isKeyDown(Input.KEY_S)|| input.isControllerDown(0)) {
			this.moveDown();
		}
		if(input.isKeyDown(Input.KEY_A)|| input.isControllerLeft(0)) {
			this.moveLeft();
		}
		if(input.isKeyDown(Input.KEY_D)|| input.isControllerRight(0)) {
			this.moveRight();
		}
	
		
		
		if(input.isKeyPressed(Input.KEY_SPACE) || input.isControlPressed(6, 0)) {
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