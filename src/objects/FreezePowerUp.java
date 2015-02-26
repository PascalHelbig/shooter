package objects;

import game.Play;

public class FreezePowerUp extends PowerUp {

	public FreezePowerUp(){
		super("res/images/powerupFreeze.png");
	}

	protected void use() {
		for(GameObject gameObject : Play.gameObjects) {
			if (gameObject instanceof Zombie) {
				gameObject.changeImage("res/images/freezedZombie.png",10000);
				gameObject.changeSpeed(-gameObject.speed, 10000);
			}
		}
	}
}
