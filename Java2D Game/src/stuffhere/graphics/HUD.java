package stuffhere.graphics;

import java.awt.Graphics2D;

import stuffhere.entity.inventory.Inventory;
import stuffhere.entity.mobs.Player;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;
import stuffhere.util.ResourceManager;

public class HUD {

	private static final int NUM_OF_ROWS = 3;
	private int imageNum = 0;
	// Player
	private Player player;

	// ResourceManager
	ResourceManager resourceManager = new ResourceManager();

	// Sprites
	private Sprite healthBar;
	private Sprite swordHealthBar;
	private Sprite inventoryBase;
	private Sprite[] inventorySprites;

	// Players inventory so we can use in here more easily
	// We wont need to update the inventory or get the inventory from the player each time either.
	private Inventory playerInventory;

	// Fields
	private boolean showInventory = false;

	public HUD(Player player) {
		this.player = player;
		updateInventoryData();

		// load sprites
		this.healthBar = resourceManager.getSprite("/HUD/healthBar.png");
		this.swordHealthBar = resourceManager.getSprite("/HUD/swordHealthBar.png");
		this.inventoryBase = resourceManager.getSprite("/HUD/inventory.png");

	}

	private void updateInventoryData() {
		playerInventory = player.getInventory();
		inventorySprites = playerInventory.getInventoryItemSprites();
	}

	public void update(Keyboard key, Mouse mouse) {
		if (player.getInventory().isHasChanged()) {
			updateInventoryData();
			player.getInventory().setHasChanged(false);
		}
	}

	public void render(Graphics2D g2) {
		g2.drawImage(swordHealthBar.getImage(), 10, 5, null);
		g2.drawImage(healthBar.getImage(), 120, 57, 9 * player.getStats().getHealth(), 10, null);

		if (showInventory) {
			// Draw the inventory background
			g2.drawImage(inventoryBase.getImage(), 700, 300, 325, 200, null);

			// Draw each of the items in the inventory
			for (int rows = 0; rows < NUM_OF_ROWS; rows++) {
				for (int cols = 0; cols < playerInventory.getInventorySize() / NUM_OF_ROWS; cols++) {
					// Makes sure we dont get an arrayIndexOutOfBounds exeption and resets the counter
					if (imageNum >= playerInventory.getInventorySize()) imageNum = 0;					
					if (imageNum < playerInventory.getInventorySize()) {
						g2.drawImage(inventorySprites[imageNum].getImage(), 725 + cols * 55, 325 + 55*rows, 50, 50, null);
						imageNum++;
					}
				}
			}
		}
	}

	public void changeShowInventory() {
		showInventory = !showInventory;
	}

}
