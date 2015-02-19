package objects;

import game.MyGame;

public class Score {
	private static int score = 0;
	private static int multiplyer = 1;
	
	public void addScore(){
		if (!MyGame.playerDead){
			score = score + 1 *multiplyer;
		}
	}

public void addMulti(){
		multiplyer++;
	}

public int getScore(){
	return score;
	}

public int getMulti(){
		return multiplyer;
	}
}
