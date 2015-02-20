package objects;

import game.Game;

import org.newdawn.slick.SlickException;

public class Healthbar{

	private int lifes;

	public Healthbar(int lifes) {
		this.lifes=lifes;		
	}
	
	public void render( ) {
		for(int i=1 ; i <= this.lifes; i++){
			try {
				Heart heart = new Heart(Game.WIDTH - 40 * i, 30);
				heart.render();				
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	public int getLifes() {
		return this.lifes;
	}
	
	public void loseLife() {
		if(lifes > 0) {
			lifes--;
		} 
	}
	
	public void addLife() {
		lifes++;
	}
}
