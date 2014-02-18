package stuffhere.tiles;

import java.awt.Graphics2D;

import stuffhere.Game;
import stuffhere.graphics.Sprite;
import stuffhere.util.ResourceManager;


public class Tile {
	
	public static final int TILE_SIZE = Game.TILE_SIZE;

	protected Sprite sprite;
	protected String path;
	protected boolean solid = false;
	
	public Tile(String path) {
		this.path = path;
		this.sprite = ResourceManager.rm.getSprite(path);
		
	}
	
	public void render(Graphics2D g, int x, int y, int xOffset, int yOffset){
	}
	
	
	public boolean isSolid() {
		return solid;
	}
	
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
}
