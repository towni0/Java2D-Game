package stuffhere.gameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

public class GameStateManager {

	// List of all different states
	private ArrayList<GameState> gameStates;
	
	private int currentState;
	private int previousState;

	// States
	public static final int MENUSTATE = 0;
	public static final int PLAYSTATE = 1;
	public static final int HELPSTATE = 2;

	public GameStateManager() {

		gameStates = new ArrayList<GameState>();
		currentState = MENUSTATE;
		previousState = MENUSTATE;
		
		gameStates.add(new MenuState(this));
		gameStates.add(new PlayState(this));
		gameStates.add(new HelpState(this));
	}

	public void setState(int state) {
		previousState = currentState;
		currentState = state;
		
		gameStates.get(currentState).init();

	}

	public void update(Keyboard key, Mouse mouse) {
		gameStates.get(currentState).update(key, mouse);

	}

	public void render(Graphics2D g2) {
		gameStates.get(currentState).render(g2);

	}
	
	public int getPreviousState() {
		return previousState;
	}
	
}
