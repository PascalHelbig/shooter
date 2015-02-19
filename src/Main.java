import game.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	

	public static void main(String[] arg) {
		try {
			AppGameContainer agc = new AppGameContainer(new Game("unser Game"));
			agc.setDisplayMode(600, 600, false);
			agc.setTargetFrameRate(60);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static boolean playerDead = false;
}