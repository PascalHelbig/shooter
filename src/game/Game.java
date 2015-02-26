package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Game extends StateBasedGame{
	
	public static final int CONTROLLER_PORT = 0;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int SPAWN_DISTANCE = 300;
	public static final int START_ZOMBIES = 3;
	public static final int NUMBER_OF_POWERUPS = 5;
	public static final int MAX_POWERUP_ON_SCREEN = 3;
	public static final float CHANCE_FOR_RAGE_ZOMBIE = (float) 0.1;
	
	public Game(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu(MENU));
		addState(new Play(PLAY_EASY,400));	
		addState(new Play(PLAY_MEDIUM,200));
		addState(new Play(PLAY_HARD,100));
		addState(new Play(PLAY_ULTRA,0));
		addState(new GameOver(GAME_OVER));	
	}

	public static final int MENU = 0;
	public static final int PLAY_EASY = 1;
	public static final int PLAY_MEDIUM = 2;
	public static final int PLAY_HARD = 3;
	public static final int PLAY_ULTRA = 4;
	public static final int GAME_OVER= 5;
}
