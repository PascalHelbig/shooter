package objects;

import game.Play;

public class Shot extends GameObject {

	public Shot(float pos_x, float pos_y, float angle) {
		super("res/images/laser.png", pos_x, pos_y, 10);
		this.angle = angle;
		this.image.rotate(angle-90);
	}

	public void update() {
		this.pos_y -= (float) Math.cos(Math.toRadians(this.angle)) * this.speed;
		this.pos_x += (float) Math.sin(Math.toRadians(this.angle)) * this.speed;
				
		for(GameObject gameObject : Play.gameObjects) {
			if(gameObject instanceof Zombie) {
				if(intersects(gameObject)) {
					Play.toDeleteObjects.add(gameObject);
					Play.toDeleteObjects.add(this);
					return;
				}
			}
		}
		if (outOfField()){
			System.out.println("drauﬂen");
			Play.toDeleteObjects.add(this);
		}
		
		super.update();
	}

	
}
