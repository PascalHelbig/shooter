package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState{

	public Menu(int state) {
		this.state = state;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Schwierigkeit auswählen...\nLeicht - 1 - X\nMedium - 2 - Kreis\nHard - 3 - Dreieck\nDu wirst nicht überleben... - 4 - Viereck\n", 100, 300);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg2) 	throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_1) || gc.getInput().isControlPressed(6, Game.CONTROLLER_PORT)) {
			sbg.enterState(Game.PLAY_EASY, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
		if(gc.getInput().isKeyPressed(Input.KEY_2) || gc.getInput().isControlPressed(5, Game.CONTROLLER_PORT)) {
			sbg.enterState(Game.PLAY_MEDIUM, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
			System.out.println("medium");
		}
		if(gc.getInput().isKeyPressed(Input.KEY_3) || gc.getInput().isControlPressed(4, Game.CONTROLLER_PORT)) {
			sbg.enterState(Game.PLAY_HARD, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
			System.out.println("hard");
		}
		if(gc.getInput().isKeyPressed(Input.KEY_4) || gc.getInput().isControlPressed(7, Game.CONTROLLER_PORT)) {
			sbg.enterState(Game.PLAY_ULTRA, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
			System.out.println("ultra");
		}
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.state;
	}
	
	private int state;
}
