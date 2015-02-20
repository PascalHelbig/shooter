package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

public class Game extends StateBasedGame{
	
	public static final int CONTROLLER_PORT = 0;
	public static final int WIDTH = 1023;
	public static final int HEIGHT = 700;
	public static final int SPAWN_DISTANCE = 300;
	public static final int START_ZOMBIES = 3;
	public static final int NUMBER_OF_POWERUPS = 4;
	
	public Game(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu(MENU));
		addState(new Play(PLAY));		
		addState(new GameOver(GAME_OVER));	
	}

	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int GAME_OVER= 2;
}
