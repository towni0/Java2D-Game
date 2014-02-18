package stuffhere.level;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import stuffhere.Game;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;
import stuffhere.tiles.Flowers;
import stuffhere.tiles.Grass;
import stuffhere.tiles.Rock;
import stuffhere.tiles.Tile;
import stuffhere.tiles.VoidTile;
import stuffhere.tiles.Water;

public class Map {

	public static final int TILE_SIZE = Tile.TILE_SIZE;
	private String path;
	private int tileMapWidth, tileMapHeight;
	private int mapPixels[];

	private static Tile voidtile = new VoidTile("/tiles/void.png");
	private static Tile waterTile = new Water("/tiles/water.png");
	private static Tile grassTile = new Grass("/tiles/grass.png");
	private static Tile flowerTile = new Flowers("/tiles/flower.png");
	private static Tile rockTile = new Rock("/tiles/rock.png");

	public Map(String p) {
		this.path = p;
		readPicture(path);

	}

	private void readPicture(String path) {

		try {
			BufferedImage image = ImageIO.read(getClass().getResource(path));
			System.out.println("Succeded with reading file.");
			int w = tileMapWidth = image.getWidth();
			int h = tileMapHeight = image.getHeight();

			// Creat an array with the size of the image
			mapPixels = new int[w * h];

			// Save all the pixels data (ARGB) values in the array "mapPixels"
			image.getRGB(0, 0, w, h, mapPixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= tileMapWidth || y >= tileMapHeight)
			return voidtile;

		if (mapPixels[x + y * tileMapWidth] == 0xff00FF00)
			return grassTile;
		if (mapPixels[x + y * tileMapWidth] == 0xffB2A3FF)
			return flowerTile;

		if (mapPixels[x + y * tileMapWidth] == 0xff7F7F00)
			return rockTile;
		if (mapPixels[x + y * tileMapWidth] == 0xff0000FF)
			return waterTile;
		return voidtile;
	}

	public void drawSingleTile(Graphics2D g, int xPos, int yPos) {
		getTile(xPos, yPos).render(g, xPos, yPos, 0, 0);
	}

	public void drawTiles(Graphics2D g, int xPos, int yPos) {

		int offsetX = Game.WIDTH / 2 - Math.round(xPos) - TILE_SIZE;
		int offsetY = Game.HEIGHT / 2 - Math.round(yPos) - TILE_SIZE;

		int firstTileX = -offsetX / TILE_SIZE - 2;
		int lastTileX = firstTileX + Game.WIDTH / 48 + 4;

		int firstTileY = -offsetY / TILE_SIZE - 2;
		int lastTileY = firstTileY + Game.HEIGHT / 48 + 4;

		for (int y = firstTileY; y < lastTileY; y++) {
			for (int x = firstTileX; x < lastTileX; x++) {
				getTile(x, y).render(g, x, y, offsetX, offsetY);

			}
		}

	}

	public void update(Keyboard key, Mouse mouse) {

	}

	public void render(Graphics2D g2, int playerX, int playerY) {
		drawTiles(g2, playerX, playerY);
	}

}
