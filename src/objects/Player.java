package objects;

import game.MyGame;

import org.newdawn.slick.*;

public class Player extends GameObject {

	private float angle = 0;
	
	public Player(int pos_x, int pos_y) throws SlickException {		
		super(new Image("res/images/guyStanding.png"), pos_x, pos_y, 3);
	}

	public void checkInputs(Input input) {
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
	
		// Berechne den neuen Winkel zur Maus
		float angle = getAngleToMouse(input.getMouseX(), input.getMouseY());
		// Differenz 
		this.image.rotate(angle - this.angle);
		this.angle = angle;
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			try {
				MyGame.gameObjects.add(new Shot(this.pos_x, this.pos_y, angle));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	private float getAngleToMouse(int mouse_x, int mouse_y) {
		float angle = (float) Math.toDegrees(Math.atan2(mouse_y - this.pos_y, mouse_x - this.pos_x)) + 90;
		if(angle < 0){
			angle += 360;
		}
		return angle;
	}
}