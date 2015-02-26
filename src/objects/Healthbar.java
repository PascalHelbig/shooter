package objects;

import game.Game;

public class Healthbar{

	private int lifes;

	public Healthbar(int lifes) {
		this.lifes=lifes;		
	}
	
	public void render( ) {
		for(int i=1 ; i <= this.lifes; i++){
			Heart heart = new Heart(Game.WIDTH - 40 * i, 30);
			heart.render();				
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
