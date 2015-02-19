package objects;

public class Score {
	private static int score = 0;
	private static int multiplyer = 1;
	
	public void addScore(){
	score = score + 1 *multiplyer;
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
