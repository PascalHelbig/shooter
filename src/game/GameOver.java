package game;

import objects.Zombie;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOver extends BasicGameState{

	public GameOver(int state) {
		this.state = state;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Game Over...\n\nDein Score: " + Play.scores.getScore()
		+"\nHighscore: " + Play.highscore + newHigh
		+"\nZombies getötet: " + Zombie.killCounter
		+"\n\nDrücke Leertaste oder Controller 'X' um fortzufahren", 100, 300);
		g.setBackground(Color.black);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg2) 	throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE) || gc.getInput().isControlPressed(6, Game.CONTROLLER_PORT)) {
			sbg.enterState(Game.MENU, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
	}

	@Override
	public int getID() {
		return this.state;
	}
	
	private int state;
	public static String newHigh = "";
}
