package objects;

import game.MyGame;

import org.newdawn.slick.*;

public class Player extends GameObject {

	
	public Player(int pos_x, int pos_y) throws SlickException {		
		super(new Image("res/images/guyStanding.png"), pos_x, pos_y, 3);
	}

	public void checkInputs(Input input)  {
		if(input.isKeyDown(Input.KEY_W)) {	
			this.moveUp();
			System.out.println("turning for "+this.turningAngle);
			System.out.println("old angle "+this.oldAngle);
		}
		if(input.isKeyDown(Input.KEY_S)) {
			this.moveDown();
			System.out.println("turning for "+this.turningAngle);
			System.out.println("old angle "+this.oldAngle);
		}
		if(input.isKeyDown(Input.KEY_A)) {
			this.moveLeft();
			System.out.println("turning for "+this.turningAngle);
			System.out.println("old angle "+this.oldAngle);
		}
		if(input.isKeyDown(Input.KEY_D)) {
			this.moveRight();
			System.out.println("turning for "+this.turningAngle);
			System.out.println("old angle "+this.oldAngle);
		}
	
		
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			try {
				MyGame.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.turningAngle, this.oldAngle));
				
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	
	}
}