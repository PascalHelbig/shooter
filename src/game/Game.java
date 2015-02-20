package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

public class Game extends StateBasedGame{

	public Game(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu(MENU));
		addState(new Play(PLAY));		
	}

	public static final int MENU = 0;
	public static final int PLAY = 1;
}
