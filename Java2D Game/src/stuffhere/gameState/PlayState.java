package stuffhere.gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import stuffhere.entity.inventory.items.Item;
import stuffhere.entity.mobs.Player;
import stuffhere.graphics.HUD;
import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;
import stuffhere.level.Map;

public class PlayState extends GameState{
	// Game level/map
	private Map map;
	
	// Special game instances
	private Player player;
	private HUD hud;
	
	// Test
	
	private Item item;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;

	

	// Game variables
	private int inventoryStartSize = 15;
	
	public PlayState(GameStateManager gsm) {
		this.gsm = gsm;
		init();

	}

	public void init() {
		map = new Map("/maps/level.png");
		player = new Player(4 * Map.TILE_SIZE,  4 * Map.TILE_SIZE, "/mobs/player/player2.png", inventoryStartSize);
		hud = new HUD(player);
		
		// Test
		item = new Item("sword","/HUD/one.png");
		item2 = new Item("sword","/HUD/two.png");
		item3= new Item("sword","/HUD/three.png");
		item4 = new Item("sword","/HUD/four.png");
		item5= new Item("sword","/HUD/five.png");
		item6 = new Item("sword","/HUD/red.png");

		player.getInventory().insertItem(item);
		player.getInventory().insertItem(item2);
		player.getInventory().insertItem(item3);
		player.getInventory().insertItem(item4);
		player.getInventory().insertItem(item5);
		player.getInventory().insertItem(item6);

	}

	// update stuff goes here
	public void update(Keyboard key, Mouse mouse) {

		key.update();
		player.update(key, mouse);
		hud.update(key, mouse);
		map.update(key, mouse);
		
		if (key.esc) {
			System.out.println("User pressed ESC, exiting program");
			System.exit(0);
		}
		if (key.inv) hud.changeShowInventory();
		if (key.menu ) gsm.setState(GameStateManager.MENUSTATE);
	}

	public void render(Graphics2D g2) {
		
		map.render(g2, player.getX(), player.getY());
		player.render(g2);
		hud.render(g2);
		
		g2.setColor(Color.red);
		g2.setFont(new Font("Verdana", Font.BOLD, 30));
		g2.drawString("X: " + player.getX() + "Y: " + player.getY(), 40, 200);
	}



}
