package objects;

import game.Game;
import game.Play;

import org.newdawn.slick.*;

public class Player extends GameObject {
	
	public Player(int pos_x, int pos_y, int life) throws SlickException {		
		super(new Image("res/images/guy.png"), pos_x, pos_y, 5);
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
			try {
				switch (shots){
					case 1:	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
							break;
					case 2:	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-22.5f));
					   		Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+22.5f));
					   		break;
					case 3:	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-45f));
						   	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
						   	Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+45f));
						   	break;
					default:Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle-45f));
							Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle));
							Play.gameObjects.add(new Shot(this.pos_x, this.pos_y, this.angle+45f));
							break;	
				}
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
			Play.scores.resetMulti();
		}
	}
	
	public void checkShotItemTime(){
		if (System.currentTimeMillis() > pickUpShotTime + 20000){
			shots=1;
		} 
	}
	
	
	public void resetShots(){
		Player.shots=1;
		ShootPowerUp.shotsOnScreen=0;
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
	
	public static long pickUpShotTime = 0;
	public static double safeTime = 0.5;
	private Healthbar healthbar;
	public long lastHeartLost;
	public static int shots = 1;
}