package objects;

import org.newdawn.slick.Input;

import game.Game;
import game.Play;


public class Player extends GameObject {
	
	public Player(int pos_x, int pos_y, int life) {		
		super("res/images/guy.png", pos_x, pos_y, 5);
		this.healthbar = new Healthbar(life);
	}

	public void checkInputs(Input input)  {
		if(input.isKeyDown(Input.KEY_W) || input.isControllerUp(Game.CONTROLLER_PORT)) {	
			this.moveUp();
		}
		if(input.isKeyDown(Input.KEY_S)|| input.isControllerDown(Game.CONTROLLER_PORT)) {
			this.moveDown();
		}
		if(input.isKeyDown(Input.KEY_A)|| input.isControllerLeft(Game.CONTROLLER_PORT)) {
			this.moveLeft();
		}
		if(input.isKeyDown(Input.KEY_D)|| input.isControllerRight(Game.CONTROLLER_PORT)) {
			this.moveRight();
		}
	
		
		
		if(input.isKeyPressed(Input.KEY_SPACE) || input.isControlPressed(6, Game.CONTROLLER_PORT)) {
			switch (shots){
				case 1:	
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
					break;
				case 2:	
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-15f));
				   	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+15f));
				   	break;
				case 3:
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-30f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+30f));
					break;
				default:
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-90f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+90f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+180f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-45f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+45f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+135f));
					Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+225f));
					break;
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
			Play.scores.resetMulti();
		}
	}
	
	public void resetShots(){
		this.shots=1;
	}
	
	public void addHeart(){
		this.healthbar.addLife();	
	}
	
	public int getLifes(){
		return this.healthbar.getLifes();
	}
	
	public boolean isPlayerDead(){
		return (this.healthbar.getLifes()==0);
	}
	
	public boolean playerHit = false;
	public double safeTime = 0.5;
	private Healthbar healthbar;
	public long lastHeartLost;
	public int shots = 1;
	public long pickUpTimeShotPowerUp = 0;
}