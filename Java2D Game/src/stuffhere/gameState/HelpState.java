package stuffhere.gameState;

import java.awt.Graphics2D;

import stuffhere.input.Keyboard;
import stuffhere.input.Mouse;

public class HelpState extends GameState{

	public HelpState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public void init() {
		
	}

	public void update(Keyboard key, Mouse mouse) {
		key.update();
		
		if (key.back) {
			System.out.println("got back");
			gsm.setState(GameStateManager.MENUSTATE);
		}
		
		if (key.esc) {
			System.out.println("Exit from Help");
			System.exit(0);
		}
		
	}

	public void render(Graphics2D g2) {
		
	}

}
