package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import objects.*;

import java.util.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	public Play(int state) {
		this.state = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) {
		try {
			player = new Player(100, 100);
			Healthbar bar = new Healthbar(3);
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
			//g.draw(gameObject.getHitbox());
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int arg1) {
		player.checkInputs(gc.getInput());
		
		updateAllObjects();
		checkZombieDead();
		checkHeartsLost();
		checkPlayerAlive();
		scores.addScore();
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
	
	public void updateAllObjects(){
		for(GameObject gameObject : Play.gameObjects) {
			gameObject.update();
		}
	}

	public void checkZombieDead(){
		if(getroffenerZombie != null) {
			Play.gameObjects.remove(getroffenerZombie);
			Play.gameObjects.remove(kugel);
			killingCounter++;
			//MyGame.gameObjects.remove(this);
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
	
	public void checkHeartsLost(){
		if(verlorenesHerz != null) {
			Play.gameObjects.remove(verlorenesHerz);
			Healthbar.lifes--;
			if (Healthbar.lifes == 0){
				playerDead=true;
			} else{
				verlorenesHerz = null;
			}
		}
	}
	
	public void checkPlayerAlive(){
		if (playerDead == true){
			System.out.println("Player dead!!!");
		}
	}
	
	public void setZombie2(int x, int y) {
		throw new UnsupportedOperationException();
	}

	private int state;
	public static Score scores = new Score();
	public static boolean playerDead = false;
	private int killingCounter = 0;
	public static Player player;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
	public static Zombie getroffenerZombie = null;
	public static Shot kugel = null;
	public static heart verlorenesHerz = null;
	public static Collection<heart> hearts = new ArrayList<heart>();
	public static Collection<GameObject> gameObjects2 = new ArrayList<GameObject>();
	public static objects.Player2 player2;
	public static Player2 attribute;
	public Collection<GameObject> attribute2;

}
