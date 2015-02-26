package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player2 extends GameObject{
	public Player2(int pos_x, int pos_y) throws SlickException {		
		super(new Image("res/images/guy.png"), pos_x, pos_y, 5);
	}

	public void checkInputs(Input input)  {
		if(input.isKeyDown(Input.KEY_UP)) {	
			this.moveUp();
		}
		if(input.isKeyDown(Input.KEY_DOWN)) {
			this.moveDown();
		}
		if(input.isKeyDown(Input.KEY_LEFT)) {
			this.moveLeft();
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			this.moveRight();
		}
	
		
		
		if(input.isKeyPressed(Input.KEY_NUMPAD5)) {
			try {
				Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
				
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	
	}
}
