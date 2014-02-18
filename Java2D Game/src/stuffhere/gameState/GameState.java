package stuffhere.gameState;

import java.awt.Graphics2D;

import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

public abstract class GameState {

	
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void update(Keyboard key, Mouse mouse);
	public abstract void render(Graphics2D g2);


	
	
	public GameState() {
		
		
	}
	
	
}
