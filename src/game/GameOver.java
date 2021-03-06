package game;

import java.util.HashMap;

import objects.Shot;
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
		String trefferquote = String.format("%.2f", ((float)Zombie.killCounter/((float)Zombie.killCounter + (float)Shot.misssedShots))*100);
		g.setColor(Color.red);
		g.drawString("Game Over...\n\n"+newHigh+"\n\nDein Score: " + Play.scores.getScore() + "\n"
		+"\nHighscore (easy): " + Play.highscore.get(Game.PLAY_EASY)
		+"\nHighscore (medium): " + Play.highscore.get(Game.PLAY_MEDIUM)
		+"\nHighscore (hard): " + Play.highscore.get(Game.PLAY_HARD)
		+"\nHighscore (ultra): " + Play.highscore.get(Game.PLAY_ULTRA)
		+"\n\nShots verfehlt: " + Shot.misssedShots
		+"\nZombies get�tet: " + Zombie.killCounter
		+"\nTrefferquote: " + trefferquote + "%"
		+"\n\nDr�cke Escape oder Controller 'o' um fortzufahren", 100, 200);
		g.setBackground(Color.black);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg2) 	throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE) || gc.getInput().isControlPressed(5, Game.CONTROLLER_PORT)) {
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
