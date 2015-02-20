package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import objects.*;

public class Play extends BasicGameState{
	
	public Play(int state) {
		this.state = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) {

	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		gameObjects.clear();
		
		player = new Player(100, 100, 3);
		gameObjects.add(player);
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
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg1) {
		
		if(player.isPlayerDead()){
			sbg.enterState(Game.MENU,new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
		
		player.checkInputs(gc.getInput());
		
		checkZombieDead();
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.update();
		}	
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
	
	private void checkZombieDead(){
		if(getroffenerZombie != null) {
			Play.gameObjects.remove(getroffenerZombie);
			Play.gameObjects.remove(kugel);
			killingCounter++;
			getroffenerZombie = null;
			try {
				if (killingCounter % 5 == 0){
					Play.gameObjects.add(new Zombie());
					Play.gameObjects.add(new Zombie());
				} else {
					Play.gameObjects.add(new Zombie());
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	private int state;
	public static Score scores = new Score();
	public static boolean playerDead = false;
	private int killingCounter = 0;
	public static Player player;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
	public static Zombie getroffenerZombie = null;
	public static Shot kugel = null;
}
