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
			setZombie(300,300);
			setZombie(100,300);
			setZombie(50,280);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(org.newdawn.slick.GameContainer gc,
			org.newdawn.slick.Graphics g) {
		g.drawString("Howdy! es geht!", 50, 50);
		
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

	private Player player;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
}
