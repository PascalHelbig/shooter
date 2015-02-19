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
			gameObjects.add(player);
			setZombie(300,200);

			

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(org.newdawn.slick.GameContainer gc,
			org.newdawn.slick.Graphics g) {
		
		// Render alle GameObjecte
		for(GameObject gameObject : MyGame.gameObjects) {
			gameObject.render();
		}
	}

	public void update(org.newdawn.slick.GameContainer gc, int arg1) {
		player.checkInputs(gc.getInput());
		
		for(GameObject gameObject : MyGame.gameObjects) {
			gameObject.update();
		}
	}
	
	public void setZombie(int x, int y){
		try {
			gameObjects.add(new Zombie(x,y));
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public static Player player;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
}
