package objects;

import game.MyGame;

public class Score {
	private static int score = 0;
	private static int multiplyer = 1;
	
	public void addScore(){
		if (!MyGame.playerDead){
			score += 1 *multiplyer;
		}
	}

	public void addMulti(){
		multiplyer++;
	}

	public void resetMulti(){
		multiplyer = 1;
	}

	public int getScore(){
		return score;
	}

	public int getMulti(){
		return multiplyer;
	}
}
