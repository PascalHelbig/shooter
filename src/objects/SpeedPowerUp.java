package objects;

import game.Play;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpeedPowerUp extends PowerUp {

 public SpeedPowerUp() throws SlickException {
 super(new Image("res/images/powerupSpeed.png"));
 }

 protected void use() {
 Play.player.changeSpeed(Play.player.speed/2, 3000);
 }
}