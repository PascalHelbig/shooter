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
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

public class GameOver extends BasicGameState{

	public GameOver(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Game Over...\nDrücke Leertaste oder Controller 'X' um fortzufahren", 100, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) 	throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE) || gc.getInput().isControlPressed(6, 0)) {
			sbg.enterState(Game.MENU, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.state;
	}
	
	private int state;
}
