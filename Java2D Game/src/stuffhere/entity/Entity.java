package stuffhere.entity;

import java.awt.Graphics2D;

import stuffhere.graphics.Sprite;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;
import stuffhere.level.Map;
import stuffhere.util.ResourceManager;

public abstract class Entity {

	protected Sprite sprite;
	protected int x, y;
	protected Map map;
		
	

	public Entity(int x, int y, String spritePath) {
		this.x = x;
		this.y = y;
		this.sprite = new ResourceManager().getSprite(spritePath);
	}
	
	protected void render(Graphics2D g) {

	}

	protected void update(Keyboard key, Mouse mouse) {

	}
	protected void move(int xa, int ya) {
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}



}
