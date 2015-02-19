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
			player2=new Player2(300,300);
			gameObjects.add(player);
			gameObjects.add(player2);
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
			g.draw(gameObject.getHitbox());
		}
	}

	public void update(org.newdawn.slick.GameContainer gc, int arg1) {
		player.checkInputs(gc.getInput());
		player2.checkInputs(gc.getInput());
		
		for(GameObject gameObject : MyGame.gameObjects) {
			gameObject.update();
		}
		
		if(getroffenerZombie != null) {
			MyGame.gameObjects.remove(getroffenerZombie);
			//MyGame.gameObjects.remove(this);
			getroffenerZombie = null;
			try {
				MyGame.gameObjects.add(new Zombie(50,50));
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public static Player2 player2;
	public static List<objects.GameObject> gameObjects = new ArrayList<GameObject>();
	public static Zombie getroffenerZombie = null;
	public static Collection<GameObject> attribute = new ArrayList<GameObject>();
}
