package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import objects.*;

import java.util.*;

public class Play extends BasicGameState{
	
	public Play(int state, int converge) {
		this.state = state;
		this.converge= converge;
		//highscore[state] = 0;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) {

	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		scores.resetScore();
		gameObjects.clear();
		GameOver.newHigh = null;
		Zombie.killCounter = 0;
		player = new Player(100, 100, 3);
		gameObjects.add(player);
		for(int i = 0; i < Game.START_ZOMBIES; i++) {
			setZombie();
		}
		super.enter(container, game);
		nextZombieDistance = 0;
		Zombie.count = Game.START_ZOMBIES;
		PowerUp.countPowerUpsOnScreen = 0;
		GameOver.newHigh = "";
	}

	public void render(GameContainer gc, StateBasedGame sbg,
			Graphics g) {
		g.setColor(Color.white);
		
		if (Play.player.playerHit){
			g.setBackground(Color.red);
			Play.player.playerHit = false;
		} else {
			g.setBackground(Color.gray);
		}
		
		// Render alle GameObjecte
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.render();
			//g.draw(gameObject.getHitbox());
		}
		if(highscore.get(getID()) < scores.getScore()){
			highscore.put(getID(), scores.getScore());
			GameOver.newHigh = "Neuer Highscore!!!!";
		}
		g.drawString("Score: " + scores.getScore() + "    Multi: " + scores.getMulti()+"x   Highscore: "+highscore.get(getID()), 120, 10);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg1) {
		if(System.currentTimeMillis() > player.pickUpTimeShotPowerUp + 10000){
			player.resetShots();
		}
		
		if(player.isPlayerDead()){
			sbg.enterState(Game.GAME_OVER,new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
		player.checkInputs(gc.getInput());
		

		if(System.currentTimeMillis() > (lastZombie + nextZombieDistance)) {
			Play.gameObjects.add(new Zombie());
			
			lastZombie = System.currentTimeMillis();

			nextZombieDistance = (int) this.converge + (1000* 10/(Zombie.count + 1));
		}
		
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.update();
		}
		
		for(GameObject gameObject : Play.toDeleteObjects) {
			gameObject.destroy();
			gameObjects.remove(gameObject);
		}
		Play.toDeleteObjects.clear();
	}
	
	public int getID() {
		return this.state;
	}
	
	public void setZombie(){
		try {
			gameObjects.add(new Zombie());
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void createPowerUp(){
		boolean neuesPowerUpGefunden;
		if (PowerUp.countPowerUpsOnScreen < Game.MAX_POWERUP_ON_SCREEN){
			do {
				neuesPowerUpGefunden = true;
				Random rand = new Random();
				int i = rand.nextInt(Game.NUMBER_OF_POWERUPS);
				switch (i){
					case 0:
						if((player.getLifes() + HeartPowerUp.heartsOnScreen) >= 5) {
							neuesPowerUpGefunden = false; 
							break;
						}
						gameObjects.add(new HeartPowerUp());
						break;
					case 1: 
						gameObjects.add(new FreezePowerUp()); 
						break;
					case 2: 
						gameObjects.add(new KillAllPowerUp()); 
						break;
					case 3: 
						if(player.shots == 3) {
							neuesPowerUpGefunden = false; 
							break;
						}	
						gameObjects.add(new ShootPowerUp());
						break;
					case 4: 
						gameObjects.add(new SpeedPowerUp()); 
						break;	
				}
			} while (!neuesPowerUpGefunden);
		}
	}
	
	
	private int state;
	private int converge;
	public static Score scores = new Score();
	//public static int highscore[];
	public static HashMap<Integer, Integer> highscore = new HashMap<Integer, Integer>();
	public static boolean playerDead = false;
	public static Player player;
	public static List<objects.GameObject> toDeleteObjects = new ArrayList<GameObject>();
	public static Shot kugel = null;
	public static Zombie getroffenerZombie = null;
	public static Collection<GameObject> gameObjects = new ArrayList<GameObject>();
	private long lastZombie = 0;
	private long nextZombieDistance = 10000;
}
