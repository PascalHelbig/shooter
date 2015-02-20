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
		try {
			player = new Player(100, 100, 3);
			gameObjects.add(player);
			setZombie(300,200);
			setZombie(500,200);
			setZombie(600,600);
			setZombie(350,300);
			setZombie(500,250);
			setZombie(600,500);
			

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg,
			Graphics g) {
		
		// Render alle GameObjecte
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.render();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg1) {
		if(player.isPlayerDead()){
			sbg.enterState(Game.MENU,new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		}
		
		player.checkInputs(gc.getInput());
		
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.update();
		}
		checkZombieDead();
		System.out.println(scores.getScore());	
	}
	
	public int getID() {
		return this.state;
	}
	
	public void setZombie(int x, int y){
		try {
			gameObjects.add(new Zombie(x,y));
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void checkZombieDead(){
		if(getroffenerZombie != null) {
			Play.gameObjects.remove(getroffenerZombie);
			Play.gameObjects.remove(kugel);
			killingCounter++;
			getroffenerZombie = null;
			try {
				if (killingCounter % 5 == 0){
					Play.gameObjects.add(new Zombie(50,50));
					Play.gameObjects.add(new Zombie(300,250));
				} else {
					Play.gameObjects.add(new Zombie(50,50));
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}	

	private int state;
	public static Score scores = new Score();
	private int killingCounter = 0;
	public static Player player;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
	public static Zombie getroffenerZombie = null;
	public static Shot kugel = null;
}
