package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

import objects.*;

import java.util.*;

public class MyGame extends BasicGame{
	public MyGame(String name) {
		super(name);
	}

	public void init(org.newdawn.slick.GameContainer gc) {
		try {
			player = new Player(100, 100);
			Healthbar bar = new Healthbar(3);
			player2=new Player2(300,300);
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

	public void render(org.newdawn.slick.GameContainer gc,
			org.newdawn.slick.Graphics g) {
		
		// Render alle GameObjecte
		for(GameObject gameObject : MyGame.gameObjects) {
			gameObject.render();
			//g.draw(gameObject.getHitbox());
		}
	}

	public void update(org.newdawn.slick.GameContainer gc, int arg1) {
		player.checkInputs(gc.getInput());
		player2.checkInputs(gc.getInput());
		
		updateAllObjects();
		checkZombieDead();
		checkHeartsLost();
		checkPlayerAlive();
		scores.addScore();
		System.out.println(scores.getScore());
		
	
	}
	
	public void setZombie(int x, int y){
		try {
			gameObjects.add(new Zombie(x,y));
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void updateAllObjects(){
		for(GameObject gameObject : MyGame.gameObjects) {
			gameObject.update();
		}
	}

	public void checkZombieDead(){
		if(getroffenerZombie != null) {
			MyGame.gameObjects.remove(getroffenerZombie);
			MyGame.gameObjects.remove(kugel);
			killingCounter++;
			//MyGame.gameObjects.remove(this);
			getroffenerZombie = null;
			try {
				if (killingCounter % 5 == 0){
					MyGame.gameObjects.add(new Zombie(50,50));
					MyGame.gameObjects.add(new Zombie(300,250));
				} else {
					MyGame.gameObjects.add(new Zombie(50,50));
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void checkHeartsLost(){
		if(verlorenesHerz != null) {
			MyGame.gameObjects.remove(verlorenesHerz);
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
	
	public static Score scores = new Score();
	public static boolean playerDead = false;
	private int killingCounter = 0;
	public static Player player;
	public static Player2 player2;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
	public static Zombie getroffenerZombie = null;
	public static Shot kugel = null;
	public static heart verlorenesHerz = null;
	public Collection<GameObject> attribute;
}
