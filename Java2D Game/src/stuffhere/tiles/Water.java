package stuffhere.tiles;

import java.awt.Graphics2D;

public class Water extends Tile{


	public Water(String path) {
		super(path);
	}

	public void render(Graphics2D g, int x, int y, int xOffset, int yOffset) {
		g.drawImage(sprite.getImage(), x*TILE_SIZE + xOffset, y*TILE_SIZE + yOffset, TILE_SIZE, TILE_SIZE, null);
	}

}



