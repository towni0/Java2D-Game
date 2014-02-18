package stuffhere.entity.mobs;

import java.awt.Graphics2D;

import stuffhere.Game;
import stuffhere.graphics.Animation.Animation;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

public class Player extends Mob {

	public Player(int x, int y, String spritePath, int inventorySize) {
		super(x, y, spritePath, inventorySize);
	}

	public void move(int moveX, int moveY) {
		x += moveX;
		y += moveY;
	}

	public void initAnimation() {
		animation = new Animation();
		
//		animation.addFrame("/mobs/player/ninja.png", 5);
//		animation.addFrame("/mobs/player/ninja2.png", 5);
//		animation.addFrame("/mobs/player/ninja3.png", 5);
		
		animation.addFrame("/sfx/explosion.png", 5, "normal");
		animation.addFrame("/sfx/explosion2.png", 5, "normal");
		animation.addFrame("/sfx/explosion3.png", 5, "normal");
		animation.addFrame("/sfx/explosion4.png", 10, "normal");
		animation.addFrame("/sfx/explosion5.png", 10, "normal");
		
		animation.addFrame("/mobs/ogre/down.png", 10, "down");
		animation.addFrame("/mobs/ogre/down2.png", 10, "down");
		animation.addFrame("/mobs/ogre/down3.png", 10, "down");
		animation.addFrame("/mobs/ogre/down.png", 10, "down");

		
		animation.addFrame("/mobs/ogre/up.png", 10, "up");
		animation.addFrame("/mobs/ogre/up2.png", 10, "up");
		animation.addFrame("/mobs/ogre/up3.png", 10, "up");
		animation.addFrame("/mobs/ogre/up4.png", 10, "up");
		
		animation.addFrame("/mobs/ogre/left.png", 10, "left");
		animation.addFrame("/mobs/ogre/left2.png", 10, "left");
		animation.addFrame("/mobs/ogre/left3.png", 10, "left");
		animation.addFrame("/mobs/ogre/left4.png", 10, "left");
		
		animation.addFrame("/mobs/ogre/right.png", 10, "right");
		animation.addFrame("/mobs/ogre/right2.png", 10, "right");
		animation.addFrame("/mobs/ogre/right3.png", 10, "right");
		animation.addFrame("/mobs/ogre/right4.png", 10, "right");


		
		// Starts the animation
		animation.startAnimation();
	}

	public void update(Keyboard key, Mouse mouse) {
		
		// Makes sure that we get the right frame
		animation.update(key, mouse);
		
		key.update();

		if (key.up) {
			move(0, -getStats().getMovementSpeed());
		}

		if (key.down) {
			move(0, getStats().getMovementSpeed());
		}

		if (key.left) {
			move(-getStats().getMovementSpeed(), 0);
		}

		if (key.right) {
			move(getStats().getMovementSpeed(), 0);
		}
	}

	public void render(Graphics2D g2) {


		
		int offsetX = Game.WIDTH / 2 - Math.round(x) - 48;
		int offsetY = Game.HEIGHT / 2 - Math.round(y) - 48;

		int drawX = Math.round(x + offsetX);
		int drawY = Math.round(y + offsetY);
		
		g2.drawImage(animation.getCurrentSprite().getImage(), drawX, drawY, 100, 100, null);
	}

}
