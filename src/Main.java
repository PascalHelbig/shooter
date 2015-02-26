import game.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	

	public static void main(String[] arg) {
		try {
			AppGameContainer agc = new AppGameContainer(new Game("unser Game"));
			agc.setDisplayMode(Game.WIDTH, Game.HEIGHT, false);
			agc.setTargetFrameRate(60);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace(); 
		}
	}

	public static boolean playerDead = false;
}