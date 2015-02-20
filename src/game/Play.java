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

import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	public Play(int state) {
		this.state = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) {

	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		scores.resetScore();
		gameObjects.clear();
		
		player = new Player(100, 100, 3);
		gameObjects.add(player);
		gameObjects.add(new HeartPowerUp());
		gameObjects.add(new FreezePowerUp());
		gameObjects.add(new KillAllPowerUp());
		for(int i = 0; i < Game.START_ZOMBIES; i++) {
			setZombie();
		}
		super.enter(container, game);

	}

	public void render(GameContainer gc, StateBasedGame sbg,
			Graphics g) {
		
		// Render alle GameObjecte
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.render();
			//g.draw(gameObject.getHitbox());
		}
		
		g.drawString("Score: " + scores.getScore() + "    Multi: " + scores.getMulti()+"x", 150, 10);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg1) {
		
		if(player.isPlayerDead()){
			sbg.enterState(Game.GAME_OVER,new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
		
		player.checkInputs(gc.getInput());
		
		//checkZombieDead();
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.update();
		}
		
		for(GameObject gameObject : Play.toDeleteObjects) {
			System.out.println("was löschen!");
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
	
	public void initPowerUps(){
		
	}

	
	private int state;
	public static Score scores = new Score();
	public static boolean playerDead = false;
	public static Player player;
	public static List<objects.GameObject> toDeleteObjects = new ArrayList<GameObject>();
	public static Shot kugel = null;
	public static Zombie getroffenerZombie = null;
	public static Collection<GameObject> gameObjects = new ArrayList<GameObject>();
	public Collection<GameObject> attribute;
	private int killingCounter = 0;
	private PowerUp specials[];
}
