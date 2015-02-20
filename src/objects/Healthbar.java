package objects;

import org.newdawn.slick.SlickException;

public class Healthbar{

	private int lifes;

	public Healthbar(int lifes) {
		this.lifes=lifes;		
	}
	
	public void render( ) {
		int x_axis= 600;
		for(int i=1 ; i <= this.lifes; i++){			
			x_axis-=40;
			try {
				Heart heart = new Heart(x_axis, 30);
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
}
