package objects;

import game.Play;

import org.newdawn.slick.*;

public class Player extends GameObject {

	
	public Player(int pos_x, int pos_y, int life) throws SlickException {		
		super(new Image("res/images/guy.png"), pos_x, pos_y, 5);
		this.healthbar = new Healthbar(life);
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
	
	public void render(){
		super.render();
		this.healthbar.render();
	}
	
	public void loseHeart(){
		if((this.lastHeartLost + safeTime*1000) < System.currentTimeMillis()) {
			this.healthbar.loseLife();
			this.lastHeartLost = System.currentTimeMillis();
		}
	}
	
	public static double safeTime = 0.5;
	private Healthbar healthbar;
	public long lastHeartLost;
}