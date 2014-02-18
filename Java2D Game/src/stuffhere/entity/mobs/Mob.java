package stuffhere.entity.mobs;

import java.awt.Graphics2D;

import stuffhere.entity.Entity;
import stuffhere.entity.inventory.Inventory;
import stuffhere.entity.stats.Stats;
import stuffhere.graphics.Animation.Animation;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

abstract class Mob extends Entity {

	protected Stats stats;
	protected Inventory inventory;
	
	// Animation stuff
	protected Animation animation;

	public Mob(int x, int y, String spritePath, int size) {
		super(x, y, spritePath);

		inventory = new Inventory(size);
		stats = new Stats();
		initAnimation();
	}

	protected abstract void move(int moveX, int moveY);
	
	protected abstract void update(Keyboard key, Mouse mouse);
	
	protected abstract void render(Graphics2D g2);
	
	protected abstract void initAnimation();
	
	public Stats getStats() {
		return stats;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void addFrames() {
		
	}



}
